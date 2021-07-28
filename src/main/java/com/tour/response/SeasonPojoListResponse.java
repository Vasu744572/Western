package com.tour.response;

import java.util.List;

import com.tour.pojo.SeasonPojo;

public class SeasonPojoListResponse extends AbstractPojoResponse {
	List<SeasonPojo> seasonPojo;

	public List<SeasonPojo> getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(List<SeasonPojo> seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	
	

}
