package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao implements IMemberDao {

	@Override
	public Member selectMemberLogin(Connection conn, Member paramMember) throws Exception {
		// 리턴 객체
		Member member = null;
		// DB
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id memberId, member_name memberName FROM member WHERE member_id = ? and member_pw=PASSWORD(?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramMember.getMemberId());
			stmt.setString(2, paramMember.getMemberPw());
			System.out.println(stmt + "<-- stmt - #selectMemberLogin");
			rs = stmt.executeQuery();
			if (rs.next()) {	//실행이 되면
				System.out.println("rs실행 성공");
				member = new Member();
				member.setMemberId(rs.getString("memberId"));
				member.setMemberName(rs.getString("memberName"));
				System.out.println("#로그인 정보" + member);
			}
		} finally {
			// DB자원 해제
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return member;
	}

	@Override
	public int insertMember(Connection conn, Member member) throws Exception {
		//리턴값
		int row = 0;
		//DB
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member (member_id, member_pw, member_name) VALUES (?, PASSWORD(?), ?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.setString(3, member.getMemberName());
			System.out.println(stmt + "<-- stmt");
			row = stmt.executeUpdate();
			if(row == 0) {
				throw new Exception();
			}
		} finally {
			//DB 자원 해제
			if(stmt != null) {
				stmt.close();
			}
		}
		return row;
	}

	@Override
	public Member selectMember(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(Connection conn, Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(Connection conn, Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
