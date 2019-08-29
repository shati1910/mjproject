package order.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.Pro_order;
import static db.JdbcUtil.*;

public class OrderListSvc {

	public ArrayList<Pro_order> getOrderList(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		
		ArrayList<Pro_order> orderList = orderDAO.selectOrderList(id);
		
		close(con);
		
		return orderList;
	}
	
}
