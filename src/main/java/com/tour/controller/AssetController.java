package com.tour.controller;

import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;

import com.tour.facade.AssetFacade;
import com.tour.pojo.AssetPojo;
import com.tour.response.AssetListResponse;
import com.tour.response.AssetResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/asset")
public class AssetController {

	@Autowired
	AssetFacade assetFacade;

	@GetMapping
	public AssetListResponse getAll() {
		return assetFacade.listAllAssets();
	}

	@GetMapping("/{id}")
	public AssetResponse get(@PathVariable long id) {
		return assetFacade.getAssets(id);

	}

	@PostMapping("/{packageid}")
	public AssetResponse create(MultipartFile file,@PathVariable("packageid") long packageId) throws IOException {
		return assetFacade.saveAsset(file,packageId); 
	}

	@PutMapping("/{id}")
	public AssetResponse update(@RequestBody AssetPojo asset, @PathVariable long id) {
		asset.setId(id);
		return assetFacade.updateAsset(asset);

	}

	@DeleteMapping("/{id}/{packageid}")
	public void delete(@PathVariable long id,@PathVariable long packageid) {
		assetFacade.deleteAsset(id,packageid);
	}
}
