package com.tour.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Iternery {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long day;
	private String place;
	private String address;
	private String dayheading;
	private String  daydescription;
	private boolean ishotel;
	private boolean ismeal;
	private boolean iscab;
	private boolean isflight;
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name= "iterneries_hotels")
	private Set<Hotel> hotels;
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name= "iterneries_assets")
	private Set<Asset> images;
	

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinTable(name="iterneries_package")
	private Tourpackage tourpackage;
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Tourpackage getTourpackage() {
		return tourpackage;
	}
	public void setTourpackage(Tourpackage tourpackage) {
		this.tourpackage = tourpackage;
	}
	public long getDay() {
		return day;
	}
	public void setDay(long day) {
		this.day = day;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDayheading() {
		return dayheading;
	}
	public void setDayheading(String dayheading) {
		this.dayheading = dayheading;
	}
	public String getDaydescription() {
		return daydescription;
	}
	public void setDaydescription(String daydescription) {
		this.daydescription = daydescription;
	}
	public boolean isIshotel() {
		return ishotel;
	}
	public void setIshotel(boolean ishotel) {
		this.ishotel = ishotel;
	}
	public boolean isIsmeal() {
		return ismeal;
	}
	public void setIsmeal(boolean ismeal) {
		this.ismeal = ismeal;
	}
	public boolean isIscab() {
		return iscab;
	}
	public void setIscab(boolean iscab) {
		this.iscab = iscab;
	}
	public boolean isIsflight() {
		return isflight;
	}
	public void setIsflight(boolean isflight) {
		this.isflight = isflight;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	public Set<Asset> getImages() {
		return images;
	}
	public void setImages(Set<Asset> images) {
		this.images = images;
	}

}
