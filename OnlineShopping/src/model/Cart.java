package model;

import java.util.List;

public class Cart {
	private User user;
	private List<Product> products;

	
	public Cart(User user, List<Product> products) {
		this.user = user;
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.remove(product);
	}
}
