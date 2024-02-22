package com.st.medhead.backend.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.model.Speciality;
import com.st.medhead.backend.service.SpecialityService;

/**
 * @author sebastientual
 */
@CrossOrigin
@RestController
public class SpecialityController {
	@Autowired
	private SpecialityService specialityService;
	
	/**
	 * Permet de récupérer toutes les spécialités
	 * @return un objet iterable de toutes les spécialités
	 * @throws JsonProcessingException 
	 */
	@GetMapping(path="/specialities", produces = "application/json")
	public  Iterable<Speciality> getSpecialities() throws JsonProcessingException {		
		return specialityService.getSpecialities();
	}
	
	/**
	 * Permet de récupérer une des hôpitaux une fonction de l'id de la spécialité
	 * @param id : Integer id de la spécialité
	 * @return un objet irtérable d'hôpitaux
	 */
	@GetMapping("/speciality/{id}")
	public Iterable<Hospital> getHospitalsBySpecialityId(@PathVariable Integer id) {	
		try {
			Set<Hospital> hospitals = specialityService.getHospitalsBySpecialityId(id);
			Set<Hospital> newSetHospitals = new HashSet<Hospital>();
			hospitals.forEach(h -> {
        
				if(h.getBedAvailable() != 0) {
          
					newSetHospitals.add(h);
					//hospitals.remove(h);
				}
			}); 
      
			return newSetHospitals;
			//return hospitals;
		}
		catch(Exception e) {
			return null;
		}
		
	}

	/**
	 * Permet de récupérer une liste d'hôpitaux en fonction de l'id de la spécialité et de la ville choisie
	 * @param id : Integer id de l'hôpital
	 * @param city : Integer nom de la ville
	 * @return
	 */
	@GetMapping("/speciality")
	public Iterable<Hospital> getHospitalsBySpecialityIdAndCity(@RequestParam Integer id, @RequestParam(name="city")  Integer cityId) {	
		try {
			Set<Hospital> hospitals = specialityService.getHospitalsBySpecialityId(id);
			Set<Hospital> newSetHospitals = new HashSet<Hospital>();
			hospitals.forEach(h -> {
				if(h.getCity().getId() == cityId) {
					newSetHospitals.add(h);
					//hospitals.remove(h);
				}
			});
			     
			return newSetHospitals;
			//return hospitals;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
}
