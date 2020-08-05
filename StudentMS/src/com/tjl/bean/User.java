package com.tjl.bean;

public class User {
	private int id;
	private String uname;
	private String upass;

	private int type;

	public User(String uname, String upass, int type) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}

	public User(int id, String uname, String upass, int type) {
		super();
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}

	public User(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return id + " " + uname + " " + type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
