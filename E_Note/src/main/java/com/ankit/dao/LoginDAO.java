package com.ankit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ankit.db.DBConnection;

import com.ankit.user.UserBean;

public class LoginDAO {

	public UserBean login(UserBean ub) {
		UserBean user = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con
					.prepareStatement("select * from enote_user_details where email=? and password=?");
			ps.setString(1, ub.getEmail());
			ps.setString(2, ub.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setId(rs.getString(1));
				user.setFull_Name(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
