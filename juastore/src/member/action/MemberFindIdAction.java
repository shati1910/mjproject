package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberFindIdService;
import vo.ActionForward;
import vo.Member;
import vo.PageInfo;

public class MemberFindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String findId = request.getParameter("findId");
		
		ActionForward forward = null;
		

		System.out.println("findId테스트"+findId);
		
		if(findId == null || findId=="") {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('검색할 아이디를 입력해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
		
		}
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<Member> memlist = new ArrayList<Member>();
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}

		if(session.getAttribute("id")==null || !((String)session.getAttribute("id")).equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인 하세요')");
			out.println("location.href='loginForm.mem'");
			out.println("</script>");
		}
		
		MemberFindIdService memberFindIdSVC = new MemberFindIdService();
		int findListCount = memberFindIdSVC.getFindListCount(findId);
		memlist = memberFindIdSVC.getmemList(page,limit,findId);
		
		int maxPage = (int)((double)findListCount/limit+0.95);
		int startPage = (((int)((double)page/10+0.9))-1)*10+1;
		int endPage = startPage+10-1;
		
		if(endPage>maxPage) endPage=maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(findListCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("memlist", memlist);
		request.setAttribute("findId", findId);
		forward = new ActionForward();
		forward.setPath("memberList.jsp");
		
		
		return forward;
	}

}
