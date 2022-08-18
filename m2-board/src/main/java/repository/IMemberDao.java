package repository;

import java.sql.Connection;

import vo.Member;

public interface IMemberDao {
	// 매개값 : id, pw
	// 반환값 : 세션에 저장될 Member의 정보 일부
	Member selectMemberLogin(Connection conn, Member paramMember) throws Exception;

	// 회원 가입 C
	int insertMember(Connection conn, Member member) throws Exception;

	// 회원 정보 가져오기 R
	Member selectMember(Connection conn) throws Exception;

	// 회원 정보 수정 U
	int updateMember(Connection conn, Member member) throws Exception;

	// 회원 탈퇴 D
	int deleteMember(Connection conn, Member member) throws Exception;
}
