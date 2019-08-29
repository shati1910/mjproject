package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.OrderView;
import vo.Pro_order;
import static db.JdbcUtil.*;

public class OrderDAO {
	private static OrderDAO orderDAO;
	private Connection con;
	
	public static OrderDAO getInstance() {
		// TODO Auto-generated method stub
		if(orderDAO==null)
			orderDAO = new OrderDAO();
		return orderDAO;
	}
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con=con;
	}
	public ArrayList<Pro_order> selectOrderList(String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_order where user_id=?";
		ArrayList<Pro_order> orderList=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				orderList=new ArrayList<Pro_order>();
				
				do {
					Pro_order order= new Pro_order();
					order.setOrder_num(rs.getInt("order_num"));
					order.setAddress(rs.getString("address"));
					order.setOrder_date(rs.getDate("order_date"));
					order.setOrder_state(rs.getString("order_state"));
					order.setPay(rs.getInt("pay"));
					orderList.add(order);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("selectOrderList 에러 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return orderList;
	}
	public ArrayList<OrderView> selectItemList(int order_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from order_view where order_num=?";
		ArrayList<OrderView> itemList=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				itemList=new ArrayList<OrderView>();
				do {
					OrderView item=new OrderView();
					item.setProduct_name(rs.getString("product_name"));
					item.setAmount(rs.getInt("amount"));
					item.setPay(rs.getInt("pay"));
					item.setProduct_price(rs.getInt("product_price"));
					itemList.add(item);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("selectItemList 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}
	public Pro_order selectOrder(int order_num) {
		// TODO Auto-generated method stub
		Pro_order order = null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from pro_order where order_num=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				order = new Pro_order();
				order.setAddress(rs.getString("address"));
				order.setOrder_date(rs.getDate("order_date"));
				order.setOrder_num(rs.getInt("order_num"));
				order.setOrder_state(rs.getString("order_state"));
				order.setPay(rs.getInt("pay"));
				order.setPhone(rs.getString("phone"));
				order.setReceive_name(rs.getString("receive_name"));
				order.setZip_code(rs.getInt("zip_code"));
			}
		}catch(Exception e) {
			System.out.println("selectOrder에러 : " +e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return order;
	}
	
	
}
