package com.tour.controller;

import java.io.IOException;
import java.util.Set;

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

import com.tour.entity.Asset;
import com.tour.facade.Tourpackagefacade;
import com.tour.pojo.FacilityPojo;
import com.tour.pojo.InclusionPojo;
import com.tour.pojo.PricePojo;
import com.tour.pojo.TourPackageUpdatePojo;
import com.tour.pojo.TourpackagePojo;
import com.tour.response.PackageIdResponse;
import com.tour.response.TourpackageListResponse;
import com.tour.response.TourpackageResponse;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/package")
public class TourpackageController {
	
	@Autowired
	Tourpackagefacade tourPackageFacade;
	
	@GetMapping
	public  TourpackageListResponse allPackages() {
        return tourPackageFacade.listAllPackage();
    }
	@GetMapping("/{id}")
    public TourpackageResponse getpackge(@PathVariable long id) {
        return tourPackageFacade.getPackage(id);
        
    }
	@GetMapping("/image/{id}")
	public Set<Asset> getpackgeAsset(@PathVariable long id) {
        return tourPackageFacade.getPackImage(id); 
    }
    @PostMapping
    public PackageIdResponse create(@RequestBody TourpackagePojo tourPackagePojo) {
    	return tourPackageFacade.savePackageMainDetails(tourPackagePojo);
    }
    @PutMapping("/{id}")
    public TourpackageResponse update(@RequestBody TourPackageUpdatePojo pack, @PathVariable long id) {
    	pack.setId(id);
    	return tourPackageFacade.updatePakage(pack);
       
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	 tourPackageFacade.deletePackage(id);
    }
    
    //price
    
    @PostMapping("/price/{id}")
    public PackageIdResponse craetePrice(@PathVariable long id,@RequestBody PricePojo pricePojo) {
    	return tourPackageFacade.createPrice(id,pricePojo);
    } 
    
    @PostMapping("/facilty/{id}")
    public PackageIdResponse createFacity(@PathVariable long id,@RequestBody FacilityPojo  facilityPojo) {
    	return tourPackageFacade.createFacility(id,facilityPojo);
    }
    
    @PostMapping("/inclusion/{id}")
    public PackageIdResponse createInclusion(@PathVariable long id,@RequestBody InclusionPojo inclusionPojo) {
    	return tourPackageFacade.createInclusion(id,inclusionPojo);
    }
//    @PostMapping("/maindeatails/{id}")
//    public PackageIdResponse updatemaindetails(@PathVariable long id,@RequestBody ) {
//    	
//    }
    @PostMapping("/image/{id}")
    public PackageIdResponse createImage(@PathVariable long id,MultipartFile file) throws IOException {
    	return tourPackageFacade.createImage(id,file);
    }
}
