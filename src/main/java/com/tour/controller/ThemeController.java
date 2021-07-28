package com.tour.controller;

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

import com.tour.facade.ThemeFacade;
import com.tour.pojo.ThemePojo;
import com.tour.response.ThemeListResponse;
import com.tour.response.ThemeResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/theme")
public class ThemeController {

	@Autowired
	ThemeFacade themeFacade;
	
	@GetMapping
	public  ThemeListResponse allTheme() {
        return themeFacade.listAllThemes();
    }
	@GetMapping("/{id}")
    public ThemeResponse getTheme(@PathVariable long id) {
        return themeFacade.getTheme(id);
        
    }
    @PostMapping
    public ThemeResponse create(@RequestBody ThemePojo theme) {
    	return themeFacade.saveTheme(theme);
    }
    @PutMapping("/{id}")
    public ThemeResponse update(@RequestBody ThemePojo theme, @PathVariable long id) {
    	theme.setId(id);
    	return themeFacade.updateTheme(theme);
       
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	themeFacade.deleteTheme(id);
    }
}
