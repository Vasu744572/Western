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

import com.tour.facade.SeasonFacade;
import com.tour.pojo.SeasonPojo;
import com.tour.response.SeasonPojoListResponse;
import com.tour.response.SeasonPojoResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/season")
public class SeasonController {

	@Autowired
	SeasonFacade seasonFacade;

	@PostMapping
	public SeasonPojoResponse create(@RequestBody SeasonPojo seasonPojo) {
		return seasonFacade.create(seasonPojo);
	}

	@GetMapping("/{id}")
	public SeasonPojoResponse get(@PathVariable long id) {
		return seasonFacade.get(id);
	}

	@GetMapping
	public SeasonPojoListResponse getAll() {
		return seasonFacade.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		seasonFacade.delete(id);
	}

	@PutMapping("/{id}")
	public SeasonPojoResponse update(@RequestBody SeasonPojo seasonPojo, @PathVariable("id") long id) {
		seasonPojo.setId(id);
		return seasonFacade.update(seasonPojo);
	}

}
