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
import vo.Member;

/**
 * Servlet implementation class BoardOneClickNice
 */
@WebServlet("/boardOneNice")
public class BoardOneNiceController extends HttpServlet {
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
		// Controller의 역할
		// 1) 요청을 받아서 분석
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Member paramMember = (Member) session.getAttribute("loginMember");
		//기존에 좋아요를 한적이 있는지 확인하기 
		//한적이 없는 상태에서 눌리면 좋아요 insert
		//한적이 있는 상태에서 눌리면 좋아요 delete
		
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		boardService = new BoardService();
		int row = boardService.modifyNice(boardNo, paramMember);
		// 3) view forwarding
		if(row != 0) {
			System.out.println("좋아요 성공");
		} else {
			System.out.println("좋아요 실패");
		}
		response.sendRedirect(request.getContextPath() + "/boardOne?boardNo="+boardNo);
		
	}
}
