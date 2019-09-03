package member.svc;

import vo.Member;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberModProSVC {

	public boolean modInfo(Member member) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		System.out.println("memberProSVC ¾ÆÀÌµð "+member.getId());
		
		boolean result = false;
		
		int updateCount = memberDAO.updateMember(member);
		
		if(updateCount>0) {
			result = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
