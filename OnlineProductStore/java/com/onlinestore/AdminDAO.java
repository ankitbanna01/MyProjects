package com.onlinestore;

import java.io.Serializable;
import java.sql.*;
@SuppressWarnings("serial")
public class AdminDAO implements Serializable
{
	public AdminBean ab=null;
	public AdminDAO() {	}
	
	public AdminBean adminlogin(String un,String pw)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from admintab58 where uname=? and pword=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ab=new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setmId(rs.getString(6));
				ab.setPhNo(rs.getLong(7));
			}
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
		
	}
}
