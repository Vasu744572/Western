package com.tour.pojo;

import java.util.Set;

import com.tour.entity.Asset;
import com.tour.entity.Category;

public class HotelPojo {
	private long id;
	private String name;
	private int star;
	private String address;
	private String location;
	private long phonenumber;
	private Set<Category> categories;
	private String Email;
	private String details;
	private String detailedDescription;
	private  Set<Asset> images;
	
	public Set<Asset> getImages() {
		return images;
	}
	public void setImages(Set<Asset> images) {
		this.images = images;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

}
