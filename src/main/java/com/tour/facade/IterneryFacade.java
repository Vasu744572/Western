package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.Iternery;
import com.tour.pojo.IterneryPojo;
import com.tour.response.IterneryPojoListResponse;
import com.tour.response.IterneryPojoResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.IterneryService;
import com.tour.util.ObjectMapperUtils;

@Component
public class IterneryFacade {

	@Autowired
	IterneryService iterneryService;

	public IterneryPojoResponse create(IterneryPojo iterneryPojo) {
		Iternery iternery = ObjectMapperUtils.map(iterneryPojo, Iternery.class);
		iternery = iterneryService.create(iternery);
		iterneryPojo = ObjectMapperUtils.map(iternery, IterneryPojo.class);
		return CreateDeleteUpdateResponse(iterneryPojo, "createdSuccessfully");
	}

	private IterneryPojoResponse CreateDeleteUpdateResponse(IterneryPojo iterneryPojo, String message) {
		IterneryPojoResponse iterneryPojoResponse = new IterneryPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<ResponseMessagePojo>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setStatus(HttpStatus.OK);
		responseMessagePojo.setSuccessMessage(message);
		successMessaages.add(responseMessagePojo);
		iterneryPojoResponse.setSuccessMessaages(successMessaages);
		return iterneryPojoResponse;
	}

	public IterneryPojoListResponse getAll() {
		IterneryPojoListResponse iterneryPojoListResponse = new IterneryPojoListResponse();
		List<Iternery> iterneryList = iterneryService.getAll();
		List<IterneryPojo> iterneryPojoList = ObjectMapperUtils.mapAll(iterneryList, IterneryPojo.class);
		iterneryPojoListResponse.setIterneryListPojo(iterneryPojoList);
		return iterneryPojoListResponse;
	}

	public IterneryPojoResponse update(IterneryPojo iterneryPojo) {
		Iternery iternery = iterneryService.findIterneryById(iterneryPojo.getId());
		ObjectMapperUtils.map(iterneryPojo, iternery);
		iternery = iterneryService.update(iternery);
		iterneryPojo=ObjectMapperUtils.map(iternery,IterneryPojo.class);
		return CreateDeleteUpdateResponse(iterneryPojo,"Updated Successfully");
	}

	public IterneryPojoResponse delete(long id) {
		Iternery iternery=iterneryService.findIterneryById(id);
		iterneryService.delete(iternery);
		return CreateDeleteUpdateResponse(null,"Deleted Successfully");
	}
}
