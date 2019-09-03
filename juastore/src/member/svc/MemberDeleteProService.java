package member.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberDeleteProService {

	public boolean deleteMember(Member member, String del_id) {
		// TODO Auto-generated method stub
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int deleteCount = memberDAO.deleteMember(member,del_id);
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess=true;
		}else {
			rollback(con);
		}
		close(con);
	
		return isDeleteSuccess;
	}

}
