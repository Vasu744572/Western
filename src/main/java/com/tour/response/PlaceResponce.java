package com.tour.response;

import com.tour.pojo.PlacePojo;

public class PlaceResponce extends AbstractPojoResponse {

	PlacePojo placePojo;

	public PlacePojo getPlacePojo() {
		return placePojo;
	}

	public void setPlacePojo(PlacePojo placePojo) {
		this.placePojo = placePojo;
	}
}
