package com.tour.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.tour.entity.Asset;
import com.tour.entity.Tourpackage;
import com.tour.pojo.AssetPojo;
import com.tour.response.AssetListResponse;
import com.tour.response.AssetResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.AssetService;
import com.tour.service.TourpackageService;
import com.tour.util.ObjectMapperUtils;

@Component
public class AssetFacade {

	@Autowired
	private AssetService assetService;
	
	@Autowired
	private TourpackageService tourPackageService;

	public AssetListResponse listAllAssets() {
		AssetListResponse assetListResponse = new AssetListResponse();
		List<Asset> assetEntity = assetService.listAllAsset();
		List<AssetPojo> assetPojo = ObjectMapperUtils.mapAll(assetEntity, AssetPojo.class);
		assetListResponse.setAssetpojo(assetPojo);
		return assetListResponse;
	}

	public AssetResponse getAssets(long id) {
		AssetResponse assetResponse = new AssetResponse();
		Asset assetEntity = assetService.getAssetById(id);
		byte[] decodedBytes = Base64.getUrlDecoder().decode(assetEntity.getBase64());
		String decodedUrl = new String(decodedBytes);
		assetEntity.setBase64(decodedUrl);
		AssetPojo assetPojo = ObjectMapperUtils.map(assetEntity, AssetPojo.class);
		assetResponse.setAssetPojo(assetPojo);
		return assetResponse;

	}

	public AssetResponse saveAsset(MultipartFile file, long packageId) throws IOException {
		Asset assetEntity = new Asset();
		assetEntity.setFiletype(file.getContentType());
		assetEntity.setFilesize(String.valueOf(file.getSize()));
		assetEntity.setImagename(file.getName());
		byte[] fileContent = Base64.getEncoder().encode(file.getBytes());
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		assetEntity.setBase64(encodedString);
		Asset assetServiceEntity = assetService.saveAsset(assetEntity);
        Tourpackage tourpackage=tourPackageService.getPackageById(packageId);
        Set<Asset> assets=tourpackage.getImages();
        assets.add(assetServiceEntity);
        tourpackage.setImages(assets);
        tourPackageService.savePackage(tourpackage);
		AssetPojo assetPojo = ObjectMapperUtils.map(assetServiceEntity, AssetPojo.class);
		return createDeleteUpdateResponse(assetPojo, "Created successfully");
	}

	public AssetResponse updateAsset(AssetPojo asset) {

		Asset assetEntity = ObjectMapperUtils.map(asset, Asset.class);
		Asset assetServiceEntity = assetService.UpdateAsset(assetEntity);
		AssetPojo assetPojo = ObjectMapperUtils.map(assetServiceEntity, AssetPojo.class);
		return createDeleteUpdateResponse(assetPojo, "Updated successfully");
	}

	public AssetResponse deleteAsset(long id, long packageid) {
		Tourpackage tourpackage=tourPackageService.getPackageById(packageid);
		Asset asset = assetService.getAssetById(id);
		tourpackage.getImages().remove(asset);
		tourPackageService.UpdatePackage(tourpackage);
		assetService.deleteAsset(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	private AssetResponse createDeleteUpdateResponse(AssetPojo assetPojo, String message) {
		AssetResponse assetResponse = new AssetResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		assetResponse.setAssetPojo(assetPojo);
		assetResponse.setSuccessMessaages(successMessaages);
		return assetResponse;
	}
}
