package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberModProSVC;
import vo.ActionForward;
import vo.Member;

public class MemberModProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α����� �ϼ���')");
			out.println("location.href='loginFrom.jsp'");
			out.println("</script>");
		}else {
			request.setCharacterEncoding("UTF-8");
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member.setName(request.getParameter("name"));
			member.setEmail(request.getParameter("email"));
			member.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
			member.setAddress(request.getParameter("address"));
			member.setPhone(request.getParameter("phone"));
			
			MemberModProSVC memberModProSvc = new MemberModProSVC();
			boolean result = memberModProSvc.modInfo(member);
			
			if(!result) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('���������� ������ �߻��߽��ϴ�. �ٽ� �ۼ��ϼ���.')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('���� ������ �Ϸ�Ǿ����ϴ�.')");
				out.println("location.href='modify.mem'");
				out.println("</script>");
			}
		}
		return forward;
	}

}
