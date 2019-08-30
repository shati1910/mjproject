package member.svc;

import java.util.ArrayList;

import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.Member;
import java.sql.Connection;

public class MemberListService {

	public int getListCount() {
		// TODO Auto-generated method stub
		int listCount = 0;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		listCount = memberDAO.selectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<Member> getmemList(int page, int limit, String search) {
		// TODO Auto-generated method stub

		ArrayList<Member> memlist = null;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		memlist = memberDAO.SelectMemList(page,limit,search);
		close(con);
		return memlist;
	}

}
