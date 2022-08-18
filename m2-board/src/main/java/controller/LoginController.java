package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IMemberService;
import service.MemberService;
import vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private IMemberService memberService;

	// login form
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginMember") != null) { // 로그인 되어 있는 상태
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		rd.forward(request, response);
	}

	// login action
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginMember") != null) { // 로그인 되어 있는 상태
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// 전송받은 값
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// member 객체 생성 및 데이터 셋팅
		Member paramMember = new Member();
		paramMember.setMemberId(id);
		paramMember.setMemberPw(pw);
		// Service call
		memberService = new MemberService();
		Member member = memberService.getMemberLogin(paramMember);
		//예외처리
		if (member == null) {
			System.out.println("로그인 실패");
			//재실행
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		//session에 값 셋팅
		session.setAttribute("loginMember", member);
		response.sendRedirect(request.getContextPath() + "/index");
	}
}
