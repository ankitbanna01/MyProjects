package com.onlinestore;

import java.sql.*;

public class DeletDAO {
	public int k=0;
	
	public int delete(String pcode)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("delete from product58 where code=?");
			ps.setString(1, pcode);
			k=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
