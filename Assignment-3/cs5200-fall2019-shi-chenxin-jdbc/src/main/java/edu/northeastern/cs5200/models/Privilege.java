package edu.northeastern.cs5200.models;

public class Privilege {
//	private int id;
	private String privilege;

	public Privilege(String privilege) {
//		this.id = id;
	    this.privilege = privilege;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//	    this.id = id;
//	}

	public String getPrivilege() {
	    return privilege;
	}

	public void setPrivilege(String privilege) {
	    this.privilege = privilege;
	}
}
