/**
 * 
 */
package com.st.medhead.backend.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.model.Speciality;
import com.st.medhead.backend.repository.SpecialityRepository;

import lombok.Data;

/**
 * 
 */
@Data
@Service
public class SpecialityService {
	@Autowired
	private SpecialityRepository specialityRepository;
	
	/**
	 * Premet de récupérer la lsites des spécialités
	 * @return un JSON avec toutes les spécialités
	 */
	public Iterable<Speciality> getSpecialities() {
		return specialityRepository.findAll();
	}
	
	/**
	 * Permet de récupérer la liste des hôpitaux en fonction de l'id de la spécialité
	 * @param id : L'id de la spoécialité
	 * @return : Un objet itérable d'hôpital
	 */
	public Set<Hospital> getHospitalsBySpecialityId(@NonNull Integer id) {
		return specialityRepository.findById(id).get().getHospitals();
	}
	
	
  /**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Speciality> getSpecialityById(@NonNull Integer id) {
		return specialityRepository.findById(id);
	}
}
