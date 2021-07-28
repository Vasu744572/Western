package com.tour.pojo;

import java.util.Set;

public class IterneryPojo {

	private long id;
	private long day;
	private String place;
	private String address;
	private String dayheading;
	private String daydescription;
	private boolean ishotel;
	private boolean ismeal;
	private boolean iscab;
	private boolean isflight;
	private Set<HotelPojo> hotels;
	private Set<AssetPojo> images;
	private TourpackagePojo tourpackage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Set<HotelPojo> getHotels() {
		return hotels;
	}

	public void setHotels(Set<HotelPojo> hotels) {
		this.hotels = hotels;
	}

	public Set<AssetPojo> getImages() {
		return images;
	}

	public void setImages(Set<AssetPojo> images) {
		this.images = images;
	}

	public TourpackagePojo getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(TourpackagePojo tourpackage) {
		this.tourpackage = tourpackage;
	}

}
