package member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Member;

public class MemberFindIdService {

	public int getFindListCount(String findId) {
		// TODO Auto-generated method stub
		int findListCount = 0;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		findListCount = memberDAO.selectFindListCount(findId);
		close(con);
		return findListCount;
	}

	public ArrayList<Member> getmemList(int page, int limit, String findId) {
		// TODO Auto-generated method stub
		
		System.out.println(findId);
		ArrayList<Member> memlist = null;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		memlist = memberDAO.SelectFindMemList(page,limit,findId);
		close(con);
		return memlist;
	}

	

}
