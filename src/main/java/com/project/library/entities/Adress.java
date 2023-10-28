package com.project.library.entities;

import java.util.Objects;

public class Adress {
	private Long id;
	private String publicPlace;
	private Long number;
	private String neighborhood;
	private String CEP;
	private String city;
	private String state;

	private User user = new User();

	public Adress() {
	}

	public Adress(Long id, String publicPlace, Long number, String neighborhood, String CEP, String city, String state) {
		this.id = id;
		this.publicPlace = publicPlace;
		this.number = number;
		this.neighborhood = neighborhood;
		this.CEP = CEP;
		this.city = city;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Adress other = (Adress) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", publicPlace=" + publicPlace + ", number=" + number + ", neighborhood="
				+ neighborhood + ", CEP=" + CEP + ", city=" + city + ", state=" + state + "]";
	}

}
