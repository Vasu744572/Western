package com.tour.pojo;

import java.util.Set;

public class SeasonPojo {

	private long id;

	private Set<TourpackagePojo> tourpackage;

	private PlacePojo place;

	private String name;
	private long seasonNo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<TourpackagePojo> getTourpackage() {
		return tourpackage;
	}
	public void setTourpackage(Set<TourpackagePojo> tourpackage) {
		this.tourpackage = tourpackage;
	}
	public PlacePojo getPlace() {
		return place;
	}
	public void setPlace(PlacePojo place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSeasonNo() {
		return seasonNo;
	}
	public void setSeasonNo(long seasonNo) {
		this.seasonNo = seasonNo;
	}
	
	

}
