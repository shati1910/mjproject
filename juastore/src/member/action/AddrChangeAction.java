package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.AddrChangeService;
import vo.ActionForward;
import vo.Member;

public class AddrChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("id");
		
		System.out.println(id +"  ������Ʈ��:"+request.getParameter("id"));
		if(request.getParameter("zip_code")!=null && request.getParameter("addr1") != null) {
			response.setContentType("text/html;charset=UTF-8");
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
			member.setAddress(request.getParameter("addr1")+request.getParameter("addr2")+request.getParameter("exaddr"));
			AddrChangeService addrChangeSvc = new AddrChangeService();
			boolean addrResult= addrChangeSvc.ChAddr(member);
			
			if(!addrResult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('�ּ� ���濡 ������ �߻��߽��ϴ�. �ٽ� �ۼ��ϼ���.')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				if(session.getAttribute("id").equals("admin")) {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('�ּҺ����� �Ϸ�Ǿ����ϴ�.')");
					out.println("location.href='memberList.mem'");
					out.println("</script>");
				}else {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('�ּҺ����� �Ϸ�Ǿ����ϴ�.')");
					out.println("location.href='modify.mem'");
					out.println("</script>");
				}
			}
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�ּҸ� �Է����ּ���.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
