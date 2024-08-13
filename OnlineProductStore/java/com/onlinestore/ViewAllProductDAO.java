package com.onlinestore;

import java.util.ArrayList;
import java.sql.*;

public class ViewAllProductDAO{
	ArrayList<AddProductBean> al=new ArrayList<AddProductBean>();
	public ArrayList<AddProductBean> retrive()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from product58");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AddProductBean ab=new AddProductBean();
				ab.setpCode(rs.getString(1));
				ab.setpName(rs.getString(2));
				ab.setpPrice(rs.getDouble(3));
				ab.setpQty(rs.getInt(4));
				al.add(ab);
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return al;
	}
	
	
	
}