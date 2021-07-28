package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.PlaceFacede;
import com.tour.pojo.PlacePojo;
import com.tour.response.PlaceListResponse;
import com.tour.response.PlaceResponce;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceFacede placefacede;
	
	@GetMapping
	public  PlaceListResponse allPlaces() {
        return placefacede.listAllPlaces();
    }
	@GetMapping("/{id}")
    public PlaceResponce getPlace(@PathVariable long id) {
        return placefacede.getPlace(id);
        
    }
    @PostMapping
    public PlaceResponce create(@RequestBody PlacePojo place) {
    	return placefacede.savePlace(place);
    }
    @PutMapping("/{id}")
    public PlaceResponce update(@RequestBody PlacePojo place, @PathVariable long id) {
    	place.setId(id);
    	return placefacede.updatePlace(place);
       
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	placefacede.deletePlace(id);
    }
}
