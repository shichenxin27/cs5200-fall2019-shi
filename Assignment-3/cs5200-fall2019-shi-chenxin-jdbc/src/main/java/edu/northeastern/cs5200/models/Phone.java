package edu.northeastern.cs5200.models;

public class Phone {
	private String phone;
	private Boolean primary;
	private Person person;
	
	public Phone(String phone, Boolean primary) {
		this.phone = phone;
		this.primary = primary;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Boolean getPrimary() {
		return primary;
	}
	
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}
	
	public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
