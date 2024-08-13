package com.ankit.user;




public class UserData {
	private int id;
	private String title;
	private String content;
	private String uid;
	
    
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(int id, String title, String content, String uid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	
}
