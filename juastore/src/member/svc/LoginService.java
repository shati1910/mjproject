package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import vo.Member;
import dao.MemberDAO;

public class LoginService {

	public Member memberLogin(String id) {
		// TODO Auto-generated method stub
		
		
		Connection con = getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		Member member = null;
		
		try {
			member=memberDAO.SelectMember(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return member;
	}
	
}
