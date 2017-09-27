package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import dbconnection.ConnectionManager;
import model.User;

public class UserImp {
	ConnectionManager dbm = new ConnectionManager();
	Connection con = dbm.getConnection();

	public User addUser(User user) {

		try {

			PreparedStatement preparedStmt = con.prepareStatement(
					"INSERT INTO user " + "(username, password) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);

			// preparedStmt.setString(1, Integer.parseInt(user.getUserid());
			preparedStmt.setString(1, user.getUsername());
			preparedStmt.setString(2, user.getPassword());
			//preparedStmt.setInt(2, 0);
			
			preparedStmt.execute();
			try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setUserid(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			return user;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public User getUserById(String uName) {

		User user = new User();

		try {
			ResultSet rs;

			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT uid,username,password,admin FROM user WHERE username = ?");

			preparedStmt.setString(1, uName);
			rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				user.setUserid(Integer.parseInt(rs.getString(1)));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAdmin(rs.getBoolean(4));

			}
			// con.close();
			if (user.getUsername() != null && user.getPassword() != null) {
				System.out.println("user is found!........................userImp, admin: " + user.isAdmin());
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public void updateUserAccount(int currentUserId, User newUser) {

		try {
			PreparedStatement preparedStmt = con
					.prepareStatement("UPDATE user SET username = ?, password = ? WHERE uid = ?");
			preparedStmt.setString(1, newUser.getUsername());
			preparedStmt.setString(2, newUser.getPassword());
			preparedStmt.setInt(3, currentUserId);
			preparedStmt.execute();

			// con.close();
			// return user;

		} catch (Exception ex) {
			ex.printStackTrace();
			// return null;
		}

	}

}
