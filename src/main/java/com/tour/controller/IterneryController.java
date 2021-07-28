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

import com.tour.facade.IterneryFacade;
import com.tour.pojo.IterneryPojo;
import com.tour.response.IterneryPojoListResponse;
import com.tour.response.IterneryPojoResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/iternery")
public class IterneryController {

	@Autowired
	private IterneryFacade iterneryFacade;

	@PostMapping
	public IterneryPojoResponse create(@RequestBody IterneryPojo iterneryPojo) {
		return iterneryFacade.create(iterneryPojo);

	}

	@GetMapping
	public IterneryPojoListResponse get() {
		return iterneryFacade.getAll();

	}

	@PutMapping
	public IterneryPojoResponse update(@RequestBody IterneryPojo iterneryPojo) {
		return iterneryFacade.update(iterneryPojo);

	}
	
	@DeleteMapping("{id}")
	public IterneryPojoResponse delete(@PathVariable("id") long Id) {
		return iterneryFacade.delete(Id);
		
	}
}
