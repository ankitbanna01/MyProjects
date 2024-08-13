package com.ankit.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ankit.db.DBConnection;
import com.ankit.user.UserData;

public class addnoteDAO {

	public boolean AddNotes(UserData ud) {
		boolean f = false;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into enote_content values(econ.nextval,?,?,?)");
			ps.setString(1, ud.getTitle());
			ps.setString(2, ud.getContent());
			ps.setString(3, ud.getUid());
			int k = ps.executeUpdate();
			if (k == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}

	public List<UserData> getData(String id) {
		List<UserData> list = new ArrayList<UserData>();
		UserData ud = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from enote_content where cid=? ");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ud = new UserData();
				ud.setId(rs.getInt(1));
				ud.setTitle(rs.getString(2));
				ud.setContent(rs.getString(3));
				list.add(ud);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public UserData getDataById(int noteId) {
		UserData ud = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from enote_content where id=?");
			ps.setInt(1, noteId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ud = new UserData();
				ud.setId(rs.getInt(1));
				ud.setTitle(rs.getString(2));
				ud.setContent(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ud;
	}

	public boolean editNotes(int id, String ti, String cont) {
		boolean f = false;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE ENOTE_CONTENT SET TITLE=? , CONTENT=? WHERE ID=?");
			ps.setString(1, ti);
			ps.setString(2, cont);
			ps.setInt(3, id);
			int k = ps.executeUpdate();
			if (k == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;

	}

	public boolean deleteById(int noteId) {
		boolean f = false;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from enote_content where id=?");
			ps.setInt(1, noteId);
			int k = ps.executeUpdate();
			if (k == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
