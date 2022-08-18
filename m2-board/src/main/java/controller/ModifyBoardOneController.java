package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.IBoardService;
import vo.Board;

/**
 * Servlet implementation class ModifyBoardOneController
 */
@WebServlet("/modifyBoardOne")
public class ModifyBoardOneController extends HttpServlet {
	// 수정 form
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		// 전송받은 값
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo + "<-- boardNo");
		request.setAttribute("boardNo", boardNo);
		// modifyBoardOne.jsp로 보내주기
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/modifyBoardOne.jsp");
		rd.forward(request, response);
	}

	// 수정 action
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		//인코딩
		request.setCharacterEncoding("utf-8");
		// 전송받은 값 board객체에 생성 후 셋팅
		Board paramBoard = new Board();
		paramBoard.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		paramBoard.setBoardWriter(request.getParameter("boardWriter"));
		paramBoard.setBoardTitle(request.getParameter("boardTitle"));
		paramBoard.setBoardContents(request.getParameter("boardContents"));
		System.out.println("#modifyBoard--> " + paramBoard);
		//Service call
		IBoardService boardService = new BoardService();
		int row = boardService.modifyBoard(paramBoard);
		//결과값 분기
		if(row != 0) {
			System.out.println("boardOne 수정 성공");
			request.setAttribute("board", paramBoard);
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("boardOne 수정 실패");
			response.sendRedirect(request.getContextPath()+"/boardList");
		}
		
	}

}
