package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Tourpackage;



@Repository
public interface Packagerepository extends JpaRepository<Tourpackage, Long> {


}
