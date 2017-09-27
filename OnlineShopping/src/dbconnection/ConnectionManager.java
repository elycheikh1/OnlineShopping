package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionManager {

   static Connection con;
   static String url;
         

   public Connection getConnection() {
       Connection con;

       try {
    	   Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webstore?zeroDateTimeBehavior=convertToNull", "root", "");

           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
}
