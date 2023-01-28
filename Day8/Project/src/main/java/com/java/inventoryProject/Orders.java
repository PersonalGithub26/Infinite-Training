package com.java.inventoryProject;

public class Orders {
	
	private int orderId;
	private String StockId;
	private int QuntityOrdered;
	private double OrderPrice;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStockId() {
		return StockId;
	}
	public void setStockId(String stockId) {
		StockId = stockId;
	}
	public int getQuntityOrdered() {
		return QuntityOrdered;
	}
	public void setQuntityOrdered(int quntityOrdered) {
		QuntityOrdered = quntityOrdered;
	}
	public double getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		OrderPrice = orderPrice;
	}
	public Orders(int orderId, int stockId, int quntityOrdered, double orderPrice) {
		Stock stock = new Stock();
		this.orderId = orderId;
		setStockId(stock.getStockId());
		QuntityOrdered = quntityOrdered;
		OrderPrice = orderPrice;
	}
	public Orders() {
		
	}
	
	

}
