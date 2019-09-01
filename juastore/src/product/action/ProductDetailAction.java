package product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import product.svc.ProductDetailSvc;
import vo.ActionForward;
import vo.Inventory;
import vo.Product;

public class ProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String product_code = request.getParameter("product_code");
		ActionForward forward=null;
		
		ProductDetailSvc productDetailSvc = new ProductDetailSvc();
		
		Product product = productDetailSvc.getProduct(product_code);
		ArrayList<Inventory> inventoryList = productDetailSvc.getInventory(product_code);
		
		request.setAttribute("product", product);
		request.setAttribute("inventoryList", inventoryList);
		forward= new ActionForward("/product/productDetail.jsp",false);
		
		return forward;
	}

}
