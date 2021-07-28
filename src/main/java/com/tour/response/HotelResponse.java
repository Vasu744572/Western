package com.tour.response;

import com.tour.pojo.HotelPojo;

public class HotelResponse extends AbstractPojoResponse{

	HotelPojo hotelPojo;

	public HotelPojo getHotelPojo() {
		return hotelPojo;
	}

	public void setHotelPojo(HotelPojo hotelPojo) {
		this.hotelPojo = hotelPojo;
	}
}
