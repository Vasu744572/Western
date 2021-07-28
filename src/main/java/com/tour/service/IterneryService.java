package com.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tour.entity.Iternery;
import com.tour.repository.IterneryRepository;

@Service
public class IterneryService {

	private IterneryRepository iterneryRepository;

	public Iternery create(Iternery iternery) {
		return iterneryRepository.save(iternery);
	}

	public List<Iternery> getAll() {

		return iterneryRepository.findAll();
	}

	public Iternery findIterneryById(long id) {
		return iterneryRepository.findById(id);
	}

	public Iternery update(Iternery iternery) {

		return iterneryRepository.save(iternery);
	}

	public void delete(Iternery iternery) {
		iterneryRepository.delete(iternery);
	}
}
