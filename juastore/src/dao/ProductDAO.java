package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Product;

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
		String sql="select count(*) from product where product_code like '"+ product_code +"%'";
		
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
	public ArrayList<Product> getProductList(String product_code, int page, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Product> productList=null;
		
		String sql="select * from product where product_code like '"+product_code+"%' order by product_code limit ?,?";
		int startrow=(page-1)*limit;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				productList = new ArrayList<Product>();
				do {
					Product product=new Product();
					product.setEtc(rs.getString("etc"));
					product.setImage(rs.getString("image"));
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
	
}
