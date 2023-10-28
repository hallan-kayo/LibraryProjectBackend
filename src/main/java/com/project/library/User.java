package com.project.library;

import java.util.Date;

public class User{
	private int id;
    private String name;
    private String username;
    private String CPF;
    private Date dateOfBirth;
	private String phone;
	private String email;
	private String password;
	
	public User() {
	}
	
	public User(int id, String name, String username, String CPF, Date dateOfBirth, String phone, String email, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.CPF = CPF;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone; 
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		 this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
