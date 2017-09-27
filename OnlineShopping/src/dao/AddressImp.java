package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import dbconnection.ConnectionManager;
import model.Address;
import model.Customer;

public class AddressImp {
	ConnectionManager addressDb = new ConnectionManager();
	Connection con = addressDb.getConnection();
	Customer customer = new Customer();
	
	public Address addCustomerAddress(Address address) {

		try {
			
			PreparedStatement preparedStmt = con.prepareStatement(
					"INSERT INTO address " + " (shipping, billing) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
			System.out.println("address imp class ----------1");
			
			//preparedStmt.setInt(1, address.getId());
			preparedStmt.setString(1, address.getShipping());
			preparedStmt.setString(2, address.getBilling());
			preparedStmt.execute();

			try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	address.setId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			System.out.println("customer imp class ----------22222222");
	
			// con.close();
			return address;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	public Address getAddressById(int aId) {

		Address address = new Address(); // = new Product();

		try {

			ResultSet rs;
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT * FROM address WHERE id = ?");

			preparedStmt.setInt(1, aId); // from setString

			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				

				address.setId(rs.getInt(1));
				address.setShipping(rs.getString(2));
				address.setBilling(rs.getString(3));
				
			}
			// con.close();
			return address;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}


}
