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

import com.tour.facade.HotelFacade;
import com.tour.pojo.HotelPojo;
import com.tour.response.HotelListResponse;
import com.tour.response.HotelResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	  HotelFacade hotelFacade;

	@GetMapping
	public HotelListResponse getAll() {
		return hotelFacade.listAllHotel();
	}

	@GetMapping("/{id}")
	public HotelResponse get(@PathVariable long id) {
		return hotelFacade.getHotel(id);

	}

	@PostMapping
	public HotelResponse create(@RequestBody HotelPojo hotel) {
		return hotelFacade.saveHotel(hotel);
	}

	@PutMapping("/{id}")
	public HotelResponse update(@RequestBody HotelPojo hotel, @PathVariable long id) {
		hotel.setId(id);
		return hotelFacade.updateHotel(hotel);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		hotelFacade.deleteHotel(id);
	}
}
