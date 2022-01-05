package com.casanova.dto;

import java.util.List;

public class RestaurantCollection {
	public List<Restaurant> restaurants;

	public RestaurantCollection(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	
	
	public RestaurantCollection() {
	}



	@Override
	public String toString() {
		return "RestaurantCollection [restaurants=" + restaurants + "]";
	}

}
