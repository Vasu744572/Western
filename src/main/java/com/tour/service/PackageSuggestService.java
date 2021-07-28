package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.entity.PackageSuggest;
import com.tour.repository.PackageSuggestRepository;

@Service
public class PackageSuggestService {
	
	@Autowired
	private PackageSuggestRepository packageSuggestRepository;

	public PackageSuggest create(PackageSuggest packageSuggest) {
		return packageSuggestRepository.save(packageSuggest);
	}

	public PackageSuggest getById(long id) {
		 return packageSuggestRepository.findById(id).get();
    }

	public List<PackageSuggest> listAll() {
		 return packageSuggestRepository.findAll();
	}

	public void delete(long id) {
		packageSuggestRepository.deleteById(id);
		
	}

	public PackageSuggest Update(PackageSuggest packageSuggest) {
		return packageSuggestRepository.save(packageSuggest);
		}
}
