package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme , Long> {


} 
