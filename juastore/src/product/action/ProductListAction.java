package product.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import product.svc.ProductListSvc;
import vo.ActionForward;
import vo.PageInfo;
import vo.Product;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward = null;

		if (!session.getAttribute("id").equals("admin")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.')");
			out.println("location.href='/loginForm.mem'");
			out.println("</script>");
		} else {

			int page = 1;
			int limit = 10;
			int limitPage = 10;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			String product_code=request.getParameter("product_code");
			ProductListSvc productListSvc = new ProductListSvc();
			int productListCount = productListSvc.getProductListCount(product_code);
			ArrayList<Product> productList = productListSvc.getProductList(product_code,page,limit);
			
			int maxPage=(int)((double)productListCount/limit+0.95);
			int startPage=(((int)((double)page/limitPage+0.9))-1)*limitPage+1;
			int endPage = startPage+limitPage-1;
			if(endPage>maxPage)
				endPage=maxPage;
			PageInfo pageInfo = new PageInfo();
			pageInfo.setEndPage(endPage);
			pageInfo.setListCount(productListCount);
			pageInfo.setMaxPage(maxPage);
			pageInfo.setPage(page);
			pageInfo.setStartPage(startPage);
			
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("productList", productList);
			
			forward=new ActionForward("/product/prductList.jsp",false);
		}
		return forward;
	}

}
