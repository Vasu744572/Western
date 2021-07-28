package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.entity.Season;
import com.tour.repository.SeasonRepository;

@Service
public class SeasonService {
	@Autowired
	private SeasonRepository seasonRepository;

	public Season create(Season season) {
		return seasonRepository.save(season);
	}

	public Season getById(long id) {
		return seasonRepository.findById(id).get();
	}

	public List<Season> listAll() {
		 return seasonRepository.findAll();
	}

	public void delete(Season season) {
		seasonRepository.delete(season);
		
	}

	public Season Update(Season season) {
		return seasonRepository.save(season);
	}

}
