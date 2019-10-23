package edu.northeastern.cs5200.models;

import java.sql.Date;

public class User extends Person{
	private Boolean userAgreement = false;
	
	public User(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
	}
	
	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
        super(id, firstName, lastName, username, password, email, dob);
    }

    public User(int id, String firstName, String lastName, String username, String password, String email, Date dob, Boolean userAgreement) {
        super(id, firstName, lastName, username, password, email, dob);
        this.userAgreement = userAgreement;
    }
    
    public void setUserAgreement(Boolean userAgreement) {
        this.userAgreement = userAgreement;
    }
    
    public Boolean getUserAgreement() {
        return userAgreement;
    }
}
