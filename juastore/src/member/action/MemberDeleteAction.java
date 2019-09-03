package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberDeleteProService;
import vo.ActionForward;
import vo.Member;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		Member member = new Member();
		String del_id = request.getParameter("id");
		MemberDeleteProService memberDeleteProSVC = new MemberDeleteProService();
		
		boolean isDeleteSuccess = memberDeleteProSVC.deleteMember(member,del_id);
		
		if(!isDeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴 실패. 다시 시도해 주세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}else {
			if(session.getAttribute("id").equals("admin")) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원탈퇴완료')");
				out.println("location.href='memberList.mem'");
				out.println("</script>");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('성공적으로 탈퇴가 완료되었습니다.')");
				out.println("location.href='logout.mem'");
				out.println("</script>");
			}
		}
		
		return forward;
	}

}
