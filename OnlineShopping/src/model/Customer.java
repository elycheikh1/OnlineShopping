package model;

public class Customer {

	private int id;
	private String name;
	private String email;
	private String phone;
	private int userId;
	private int addressId;

	public Customer(int id, int userid) {
		this.id = id;
		this.userId = userid;
	}
	
	public Customer(String name, String email, String phone, int userid) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userId = userid;
	}

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String fName) {
		this.name = fName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userid) {
		this.userId = userid;
	}
}
