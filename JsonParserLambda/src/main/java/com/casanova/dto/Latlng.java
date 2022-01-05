package com.casanova.dto;

public class Latlng {
	public double lat;
	public double lng;
	public Latlng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	
	
	public Latlng() {
	}



	@Override
	public String toString() {
		return "Latlng [lat=" + lat + ", lng=" + lng + "]";
	}
	

}
