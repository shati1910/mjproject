package member.svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;
import vo.Member;

public class MemberInfoSVC {

	public Member getMember(String info_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		Member member = memberDAO.SelectMember(info_id);
		
		close(con);
		
		return member;
	}

}
