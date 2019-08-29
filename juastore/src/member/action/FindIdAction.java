package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.FindIdSvc;
import vo.ActionForward;

public class FindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		ActionForward forward=null;
		
		FindIdSvc findIdSvc = new FindIdSvc();
		String id=findIdSvc.getUserID(email);
		
		if(!(id==null||id.equals("no"))) {
			int length=id.length()-3;
			
			id=id.substring(0, 3);
			for(int i=0;i<length;i++)
				id+="*";
		}
				
		request.setAttribute("userId", id);
		forward=new ActionForward("/member/findId.jsp",false);
		
		return forward;
	}

}
