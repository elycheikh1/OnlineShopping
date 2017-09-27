/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Address;
import model.Customer;
//import model.ProductManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconnection.ConnectionManager;


public class CustomerImp {
	ConnectionManager dbm = new ConnectionManager();
	Connection con = dbm.getConnection();
	Customer customer = new Customer();

	public Customer saveCustomer(Customer cust) {

		try {

			PreparedStatement preparedStmt = con.prepareStatement(
					"INSERT INTO customer " + "(fname, phone, email, uid, addressid) VALUES(?,?,?,?,?)");
			System.out.println("customer imp class ----------1");
			// preparedStmt.setString(1, cust.getId());
			preparedStmt.setString(1, cust.getName());
			preparedStmt.setString(2, cust.getPhone());
			preparedStmt.setString(3, cust.getEmail());
			preparedStmt.setInt(4, cust.getUserId());
			preparedStmt.setInt(5, cust.getAddressId());
			preparedStmt.execute();

			System.out.println("customer imp class ----------22222222");
			// con.close();
			return cust;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Customer getCustomerById(int uId) {

		Customer cust = new Customer();

		try {

			ResultSet rs;

			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT cid, fname,phone,email  FROM customer where uid = ?");
			preparedStmt.setInt(1, uId);
			rs = preparedStmt.executeQuery();

			while (rs.next()) {

				cust.setId(Integer.parseInt(rs.getString(1)));
				cust.setName(rs.getString(2));
				cust.setPhone(rs.getString(3));
				cust.setEmail(rs.getString(4));
			}
			// con.close();
			return cust;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public Customer updateCustomerAddress(Customer customer, Address address) {

		try {

			PreparedStatement preparedStmt = con.prepareStatement("UPDATE customer SET addressid = ? WHERE cid = ?");

			preparedStmt.setInt(1, address.getId());
			preparedStmt.setInt(2, customer.getId());
			preparedStmt.execute();

			// con.close();
			return customer;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
