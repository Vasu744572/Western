package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
