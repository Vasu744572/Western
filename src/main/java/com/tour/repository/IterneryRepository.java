package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.entity.Iternery;

public interface IterneryRepository extends JpaRepository<Iternery, Long>{
Iternery findById(long id);
}
