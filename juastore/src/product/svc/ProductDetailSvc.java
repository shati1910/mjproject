package product.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Inventory;
import vo.Product;

public class ProductDetailSvc {

	public Product getProduct(String product_code) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		Product product = productDAO.selectProduct(product_code);
		
		close(con);
		
		return product;
	}

	public ArrayList<Inventory> getInventory(String product_code) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		ArrayList<Inventory> inventoryList = productDAO.selectInventoryList(product_code);
		
		close(con);
		
		return inventoryList;
	}

}
