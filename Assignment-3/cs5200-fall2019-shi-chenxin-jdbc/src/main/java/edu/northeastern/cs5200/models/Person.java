package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.sql.Date;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
    private Date dob;
    private Collection<Phone> phones;
    private Collection<Address> addresses;
    
    public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;

	}
    
    public Person(int id, String firstName, String lastName){
    	this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
    
    public Person(String firstName, String lastName, String username, String password, String email, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;		
	}
    
    public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob, Collection<Address> addresses, Collection<Phone> phones){
    	this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phones = phones;
        this.addresses = addresses;
	}
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public Date getDob() {
        return dob;
    }
       	
	public void addPhone(Phone p) {
		this.phones.add(p);
	}
	
	public void removePhone(Phone p) {
		this.phones.remove(p);
	}
	
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
	
	public Collection<Phone> getPhones() {
		return phones;
	}
	
	public void addAddress(Address address) {
		 this.addresses.add(address);
	}
    
	public void removeAddress(Address address) {
		this.addresses.remove(address);
	}
	
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Collection<Address> getAddresses(){
		return addresses;
	}
}
