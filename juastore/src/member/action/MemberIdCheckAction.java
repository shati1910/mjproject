package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.MemberIdCheckSVC;
import vo.ActionForward;

public class MemberIdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		request.setCharacterEncoding("UTF-8");
		String id = null;
		if(request.getParameter("id")!=null) {
			id =request.getParameter("id").trim();
		}
		
		MemberIdCheckSVC memberIdCheckSvc = new MemberIdCheckSVC();
		
		boolean usebleId=false;
		
		usebleId = memberIdCheckSvc.checkId(id);
		
		request.setAttribute("usebleId", usebleId);
		request.setAttribute("id",id);
		
		forward = new ActionForward();
		forward.setPath("idcheck.jsp");
		return forward;
	}

}
