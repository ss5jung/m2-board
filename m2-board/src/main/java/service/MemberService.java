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
		// DB
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
			if (conn != null) {
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
		// 리턴할 변수를 생성합니다.
		int row = 0;
		// DB 연결을 위한 Connection
		Connection conn = null;
		// 객체 생성
		dbUtil = new DBUtil();
		memberDao = new MemberDao(); // 다형성
		try {
			// DB 드라이버에 연결합니다.
			conn = dbUtil.getConnection();
			System.out.println("modifyMember 드라이버 연결 성공");
			// DAO를 call합니다.
			row = memberDao.updateMember(conn, member);
		} catch (Exception e) {
			// 어떠한 오류인지 보여주기
			e.printStackTrace();
		} finally {
			// DB 자원을 해제합니다.
			if (conn != null) {
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
	public int removeMember(Member member) {
		// 리턴할 변수를 생성합니다.
		int row = 0;
		// DB 연결을 위한 Connection
		Connection conn = null;
		// 객체 생성
		dbUtil = new DBUtil();
		memberDao = new MemberDao(); // 다형성
		try {
			// DB 드라이버에 연결합니다.
			conn = dbUtil.getConnection();
			System.out.println("removeMember 드라이버 연결 성공");
			// DAO를 call합니다.
			row = memberDao.deleteMember(conn, member);
		} catch (Exception e) {
			// 어떠한 오류인지 보여주기
			e.printStackTrace();
		} finally {
			// DB 자원을 해제합니다.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}

}
