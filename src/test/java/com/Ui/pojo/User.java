package com.Ui.pojo;

public class User {
	private String Name;
	private String emailAdress;
	
	
	public User(String name, String emailAdress) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	@Override
	public String toString() {
		return "User [Name=" + Name + ", emailAdress=" + emailAdress + ", getName()=" + getName()
				+ ", getEmailAdress()=" + getEmailAdress() + "]";
	}
	
		
	
	
	

}
