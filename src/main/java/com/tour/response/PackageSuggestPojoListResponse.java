package com.tour.response;

import java.util.List;

import com.tour.pojo.PackageSuggestPojo;

public class PackageSuggestPojoListResponse extends AbstractPojoResponse {
	
	List<PackageSuggestPojo> packageSuggestPojo;

	public List<PackageSuggestPojo> getPackageSuggestPojo() {
		return packageSuggestPojo;
	}

	public void setPackageSuggestPojo(List<PackageSuggestPojo> packageSuggestPojo) {
		this.packageSuggestPojo = packageSuggestPojo;
	}
	

}
