package com.st.medhead.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.st.medhead.backend.model.City;
import com.st.medhead.backend.service.CityService;

/**
 * 
 * @author sebastientual
 */
@CrossOrigin
@RestController
public class CityController {
    @Autowired
	private CityService cityService;

    /**
     * 
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(path="/cities", produces = "application/json")
	public  Iterable<City> getCities() throws JsonProcessingException {		
		return cityService.getCities();
	}

}
