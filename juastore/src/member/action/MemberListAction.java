package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberListService;
import vo.ActionForward;
import vo.Member;
import vo.PageInfo;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<Member> memlist = new ArrayList<Member>();
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println(session.getAttribute("id"));
		if(session.getAttribute("id")==null || !((String)session.getAttribute("id")).equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인 하세요')");
			out.println("location.href='loginForm.mem'");
			out.println("</script>");
		}
		String search = request.getParameter("search");
		
		MemberListService memberListSVC = new MemberListService();
		int listCount = memberListSVC.getListCount();
		memlist = memberListSVC.getmemList(page,limit,search);
		int maxPage = (int)((double)listCount/limit+0.95);
		int startPage = (((int)((double)page/10+0.9))-1)*10+1;
		int endPage = startPage+10-1;
		
		if(endPage>maxPage) endPage=maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("memlist", memlist);
		request.setAttribute("search", search);
		ActionForward forward = new ActionForward();
		forward.setPath("memberList.jsp");
		
		
		return forward;
	}

}
