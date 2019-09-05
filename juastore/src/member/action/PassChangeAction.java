package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.ChangePassSVC;
import vo.ActionForward;
import vo.Member;

public class PassChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String newPass = request.getParameter("newPass");
		String id = (String)session.getAttribute("id");
		
		if(session.getAttribute("password").equals(request.getParameter("passwordCk"))) {
					if(request.getParameter("newPass").equals(request.getParameter("newPassChk"))) {
						response.setContentType("text/html;charset=UTF-8");
						Member member = new Member();
						member.setId(id);
						member.setPassword(newPass);
						ChangePassSVC changePassSvc = new ChangePassSVC();
						boolean ckResult= changePassSvc.chPass(member);
							if(!ckResult) {
								response.setContentType("text/html;charset=UTF-8");
								PrintWriter out = response.getWriter();
								out.println("<script>");
								out.println("alert('��й�ȣ ���濡 ������ �߻��߽��ϴ�. �ٽ� �ۼ��ϼ���.')");
								out.println("history.back()");
								out.println("</script>");
							}else {
								response.setContentType("text/html;charset=UTF-8");
								PrintWriter out = response.getWriter();
								out.println("<script>");
								out.println("alert('��й�ȣ ������ �Ϸ�Ǿ����ϴ�.')");
								out.println("location.href='modify.mem'");
								out.println("</script>");
							}
					}else if(!request.getParameter("newPass").equals(request.getParameter("newPassChk"))){
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>");
						out.println("alert('���ο� ��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.')");
						out.println("history.back()");
						out.println("</script>");
					}
		}else{
			 if(!session.getAttribute("password").equals(request.getParameter("passwordCk"))) { 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('���� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �õ����ּ���.')");
					out.println("history.back()");
					out.println("</script>");
			 }else if(request.getParameter("newPass")=="" || request.getParameter("newPassChk")=="") {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('���ο� ��й�ȣ�� �Է����ּ���.')");
					out.println("history.back()");
					out.println("</script>");
				}
		}
		return forward;
	}
}