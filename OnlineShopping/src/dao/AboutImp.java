package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dbconnection.ConnectionManager;

public class AboutImp {
	ConnectionManager dbm = new ConnectionManager();
	Connection con = dbm.getConnection();
	
	public void addComment(String uname, String comment){
		
		try {

			PreparedStatement preparedStmt = con.prepareStatement(
					"INSERT INTO about " + "(email, comment) VALUES(?,?)");
	
			preparedStmt.setString(1, uname);
			preparedStmt.setString(2, comment);
			preparedStmt.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("about imp. under error");

		}

		
	}
	
	
	

}
