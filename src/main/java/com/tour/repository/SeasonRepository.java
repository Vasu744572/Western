package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

}
