package com.tour.response;

import java.util.List;

import com.tour.pojo.AssetPojo;

public class AssetListResponse extends AbstractPojoResponse{

	List<AssetPojo>  assetpojo;

	public List<AssetPojo> getAssetpojo() {
		return assetpojo;
	}

	public void setAssetpojo(List<AssetPojo> assetpojo) {
		this.assetpojo = assetpojo;
	}
}
