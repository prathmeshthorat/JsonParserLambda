package com.casanova.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperatingHours {
	@JsonProperty("Monday")
	public String monday;
	@JsonProperty("Tuesday")
	public String tuesday;
	@JsonProperty("Wednesday")
	public String wednesday;
	@JsonProperty("Thursday")
	public String thursday;
	@JsonProperty("Friday")
	public String friday;
	@JsonProperty("Saturday")
	public String saturday;
	@JsonProperty("Sunday")
	public String sunday;
	
	
	
	public OperatingHours() {
	}
	public OperatingHours(String monday, String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sunday) {
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}
	@Override
	public String toString() {
		return "OperatingHours [monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday="
				+ thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday + "]";
	}
	
	
}
