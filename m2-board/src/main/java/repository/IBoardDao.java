package repository;

import java.sql.Connection;
import java.util.List;

import vo.Board;

public interface IBoardDao {
	// 게시글 작성 C
	int insertBoard(Connection conn, Board board) throws Exception;

	// 게시글 리스트 R
	List<Board> selectBoardListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception;

	// 상세보기 R
	Board selectBoardOne(Connection conn, int boardNo) throws Exception;

	// 게시글 수정 U
	int updateBoard(Connection conn, Board board) throws Exception;

	// 게시글 삭제 D
	int deleteBoard(Connection conn, int boardNo) throws Exception;

	// lastPage 구하기
	int selectBoardCnt(Connection conn) throws Exception;

	// 기존에 좋아요를 한적이 있는지 확인
	int selectNice(Connection conn, int boardNo, String memberId) throws Exception;

	// 좋아요 수 올리기
	int updateNice(Connection conn, int boardNo, String memberId) throws Exception;

	// 좋아요 취소
	int deleteNice(Connection conn, int boardNo, String memberId) throws Exception;

	// 조회수 올리기
	void updateViews(Connection conn, int boardNo, int boardViews) throws Exception;

}
