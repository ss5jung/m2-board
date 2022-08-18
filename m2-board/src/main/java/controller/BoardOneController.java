package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.IBoardService;
import vo.Board;

@WebServlet("/boardOne")
public class BoardOneController extends HttpServlet {
	private Board board;
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// Controller의 역할
		// 1) 요청을 받아서 분석
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo + "<-- boardNo #BoardOneController");
		// boardOne에 보여줄 board 객체가 필요하다
		// 상세보기 누르면 views 하나 올라감 <-- 선행작업
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		board = new Board();
		// service call
		boardService = new BoardService();
		// 상세보기
		board = boardService.getBoardOne(boardNo);
		request.setAttribute("board", board);
		// 3) view forwarding -jsp에 요청을 보냄
		request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp").forward(request, response);
	}
}
