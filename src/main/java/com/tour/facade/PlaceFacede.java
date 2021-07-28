package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.Place;
import com.tour.pojo.PlacePojo;
import com.tour.response.PlaceListResponse;
import com.tour.response.PlaceResponce;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.PlaceService;
import com.tour.util.ObjectMapperUtils;

@Component
public class PlaceFacede {

	@Autowired
	PlaceService placeService;
	
	public PlaceListResponse listAllPlaces() {
		PlaceListResponse placeListResponse = new PlaceListResponse();
		List<Place> PlaceEntity = placeService.listAllPlace();
		List<PlacePojo> placePojo = ObjectMapperUtils.mapAll(PlaceEntity, PlacePojo.class);
		placeListResponse.setPlacePojos(placePojo);
		return placeListResponse;
	}

	public PlaceResponce getPlace(long id) {
		PlaceResponce placeResponce = new PlaceResponce();
		Place placeEntity = placeService.getPlaceById(id);
		PlacePojo placePojo = ObjectMapperUtils.map(placeEntity, PlacePojo.class);
		placeResponce.setPlacePojo(placePojo);
		return placeResponce;
		
	}
	
	public PlaceResponce savePlace(PlacePojo placepojo)
	{
		Place placeEntity = ObjectMapperUtils.map(placepojo, Place.class);
		Place placeserviceEntity = placeService.savePlace(placeEntity);
		PlacePojo placeservicePojo = ObjectMapperUtils.map(placeserviceEntity, PlacePojo.class);
		return createDeleteUpdateResponse(placeservicePojo,"Created successfully");
	}
	

	public  PlaceResponce updatePlace(PlacePojo placepojo) {
		PlaceResponce placeResponce = new PlaceResponce();
		Place placeEntity = ObjectMapperUtils.map(placepojo, Place.class);
		Place placeserviceEntity = placeService.UpdatePlace(placeEntity);
		PlacePojo placeservicePojo = ObjectMapperUtils.map(placeserviceEntity, PlacePojo.class);
		placeResponce.setPlacePojo(placeservicePojo);
		return placeResponce;
	}
	
	public void deletePlace(long id) {
		placeService.deletePlace(id);
		
	}
	
	private PlaceResponce createDeleteUpdateResponse(PlacePojo placeservicePojo, String message) {
		PlaceResponce placeResponce = new PlaceResponce();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		placeResponce.setPlacePojo(placeservicePojo);
		placeResponce.setSuccessMessaages(successMessaages);
		return placeResponce;
	}
}
