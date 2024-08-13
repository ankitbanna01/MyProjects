package com.onlinestore;

import java.io.Serializable;
import java.sql.*;
@SuppressWarnings("serial")
public class AddProductDAO implements Serializable
{
	public int k=0;
	public int addProduct(AddProductBean ab)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into product58 values(?,?,?,?)");
			ps.setString(1, ab.getpCode());
			ps.setString(2, ab.getpName());
			ps.setDouble(3, ab.getpPrice());
			ps.setInt(4, ab.getpQty());
			k=ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
