package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberModSVC;
import vo.ActionForward;
import vo.Member;

public class MemberModFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id")==null) {
			response.setContentType("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요')");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}else {
			String mod_id = (String) session.getAttribute("id");
			System.out.println(mod_id);
			Member member = MemberModSVC.getMember(mod_id);
			System.out.println(member.getEmail());
			request.setAttribute("member", member);

			forward = new ActionForward();
			forward.setPath("modForm.jsp");

		}
		
		return forward;
	}

}
