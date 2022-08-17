package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;

/**
 * Servlet implementation class BoardOneClickNice
 */
@WebServlet("/boardOneNice")
public class BoardOneNiceController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Controller의 역할
		// 1) 요청을 받아서 분석
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int boardNice = Integer.parseInt(request.getParameter("boardNice"));
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		boardService = new BoardService();
		boardService.modifyNice(boardNo, boardNice);
		// 3) view forwarding
		request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp").forward(request, response);
	}
}
