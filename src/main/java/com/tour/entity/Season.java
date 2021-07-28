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
import javax.persistence.OneToOne;

@Entity
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "season_tourpackages")
	private Set<Tourpackage> tourpackage;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "season_place")
	private Place place;

	private String name;
	private long seasonNo;

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Set<Tourpackage> getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(Set<Tourpackage> tourpackage) {
		this.tourpackage = tourpackage;
	}

	public long getSeasonNo() {
		return seasonNo;
	}

	public void setSeasonNo(long seasonNo) {
		this.seasonNo = seasonNo;
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

}
