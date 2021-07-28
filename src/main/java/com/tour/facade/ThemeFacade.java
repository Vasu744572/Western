package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.entity.Theme;
import com.tour.pojo.ThemePojo;
import com.tour.response.ThemeListResponse;
import com.tour.response.ThemeResponse;
import com.tour.service.ThemeService;
import com.tour.util.ObjectMapperUtils;

@Component
public class ThemeFacade {

	@Autowired
	ThemeService themeService;
	
	public ThemeListResponse listAllThemes() {
		ThemeListResponse themeListResponse = new ThemeListResponse();
		List<Theme> themeEntity = themeService.listAllTheme();
		List<ThemePojo> themePojo = ObjectMapperUtils.mapAll(themeEntity, ThemePojo.class);
		themeListResponse.setThemePojo(themePojo);
		return themeListResponse;
	}

	public ThemeResponse getTheme(long id) {
		ThemeResponse themeResponce = new ThemeResponse();
		Theme themeEntity = themeService.getThemeById(id);
		ThemePojo ThemePojo = ObjectMapperUtils.map(themeEntity, ThemePojo.class);
		themeResponce.setThemePojo(ThemePojo);
		return themeResponce;
		
	}
	
	public ThemeResponse saveTheme(ThemePojo themepojo)
	{
		ThemeResponse themeResponce = new ThemeResponse();
		Theme themeEntity = ObjectMapperUtils.map(themepojo, Theme.class);
		Theme themeServiceEntity = themeService.saveTheme(themeEntity);
		ThemePojo themeServicePojo = ObjectMapperUtils.map(themeServiceEntity, ThemePojo.class);
		themeResponce.setThemePojo(themeServicePojo);
		return themeResponce;
	}
	
	public  ThemeResponse updateTheme(ThemePojo themepojo) {
		ThemeResponse themeResponce = new ThemeResponse();
		Theme themeEntity = ObjectMapperUtils.map(themepojo, Theme.class);
		Theme themeServiceEntity = themeService.UpdateTheme(themeEntity);
		ThemePojo themeServicePojo = ObjectMapperUtils.map(themeServiceEntity, ThemePojo.class);
		themeResponce.setThemePojo(themeServicePojo);
		return themeResponce;
	}
	
	public void deleteTheme(long id) {
		themeService.deleteTheme(id);
		
	}
}
