package com.project.library.entities;

import java.util.Date;
import java.util.Objects;

public class User{
	private Long id;
    private String name;
    private String username;
    private String CPF;
    private Date dateOfBirth;
	private String phone;
	private String email;
	private String password;
	
	private Adress adress = new Adress();
	
	public User() {
	}
	
	public User(Long id, String name, String username, String CPF, Date dateOfBirth, String phone, String email, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.CPF = CPF;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone; 
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", CPF=" + CPF + ", dateOfBirth="
				+ dateOfBirth + ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
