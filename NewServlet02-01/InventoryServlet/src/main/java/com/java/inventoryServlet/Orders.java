package com.java.inventoryServlet;

public class Orders {
	
	private String orderId;
	private String stockId;
	int qtyOrd;
	double price;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public int getQtyOrd() {
		return qtyOrd;
	}
	public void setQtyOrd(int qtyOrd) {
		this.qtyOrd = qtyOrd;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Orders(String orderId, String stockId, int qtyOrd, double price) {
		super();
		this.orderId = orderId;
		this.stockId = stockId;
		this.qtyOrd = qtyOrd;
		this.price = price;
	}
	
	public Orders() {}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", stockId=" + stockId + ", qtyOrd=" + qtyOrd + ", price=" + price + "]";
	}
	
	
	

}
