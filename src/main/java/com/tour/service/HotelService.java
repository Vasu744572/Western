package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.entity.Hotel;
import com.tour.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> listAllHotel() {
        return hotelRepository.findAll();
    }
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
    }
	
	public Hotel UpdateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public Hotel getHotelById(long id) {
        return hotelRepository.findById(id).get();
    }
	
	public void deleteHotel(long id) {
		hotelRepository.deleteById(id);
    }

}
