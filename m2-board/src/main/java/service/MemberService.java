package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import repository.IMemberDao;
import repository.MemberDao;
import vo.Member;

public class MemberService implements IMemberService {
	private DBUtil dbUtil;
	private IMemberDao memberDao;

	@Override
	public Member getMemberLogin(Member paramMember) {
		// 리턴 객체
		Member member = new Member();
		// 객체 생성자
		dbUtil = new DBUtil();
		memberDao = new MemberDao();
		// DB
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			System.out.println("getMemberLogin DB연결 성공");
			member = memberDao.selectMemberLogin(conn, paramMember);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return member;
	}

	@Override
	public int addMember(Member member) {
		// 리턴 값
		int row = 0;
		dbUtil = new DBUtil();
		memberDao = new MemberDao();
		//DB
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			System.out.println("addMember DB연결 성공");
			row = memberDao.insertMember(conn, member);
			if (row == 0) { 
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

	@Override
	public Member getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
