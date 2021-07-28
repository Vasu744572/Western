package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.Hotel;
import com.tour.pojo.HotelPojo;
import com.tour.response.HotelListResponse;
import com.tour.response.HotelResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.HotelService;
import com.tour.util.ObjectMapperUtils;

@Component
public class HotelFacade {

	@Autowired
	HotelService hotelService;
	
	public HotelListResponse listAllHotel() {
		HotelListResponse hotelListResponse = new HotelListResponse();
		List<Hotel> HotelEntity = hotelService.listAllHotel();
		List<HotelPojo> hotelPojo = ObjectMapperUtils.mapAll(HotelEntity, HotelPojo.class);
		hotelListResponse.setHotelPojo(hotelPojo);
		return hotelListResponse;
	}

	public HotelResponse getHotel(long id) {
		HotelResponse hotelResponse = new HotelResponse();
		Hotel hotelEntity = hotelService.getHotelById(id);
		HotelPojo hotelPojo = ObjectMapperUtils.map(hotelEntity, HotelPojo.class);
		hotelResponse.setHotelPojo(hotelPojo);
		return hotelResponse;
	}
	
	public HotelResponse saveHotel(HotelPojo hotelPojo)
	{
		Hotel hotelEntity = ObjectMapperUtils.map(hotelPojo, Hotel.class);
		Hotel hotelserviceEntity = hotelService.saveHotel(hotelEntity);
		HotelPojo hotelservicePojo = ObjectMapperUtils.map(hotelserviceEntity, HotelPojo.class);
		return createDeleteUpdateResponse(hotelservicePojo,"Created successfully");
	}
	

	public  HotelResponse updateHotel(HotelPojo HotelPojo) {
		Hotel hotelEntity = ObjectMapperUtils.map(HotelPojo, Hotel.class);
		Hotel hotelserviceEntity = hotelService.UpdateHotel(hotelEntity);
		HotelPojo hotelservicePojo = ObjectMapperUtils.map(hotelserviceEntity, HotelPojo.class);
		return createDeleteUpdateResponse(hotelservicePojo,"Updated successfully");
	}
	
	public HotelResponse deleteHotel(long id) {
		hotelService.deleteHotel(id);
		return createDeleteUpdateResponse(null,"Deleted successfully");
		
	}
	
	private HotelResponse createDeleteUpdateResponse(HotelPojo hotelservicePojo, String message) {
		HotelResponse hotelResponce = new HotelResponse();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		hotelResponce.setHotelPojo(hotelservicePojo);
		hotelResponce.setSuccessMessaages(successMessaages);
		return hotelResponce;
	}
}
