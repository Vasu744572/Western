package com.tour.response;

import java.util.List;

import com.tour.pojo.HotelPojo;

public class HotelListResponse extends AbstractPojoResponse{

	List<HotelPojo> hotelPojo;

	public List<HotelPojo> getHotelPojo() {
		return hotelPojo;
	}

	public void setHotelPojo(List<HotelPojo> hotelPojo) {
		this.hotelPojo = hotelPojo;
	}
}
