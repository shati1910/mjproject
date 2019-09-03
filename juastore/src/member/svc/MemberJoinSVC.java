package member.svc;

import java.sql.Connection;
import vo.Member;
import static db.JdbcUtil.*;
import dao.MemberDAO;

public class MemberJoinSVC {
	public boolean joinMember(Member member) {
		boolean isJoinSuccess=false;
		Connection con=getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		try {
			int joinCount = memberDAO.InsertMember(member);
			
				if(joinCount>0) {
					commit(con);
					isJoinSuccess=true;
				}else {
					rollback(con);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isJoinSuccess;
	}
}

