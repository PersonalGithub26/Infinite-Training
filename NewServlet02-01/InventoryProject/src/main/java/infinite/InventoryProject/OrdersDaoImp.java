package infinite.InventoryProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDaoImp implements OrdersDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	//OrdersDAO dao = new OrdersDaoImp();
	
	public String generateOrderId() throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd="select * from orders order by orderid desc";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();

		if(rs.next()){

			String str=rs.getString("orderid");
			int num=Integer.parseInt(str);
			num=num+1;
			str = String.format("%03d", num);
			return str;
		}

		int num=001;
		String str2=String.format("%03d", num);
		return str2;

	}

	@Override
	public String placeOrder(Orders od) throws ClassNotFoundException, SQLException {
		StockDaoImp dimp = new StockDaoImp();
		Stock st=dimp.searchStock(od.getStockId());
		
		if(st!=null){
			if(st.getQuantityAvail()>od.getQtyOrd()){
			String orderIdg=generateOrderId();
			od.setOrderId(orderIdg);
			
			
			String cmd="insert into orders(orderid,stockid,qtyord,price) values(?,?,?,?)";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			
			pst.setString(1, orderIdg);
			pst.setString(2, od.getStockId());
			pst.setInt(3,od.getQtyOrd());
			pst.setDouble(4,st.getPrice());
			
			pst.executeUpdate();
			
			cmd="update stock set QuantityAvail=? where stockid=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1,st.getQuantityAvail()-od.getQtyOrd());
			pst.setString(2,od.getStockId());
			
			pst.executeUpdate();
			
			double total=od.getQtyOrd()*st.getPrice();
			
			cmd="insert into amount(gamt) values(?)";
			pst = connection.prepareStatement(cmd);
			pst.setDouble(1,total);
			
			pst.executeUpdate();
			
			}else{
				return "not enough quantity available=" +st.getQuantityAvail();
			}
			
			return "order placed succefully";
			
			
			
			
		}
		return "stock does not exist";
		}

	@Override
	public String OrdersRice(Orders od, String id) throws ClassNotFoundException, SQLException {
		//StockDaoImp dimp = new StockDaoImp();
		OrdersDaoImp imp = new OrdersDaoImp();
		Orders st=imp.searchOrder(id);
		if(st!=null){
			String cmd = "update orders set QtyOrd=QtyOrd+?, price=? where OrderId=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, od.getQtyOrd());
			pst.setDouble(2, od.getPrice()*od.getQtyOrd());
			pst.setString(3, od.getOrderId());
			pst.executeUpdate();	
			return "Order rised";
	}
		else {
			return "Please add order to rise";
		}
	}

	@Override
	public Orders searchOrder(String id) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();

		String cmd="select * from Orders where OrderId=?";

		pst=connection.prepareStatement(cmd);

		pst.setString(1,id);

		ResultSet rs=pst.executeQuery();

		Orders order=null;
		if(rs.next()){
			order=new Orders();

			order.setStockId(rs.getString("stockid"));
			order.setOrderId(rs.getString("OrderId"));
			order.setPrice(rs.getDouble("price"));
			order.setQtyOrd(rs.getInt("QtyOrd"));
		}

		return order;
		//return null;
	}

}
