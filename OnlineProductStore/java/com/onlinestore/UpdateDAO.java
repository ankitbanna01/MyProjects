package com.onlinestore;

import java.sql.*;

public class UpdateDAO {
	public int k=0;
   public int insert(AddProductBean ab)
   {
	   try {
		   Connection con=DBConnection.getCon();
		   PreparedStatement ps=con.prepareStatement
				   ("update product58 set price=?,qyt=? where code=?");
		   ps.setDouble(1, ab.getpPrice());
		   ps.setInt(2, ab.getpQty());
		   ps.setString(3, ab.getpCode());
		   k=ps.executeUpdate();  
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   return k;
   }
	

}
