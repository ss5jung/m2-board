package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMemberService;
import service.MemberService;
import vo.Member;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private IMemberService memberService;
	// addForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}

	// addAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// Controller의 역할
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberName(request.getParameter("memberName"));
		member.setMemberPw(request.getParameter("memberPw"));
		System.out.println(member);

		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		memberService = new MemberService();
		int row = memberService.addMember(member);
		// 3) view forwarding
		if (row == 1) {
			System.out.println("회원가입 성공");
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect(request.getContextPath() + "/addMember");
		}
	}
}
