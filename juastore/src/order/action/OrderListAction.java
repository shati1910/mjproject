package order.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import order.svc.OrderListSvc;
import vo.ActionForward;
import vo.Pro_order;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ActionForward forward=null;
		
		if(session.getAttribute("id")==null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인하세요!')");
			out.println("location.href='/loginForm.mem'");
			out.println("</script>");
		}else {
			String id=(String)session.getAttribute("id");
			
			OrderListSvc orderListSvc = new OrderListSvc();
			ArrayList<Pro_order> orderList = orderListSvc.getOrderList(id);
			
			request.setAttribute("orderList", orderList);
			
			forward=new ActionForward("/order/myOrderList.jsp",false);
		}
		
		return forward;
	}

}
