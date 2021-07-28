package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>  {

}
