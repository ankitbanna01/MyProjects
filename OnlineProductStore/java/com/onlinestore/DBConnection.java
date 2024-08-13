package com.onlinestore;


import java.sql.*;
import static com.onlinestore.DBInfo.*;

public class DBConnection {
	public static  Connection con=null;
	  public DBConnection() {}
	  static {
		  try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,uname,pword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  public static Connection getCon()
	  {
		  return con;
	  }
}
