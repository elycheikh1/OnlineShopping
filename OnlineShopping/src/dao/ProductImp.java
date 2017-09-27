package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;

import dbconnection.ConnectionManager;
import model.Product;

public class ProductImp {

	ConnectionManager dbm = new ConnectionManager();
	Connection con = dbm.getConnection();
	ArrayList<Product> productDb;

	public Product getProductById(int proId) {

		Product product = new Product(); // = new Product();

		try {

			ResultSet rs;
		
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT * FROM products WHERE pid = ?");

			preparedStmt.setInt(1, proId); // from setString
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				product.setProductId(Integer.parseInt(rs.getString(1)));
				product.setName(rs.getString(2));
				product.setPrice(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setImage(rs.getString(5));
				product.setQuantity(rs.getInt(6));

			}
			return product;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Product> getAllProducts() {

		ArrayList<Product> productDb = new ArrayList<Product>();
		try {
			ResultSet rs;
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT * FROM products");
			rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setProductId(Integer.parseInt(rs.getString(1)));
				product.setPrice(rs.getString(2));
				product.setName(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setImage(rs.getString(5));
				product.setQuantity(rs.getInt(6));

				productDb.add(product);
			}
			return productDb;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public boolean deleteProduct(int id) {
		try { 
			con.createStatement();
			PreparedStatement stmt = con.prepareStatement("delete from products where pid = ?");
			stmt.setInt(1, id);
			stmt.execute(); // con.close();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Product addProduct(Product product) {

		try {
			PreparedStatement preparedStmt = con.prepareStatement(
					"INSERT INTO products " + "(pid, pname, price, description, image, quantity) VALUES(?,?,?,?,?,?)");
			
			preparedStmt.setInt(1, product.getProductId());
			preparedStmt.setString(2, product.getName());
			preparedStmt.setString(3, product.getPrice());
			preparedStmt.setString(4, product.getDescription());
			preparedStmt.setString(5, product.getImage());
			preparedStmt.setInt(6, product.getQuantity());
			preparedStmt.execute();

			return product;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	public Product updateProduct(Product product) { //

		try {

			PreparedStatement preparedStmt = con.prepareStatement(
					"update products set pname = ?, " + "price = ?, description = ?, image = ?, quantity = ? where pid = ?");

			preparedStmt.setString(1, product.getName());
			preparedStmt.setString(2, product.getPrice());
			preparedStmt.setString(3, product.getDescription());
			preparedStmt.setString(4, product.getImage());
			preparedStmt.setInt(5, product.getQuantity());
			preparedStmt.setInt(6, product.getProductId());
			preparedStmt.execute();

			return product;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public int genId() {
		return productDb.size() + 1;
	}

}
