package com.casanova.dto;

public class Review {
	public String name;
    public String date;
    public int rating;
    public String comments;
	public Review(String name, String date, int rating, String comments) {
		this.name = name;
		this.date = date;
		this.rating = rating;
		this.comments = comments;
	}
	
	
	public Review() {
	}


	@Override
	public String toString() {
		return "Review [name=" + name + ", date=" + date + ", rating=" + rating + ", comments=" + comments + "]";
	}
    

}
