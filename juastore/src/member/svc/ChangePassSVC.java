package member.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class ChangePassSVC {

	public boolean chPass(Member member) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		boolean result = false;
		
		int ChCount = memberDAO.PassChangeMember(member);
		
		if(ChCount>0) {
			result = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
