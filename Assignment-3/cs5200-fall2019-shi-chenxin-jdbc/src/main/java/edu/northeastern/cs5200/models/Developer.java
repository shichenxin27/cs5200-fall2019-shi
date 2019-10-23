package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Developer extends Person{
	private String developerKey;
	private Collection<Website> websites;
	private Collection<Role> roles;
	private Collection<Privilege> privileges;
	
	public Developer(String developerKey, int id, String firstName, String lastName) {
		super(id, firstName, lastName);
		this.developerKey = developerKey;
	}
	
	public Developer(String developerKey, int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super(id, firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
	}
	
	public Developer(String developerKey, int id, String firstName, String lastName, String username, String password, String email, Date dob, Collection<Address> addresses, Collection<Phone> phones) {
		super(id, firstName, lastName, username, password, email, dob, addresses, phones);
		this.developerKey = developerKey;
	}
	
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	
	public String getDeveloperKey() {
		return developerKey;
	}
	
	public Collection<Website> getWebsites() {
	    return websites;
	}

	public void setWebsites(Collection<Website> websites) {
	    this.websites = websites;
	}

	public Collection<Role> getRoles() {
	    return roles;
	}

	public void setRoles(Collection<Role> roles) {
	    this.roles = roles;
	}

	public Collection<Privilege> getPrivileges() {
	    return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
	    this.privileges = privileges;
	}
	
}
