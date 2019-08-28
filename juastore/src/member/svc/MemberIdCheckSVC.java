package member.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberIdCheckSVC {

	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		boolean check_id = false;
		
		Member member = memberDAO.SelectMember(id);
		
		if(member == null) {
			check_id = true;
			
			close(con);
		}
		
		return check_id;
	}

}
