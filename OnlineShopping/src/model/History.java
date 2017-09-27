package model;


import java.util.List;

public class History {

	private String date;
	private List<Product> products;
	private String shippingAddress;
	private String billingAddress;
	private String paymentInfo;
	private String userName;
	
	public History(){		
	}
	
	public History(String date, List<Product> products, String shippingAddress, String billingAddress,
			String paymentInfo, String userName) {
		this.date = date;
		this.products = products;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.paymentInfo = paymentInfo;
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
