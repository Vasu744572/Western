package com.tour.response;

import java.util.List;

import com.tour.pojo.IterneryPojo;

public class IterneryPojoListResponse  extends AbstractPojoResponse{
	public List<IterneryPojo> iterneryListPojo;

	public List<IterneryPojo> getIterneryListPojo() {
		return iterneryListPojo;
	}

	public void setIterneryListPojo(List<IterneryPojo> iterneryListPojo) {
		this.iterneryListPojo = iterneryListPojo;
	}

}
