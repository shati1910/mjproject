package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class AddrChangeService {

	public boolean ChAddr(Member member) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		boolean result = false;
		
		int ChCount = memberDAO.AddrChangeMember(member);
		
		if(ChCount>0) {
			commit(con);
			result = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
