package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberInfoSVC;
import vo.ActionForward;
import vo.Member;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("id")==null || (!((String)session.getAttribute("id")).equals("admin"))) {
			if(!((String)session.getAttribute("id")).equals(request.getParameter("id"))) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 해주세요.')");
			out.println("location.href='loginForm.log';");
			out.println("</script>");
			}
		}
		
		String info_id =request.getParameter("id");
			
		MemberInfoSVC memberInfoSvc = new MemberInfoSVC();
		Member member = memberInfoSvc.getMember(info_id);
			
		request.setAttribute("member", member);
		System.out.println(member.getPassword());
		forward = new ActionForward();
		forward.setPath("info.jsp");
		System.out.println(member.getId());
		
		
		return forward;
	}

}
