package service;

import java.util.Map;

import vo.Board;

public interface IBoardService {
	// 게시글 작성 C
	int addBoard(Board board);

	// 상세보기 R
	// 상세보기 + 클릭시 조회수 +1
	Board getBoardOne(int boardNo);

	// 게시글 리스트 R
	// 반환 값 : List<Board>, lastPage 구하기
	Map<String, Object> getBoardList(int rowPerPage, int currentPage);

	// 게시글 수정 U
	int modifyBoard(Board board);

	// 게시글 삭제 D
	int removeBoard(int boardNo);
	
	//좋아요 수 올리기
	void modifyNice(int boardNo, int boardNice);
	
}
