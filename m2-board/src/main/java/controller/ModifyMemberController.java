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

@WebServlet("/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 수정 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		// modifyMember.jsp로 보내주기
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp");
		rd.forward(request, response);
	}

	// 수정 action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		// 인코딩
		request.setCharacterEncoding("utf-8");
		//로그인 정보(id)를 담은 새로운 member 객체 생성한다.
		Member member = (Member) session.getAttribute("loginMember");
		//전송받은 값(비밀번호, 전화번호, 주소) 셋팅
		member.setMemberPw(request.getParameter("memberPw"));
		member.setMemberPhone(request.getParameter("memberPhone"));
		String memberAddress = request.getParameter("newMemberAddr") + " " +request.getParameter("newMemberDetailAddr");
		member.setMemberAddress(memberAddress);
		System.out.println("#수정할 회원정보 : " + member);
		//service call
		IMemberService memberService = new MemberService();	//다형성
		int row = memberService.modifyMember(member);
		// 결과값 분기
		if (row != 0) {
			System.out.println("회원정보 수정 성공");
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			System.out.println("회원정보 수정 실패");
			response.sendRedirect(request.getContextPath() + "/modifyMember");
		}
	}

}
