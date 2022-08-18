package service;

import java.util.List;
import java.util.Map;

import vo.Board;
import vo.Member;

public interface IBoardService {
	//내정보 - 작성글 목록
	List<Board> getBoardListByOne(Member member);
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
	
	//좋아요 수 수정
	int modifyNice(int boardNo, Member paramMember);
	
}
