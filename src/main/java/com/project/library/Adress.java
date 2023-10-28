package com.project.library;

public class Adress {
	private int id;
	private String publicPlace;
	private int number;
	private String neighborhood;
	private String CEP;
	private String city;
	private String state;
	
	
	public Adress() {
	}
    
	
	public Adress(int id, String publicPlace, int number, String neighborhood, String CEP, String city, String state) {
       this.id = id;
       this.publicPlace = publicPlace;
       this.number = number;
       this.neighborhood = neighborhood;
       this.CEP = CEP;
       this.city = city;
       this.state = state;
	}
	
	public int getId() {
	   return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPublicPlace() {
		return publicPlace;
	}
	
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getCEP() {
		return CEP;
	}
	
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
