package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Board;
import vo.Member;

public class BoardDao implements IBoardDao {

	@Override
	public List<Board> selectBoardListByOne(Connection conn, Member member) throws Exception {
		// 리턴할 객체 생성하기
		List<Board> list = new ArrayList<Board>();
		//DB
		String sql = "SELECT board_no boardNo, board_title boardTitle, create_date createDate, board_views boardViews FROM board WHERE board_writer = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			System.out.println(stmt + "<-- stmt #selectBoardListByOne");
			rs = stmt.executeQuery();
			System.out.println(rs + "<-- rs");
			while (rs.next()) {
				// Board 객체 생성
				Board b = new Board();
				b.setBoardNo(rs.getInt("boardNo"));
				b.setBoardTitle(rs.getString("boardTitle"));
				b.setCreateDate(rs.getString("createDate"));
				b.setBoardViews(rs.getInt("boardViews"));
				list.add(b);
				System.out.println("list에 board 추가");
			}
		} finally {
			// DB자원 해제
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}

	@Override
	public int insertBoard(Connection conn, Board board) throws Exception {
		// 리턴 객체
		int row = 0;
		// DB
		PreparedStatement stmt = null;
		String sql = "INSERT INTO board (board_title, board_contents, board_writer, create_date) VALUES ( ?, ?, ?, now() )";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, board.getBoardTitle());
			stmt.setString(2, board.getBoardContents());
			stmt.setString(3, board.getBoardWriter());
			System.out.println(stmt + "<-- stmt #insertBoard");
			row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public int updateBoard(Connection conn, Board board) throws Exception {
		// 리턴 객체
		int row = 0;
		// DB
		PreparedStatement stmt = null;
		String sql = "UPDATE board SET board_title= ?, board_contents= ?, board_writer=? WHERE  board_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, board.getBoardTitle());
			stmt.setString(2, board.getBoardContents());
			stmt.setString(3, board.getBoardWriter());
			stmt.setInt(4, board.getBoardNo());
			System.out.println(stmt + "<-- stmt #updateBoard");
			row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		// 리턴 객체
		int row = 0;
		// DB
		PreparedStatement stmt = null;
		String sql = "DELETE FROM board WHERE  board_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			System.out.println(stmt + "<-- stmt #deleteBoard");
			row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public int updateNice(Connection conn, int boardNo, String memberId) throws Exception {
		int row = 0;
		// DB
		PreparedStatement stmt = null;
		String sql = "INSERT INTO nice (board_no, member_id, create_date) VALUES (?, ?, now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			stmt.setString(2, memberId);
			System.out.println(stmt + "<-- stmt #updateNice");
			row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public int selectNice(Connection conn, int boardNo, String memberId) throws Exception {
		// 리턴값
		int row = 0;
		// DB
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM nice WHERE board_no = ? and member_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			stmt.setString(2, memberId);
			System.out.println(stmt + "<-- stmt #selectNice");
			rs = stmt.executeQuery();
			if (rs.next()) { // 쿼리가 실행된다면
				row = rs.getInt("cnt");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public int deleteNice(Connection conn, int boardNo, String memberId) throws Exception {
		// 리턴 객체
		int row = 0;
		// DB
		PreparedStatement stmt = null;
		String sql = "DELETE FROM nice WHERE  board_no=? AND member_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			stmt.setString(2, memberId);
			System.out.println(stmt + "<-- stmt #deleteNice");
			row = stmt.executeUpdate();
			if (row == 0) { // 좋아요 취소에 실패했다면
				throw new Exception();
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public void updateViews(Connection conn, int boardNo, int boardViews) throws Exception {
		int row = 0;
		int newViews = boardViews + 1;
		// DB
		PreparedStatement stmt = null;
		String sql = "UPDATE board SET board_views= ? WHERE board_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, newViews);
			stmt.setInt(2, boardNo);
			System.out.println(stmt + "<-- stmt #updateViews");
			row = stmt.executeUpdate();
			if (row == 0) {
				throw new Exception();
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public Board selectBoardOne(Connection conn, int boardNo) throws Exception {
		// 리턴 객체 생성
		Board board = null;
		// DB
		PreparedStatement stmt = null;
		String sql = "SELECT b.board_no boardNo, b.board_title boardTitle, b.board_contents boardContents, b.create_date createDate, b.board_writer boardWriter,b.board_views boardViews, IFNULL(t.cnt, 0) boardNice from board b LEFT JOIN (select board_no, count(*) cnt from nice group by board_no) t using(board_no) WHERE board_no = ?";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, boardNo);
			System.out.println(stmt + "<-- stmt");
			rs = stmt.executeQuery();
			if (rs.next()) {// rs가 실행되면
				board = new Board();
				board.setBoardNo(rs.getInt("boardNo"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardContents(rs.getString("boardContents"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setCreateDate(rs.getString("createDate"));
				board.setBoardViews(rs.getInt("boardViews"));
				board.setBoardNice(rs.getInt("boardNice"));
				System.out.println("boardOne 데이터 셋팅 완료");
			}
			if (board == null) {
				throw new Exception();
			}
		} finally {
			// DB자원해제
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return board;
	}

	@Override
	public List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception {
		// 리턴할 객체 생성하기
		List<Board> list = new ArrayList<Board>();

		String sql = "SELECT b.board_no boardNo, b.board_title boardTitle, b.create_date createDate, b.board_writer boardWriter,b.board_views boardViews, IFNULL(t.cnt, 0) boardNice from board b LEFT JOIN (select board_no, count(*) cnt from nice group by board_no) t using(board_no) ORDER BY b.create_date DESC LIMIT ?,?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			System.out.println(stmt + "<-- stmt ###selectBoardListByPage");
			rs = stmt.executeQuery();
			System.out.println(rs + "<-- rs");
			while (rs.next()) {
				// Board 객체 생성
				Board b = new Board();
				b.setBoardNo(rs.getInt("boardNo"));
				b.setBoardTitle(rs.getString("boardTitle"));
				b.setBoardWriter(rs.getString("boardWriter"));
				b.setCreateDate(rs.getString("createDate"));
				b.setBoardViews(rs.getInt("boardViews"));
				b.setBoardNice(rs.getInt("boardNice"));
				list.add(b);
			}
		} finally {
			// DB자원 해제
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}

	@Override
	public int selectBoardCnt(Connection conn) throws Exception {
		// 리턴 값
		int lastPage = 0;
		// DB
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) totalCnt FROM board";
		try {
			stmt = conn.prepareStatement(sql);
			System.out.println(stmt + "<-- stmt");
			rs = stmt.executeQuery();
			System.out.println(rs + "<-- rs");
			if (rs.next()) {
				lastPage = rs.getInt("totalCnt");
			}
		} finally {
			// DB자원해제
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return lastPage;
	}

}
