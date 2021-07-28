package com.tour.response;

import com.tour.pojo.AssetPojo;

public class AssetResponse extends AbstractPojoResponse{

	AssetPojo assetPojo;

	public AssetPojo getAssetPojo() {
		return assetPojo;
	}

	public void setAssetPojo(AssetPojo assetPojo) {
		this.assetPojo = assetPojo;
	}
}
