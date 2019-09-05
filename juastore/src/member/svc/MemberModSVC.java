package member.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberModSVC {

	public static Member getMember(String mod_id) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		Member member = null;
		
		try {
			member=memberDAO.SelectMember(mod_id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return member;
	}

}
