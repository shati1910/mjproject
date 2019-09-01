package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Inventory;
import vo.Product;
import vo.ProductInventoryView;

import static db.JdbcUtil.*;

public class ProductDAO {
	public static ProductDAO productDAO;
	private Connection con;
	
	public static ProductDAO getInstance() {
		if(productDAO==null)
			productDAO = new ProductDAO();
		return productDAO;
	}
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con=con;
	}
	public int getProductListCount(String product_code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int listCount=0;
		String sql="select count(*) from product_inventory_view";
		if(product_code !=null)
			sql+=" where product_code like '"+ product_code +"%'";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("getProductListCount에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	public ArrayList<ProductInventoryView> getProductList(String product_code, int page, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ProductInventoryView> productList=null;
		
		String sql="select * from product_inventory_view";
		int startrow=(page-1)*limit;

		if(product_code!=null)
			sql+=" where product_code like '"+product_code+"%'";
		
		sql+=" order by product_code limit "+startrow +","+limit;
		try {
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				productList = new ArrayList<ProductInventoryView>();
				do {
					ProductInventoryView product = new ProductInventoryView();
					
					product.setInventory_amount(rs.getInt("inventory_amount"));
					product.setProduct_code(rs.getString("product_code"));
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_price(rs.getInt("product_price"));
					productList.add(product);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("getProductList 에러 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return productList;
	}
	public Product selectProduct(String product_code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from product where product_code=?";
		Product product=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product_code);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setEtc(rs.getString("etc"));
				product.setImage(rs.getString("image"));
				product.setProduct_code(rs.getString("product_code"));
				product.setProduct_name(rs.getString("product_code"));
				product.setProduct_price(rs.getInt("product_price"));
			}
		}catch(Exception e) {
			System.out.println("selectProduct에러 : "+e);
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return product;
	}
	public ArrayList<Inventory> selectInventoryList(String product_code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Inventory> inventoryList=null;
		String sql="select * from inventory where product_code=? order by inventory_num ";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product_code);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				inventoryList = new ArrayList<Inventory>();
				
				do {
					Inventory inventory=new Inventory();
					inventory.setInventory_amount(rs.getInt("inventory_amount"));
					inventory.setInventory_date(rs.getDate("inventory_date"));
					inventory.setInventory_num(rs.getInt("inventory_num"));
					inventory.setInventory_state(rs.getString("inventory_state"));
					inventory.setProduct_code(rs.getString("product_code"));
					inventoryList.add(inventory);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("selectInventoryList에러 : " +e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return inventoryList;
	}
	
}
