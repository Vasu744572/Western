package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.entity.Place;
import com.tour.repository.PlaceRepositoty;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepositoty placeRepositoty;
	
	public List<Place> listAllPlace() {
        return placeRepositoty.findAll();
    }
	
	public Place savePlace(Place place) {
		return placeRepositoty.save(place);
    }
	
	public Place UpdatePlace(Place place) {
		return placeRepositoty.save(place);
	}
	
	public Place getPlaceById(long id) {
        return placeRepositoty.findById(id).get();
    }
	
	public void deletePlace(long id) {
		placeRepositoty.deleteById(id);
    }
}
