package com.st.medhead.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.service.HospitalService;

/**
 * @author sebastientual
 */
@CrossOrigin
@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	/**
	 * Permet de récupérer tous les hôpitaux
	 * @return un objet itérable avec tous les hôpitaux
	 */
	@GetMapping("/hospitals")
	public Iterable<Hospital> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}
	
	
	/**
	 * Permet de réserver un lit dans un hôpital
	 * @param id : l'id de l'hôpital
	 * @return une réponse contenant l'hôpital mis à jour 
	 * @throws Exception l'erreur qui s'est produite
	 */
	@PutMapping("/hospital/reserve-bed/{id}")
	public ResponseEntity<Hospital> ReserveBed(@PathVariable Integer id) throws Exception {
		ResponseEntity<?> response;
		try {
			Hospital hospital = hospitalService.reserveBed(id);
			
			response =  new ResponseEntity<> (hospital, HttpStatus.OK);
		}
		catch(Exception e)  {
			response = new ResponseEntity<> (e.toString(), HttpStatus.FORBIDDEN);
		}
		return (ResponseEntity<Hospital>) response;
	}
	
	/**
	 * Permet d'ajouter un lit dans un hôpital
	 * @param id : l'id de l'hôpital
	 * @return une réponse contenant l'hôpital mis à jour 
	 * @throws Exception l'erreur qui s'est produite
	 */
	@PutMapping("/hospital/add-bed/{id}")
	public ResponseEntity<Hospital> AddBed(@PathVariable Integer id) throws Exception {
		ResponseEntity<?> response;
		try {
			Hospital hospital = hospitalService.addBed(id);
			
			response =  new ResponseEntity<> (hospital, HttpStatus.OK);
		}
		catch(Exception e)  {
			response = new ResponseEntity<> (e.toString(), HttpStatus.FORBIDDEN);
		}
		return (ResponseEntity<Hospital>) response;
	}
	

}