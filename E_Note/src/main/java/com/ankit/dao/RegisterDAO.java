package com.ankit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ankit.db.DBConnection;
import com.ankit.user.UserBean;

public class RegisterDAO {
	public int k = 0;

	public int register(UserBean rb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into enote_user_details values(enotes.nextval,?,?,?)");
			ps.setString(1, rb.getFull_Name());
			ps.setString(2, rb.getEmail());
			ps.setString(3, rb.getPassword());

			k = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return k;
	}

}
