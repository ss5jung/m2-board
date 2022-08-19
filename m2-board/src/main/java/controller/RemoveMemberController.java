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

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/removeMember")
public class RemoveMemberController extends HttpServlet {
	// remove form
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp");
		rd.forward(request, response);
	}

	// remove action
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 정보 저장할 session
		HttpSession session = request.getSession();
		// 접근제한
		if (session.getAttribute("loginMember") == null) { // 로그인이 안된 상태라면
			response.sendRedirect(request.getContextPath() + "/login"); // 로그인Controller로 보내기
			return;
		}
		//전송받은 값을 member 함수 생성 후 셋팅
		Member member = new Member();
		member.setMemberId(request.getParameter("id"));
		member.setMemberPw(request.getParameter("pw"));
		//Service call
		IMemberService memberService = new MemberService();	//다형성
		int row = memberService.removeMember(member);
		//결과 확인 후 포워딩
		if(row != 0) {	//회원탈퇴에 성공할 경우
			System.out.println("회원탈퇴 성공");
			//회원탈퇴하면 로그아웃으로 가서 세션 초기화
			response.sendRedirect(request.getContextPath() + "/logout"); 
		} else {	//회원탈퇴 실패할 경우
			System.out.println("회원탈퇴 실패");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
			rd.forward(request, response);
		}
	}

}
