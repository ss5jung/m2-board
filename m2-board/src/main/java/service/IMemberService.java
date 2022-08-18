package service;

import vo.Member;

public interface IMemberService {
	//회원 로그인
	Member getMemberLogin(Member paramMember);

	// 회원 가입 C
	int addMember(Member member);

	// 회원 정보 가져오기 R
	Member getMember();

	// 회원 정보 수정 U
	int modifyMember(Member member);

	// 회원 탈퇴 D
	int removeMember(Member member);
}
