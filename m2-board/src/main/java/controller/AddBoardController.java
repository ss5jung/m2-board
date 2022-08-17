package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;
import vo.Board;

@WebServlet("/addBoard")
public class AddBoardController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Controller의 역할
		// 1) 요청을 받아서 분석
		String boardTitle = request.getParameter("boardTitle");
		System.out.println(boardTitle +"<-- boardTitle");
		String boardContents = request.getParameter("boardContents");
		System.out.println(boardContents +"<-- boardContents");
		String boardWriter = request.getParameter("boardWriter");
		System.out.println(boardWriter +"<-- boardWriter");
		// board 객체 생성 및 셋팅
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContents(boardContents);
		board.setBoardWriter(boardWriter);
		
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		boardService = new BoardService();
		int row = boardService.addBoard(board);
		// 3) view forwarding
		if (row == 1) { 
			System.out.println("게시글 추가 성공");
			request.getRequestDispatcher("/WEB-INF/view/boardList.jsp").forward(request, response);
			//???왜 리스트로 안가지
		} else {
			System.out.println("게시글 추가 실패");
			doGet(request, response);
		}
	}

}
