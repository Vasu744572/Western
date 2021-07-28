package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.Season;
import com.tour.pojo.SeasonPojo;
import com.tour.response.ResponseMessagePojo;
import com.tour.response.SeasonPojoListResponse;
import com.tour.response.SeasonPojoResponse;
import com.tour.service.SeasonService;
import com.tour.util.ObjectMapperUtils;

@Component
public class SeasonFacade {
	
	@Autowired
	SeasonService seasonService;

	public SeasonPojoResponse create(SeasonPojo seasonPojo) {
			Season season = ObjectMapperUtils.map(seasonPojo, Season.class);
			season = seasonService.create(season);
			seasonPojo = ObjectMapperUtils.map(season, SeasonPojo.class);
			return createDeleteUpdateResponse(seasonPojo,"Created successfully");
	}
	private SeasonPojoResponse createDeleteUpdateResponse(SeasonPojo seasonPojo,
			String message) {
		SeasonPojoResponse seasonPojoResponse = new SeasonPojoResponse();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		seasonPojoResponse.setSeasonPojo(seasonPojo);
		seasonPojoResponse.setSuccessMessaages(successMessaages);
		return seasonPojoResponse;
	}
	public SeasonPojoResponse get(long id) {
		SeasonPojoResponse seasonPojoResponse = new SeasonPojoResponse();
		Season season = seasonService.getById(id);
		SeasonPojo seasonPojo = ObjectMapperUtils.map(season, SeasonPojo.class);
		seasonPojoResponse.setSeasonPojo(seasonPojo);
		return seasonPojoResponse;
		}
	public SeasonPojoListResponse listAll() {
		SeasonPojoListResponse seasonPojoListResponse = new SeasonPojoListResponse();
				List<Season> season = seasonService.listAll();
				List<SeasonPojo> seasonPojo = ObjectMapperUtils.mapAll(season, SeasonPojo.class);
				seasonPojoListResponse.setSeasonPojo(seasonPojo);
				return seasonPojoListResponse;
			}
	public SeasonPojoResponse delete(long id) {
		Season season = seasonService.getById(id);
		seasonService.delete(season);
		return createDeleteUpdateResponse(null,"Deleted successfully");
		
	}
	public SeasonPojoResponse update(SeasonPojo seasonPojo) {
			Season season = ObjectMapperUtils.map(seasonPojo, Season.class);
			season = seasonService.Update(season);
			seasonPojo = ObjectMapperUtils.map(season, SeasonPojo.class);
				return createDeleteUpdateResponse(seasonPojo,"Updated successfully");
			}
	

	
}
