package com.casanova.dto;

import java.util.List;

import org.dizitart.no2.objects.Id;

public class Restaurant {
	@Id
	public int id;
    public String name;
    public String neighborhood;
    public String photograph;
    public String address;
    public Latlng latlng;
    public String cuisine_type;
    public OperatingHours operating_hours;
    public List<Review> reviews;
    
    
    
	public Restaurant() {
	}

	public Restaurant(int id, String name, String neighborhood, String photograph, String address, Latlng latlng,
			String cuisine_type, OperatingHours operating_hours, List<Review> reviews) {
		this.id = id;
		this.name = name;
		this.neighborhood = neighborhood;
		this.photograph = photograph;
		this.address = address;
		this.latlng = latlng;
		this.cuisine_type = cuisine_type;
		this.operating_hours = operating_hours;
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", neighborhood=" + neighborhood + ", photograph="
				+ photograph + ", address=" + address + ", latlng=" + latlng + ", cuisine_type=" + cuisine_type
				+ ", operating_hours=" + operating_hours + ", reviews=" + reviews + "]";
	}

}
