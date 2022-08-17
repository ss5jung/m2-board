package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import repository.BoardDao;
import repository.IBoardDao;
import vo.Board;

public class BoardService implements IBoardService {
	private DBUtil dbUtil;
	private IBoardDao boardDao;

	@Override
	public int addBoard(Board board) {
		// 리턴할 객체
		int row = 0;
		// DB
		Connection conn = null;
		try {
			// 객체 생성
			dbUtil = new DBUtil();
			boardDao = new BoardDao();
			// DB
			conn = dbUtil.getConnection();
			System.out.println("#addBoard DB 연결 성공");
			row = boardDao.insertBoard(conn, board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	@Override
	public void modifyNice(int boardNo, int boardNice) {
		// DB
		Connection conn = null;
		try {
			// 객체 생성
			dbUtil = new DBUtil();
			boardDao = new BoardDao();
			// DB
			conn = dbUtil.getConnection();
			System.out.println("#modifyNice DB 연결 성공");
			boardDao.updateNice(conn, boardNo, boardNice);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int modifyBoard(Board board) {
		// 리턴할 객체
		int row = 0;
		// DB
		Connection conn = null;
		try {
			// 객체 생성
			dbUtil = new DBUtil();
			boardDao = new BoardDao();
			// DB
			conn = dbUtil.getConnection();
			System.out.println("#modifyBoard DB 연결 성공");
			row = boardDao.updateBoard(conn, board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	@Override
	public int removeBoard(int boardNo) {
		// 리턴할 객체
		int row = 0;
		// DB
		Connection conn = null;
		try {
			// 객체 생성
			dbUtil = new DBUtil();
			boardDao = new BoardDao();
			// DB
			conn = dbUtil.getConnection();
			System.out.println("#removeBoard DB 연결 성공");
			row = boardDao.deleteBoard(conn, boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	@Override
	public Board getBoardOne(int boardNo) {
		// 리턴할 객체 생성
		Board board = null;
		// DB
		Connection conn = null;
		try {
			// DB연결
			conn = new DBUtil().getConnection();
			boardDao = new BoardDao();
			System.out.println("#getBoardOne - DB 연결 성공");
			// 개별 커밋 해제
			conn.setAutoCommit(false);
			// DAO call
			board = boardDao.selectBoardOne(conn, boardNo);
			if (board != null) { // board 객체에 전송된 값이 없다면
				boardDao.updateViews(conn, boardNo, board.getBoardViews());
			} else {
				throw new Exception(); // 예외처리
			}
			// 실행 전체 적용
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();	//예외 발생시 rollback하기
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return board;
	}

	// 반환 값 : List<Board>, lastPage 구하기
	@Override
	public Map<String, Object> getBoardList(int rowPerPage, int currentPage) {
		// 리턴할 객체 생성
		Map<String, Object> map = new HashMap<String, Object>();
		// 변수
		int beginRow = (currentPage - 1) * rowPerPage;
		// DB
		Connection conn = null;
		try {
			// DAO 객체 생성
			boardDao = new BoardDao();
			dbUtil = new DBUtil();
			// DB 연결
			conn = dbUtil.getConnection();
			System.out.println("#getBoardList - DB 연결 성공");
			// 게시글 리스트 DAO에서 받아오기
			List<Board> list = boardDao.selectBoardListByPage(conn, rowPerPage, beginRow);
			if (list != null) {
				map.put("list", list);
			}
			// lastPage DAO에서 받아오기
			int lastPage = boardDao.selectBoardCnt(conn);
			map.put("lastPage", lastPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB자원 해제
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
