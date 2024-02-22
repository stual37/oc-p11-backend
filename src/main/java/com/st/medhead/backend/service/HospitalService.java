/**
 * 
 */
package com.st.medhead.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.st.medhead.backend.model.City;
import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.repository.HospitalRepository;

import lombok.Data;

/**
 * 
 */
@Data
@Service
public class HospitalService {
	@Autowired
	private HospitalRepository hospitalRepository;
	
	
	/**
	 * Permet de récuprérer tous les hôpitaux dans un objet itérable
	 * @return un objet itérable avec tous les hôpitaux
	 */
	public Iterable<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}
	
	
	/**
	 * Permet de retrouver un hôpital en fonction de son id
	 * @param id : l'id de l'hôpital
	 * @return un JSON avec les hôpitaux disponibles
	 */	
	public Optional<Hospital> getHospitalsById(@NonNull Integer id) {
		return hospitalRepository.findById(id);
	}

	/**
	 * Permet de récupérer un hôpital en fonction de ville
	 * @param city : String NOm de la ville
	 * @return : un Objet de type Hospital
	 */
	public Hospital getHospitalByCity(City city) {
		return hospitalRepository.findByCity(city);
	}


  /**
   * Permet de réserver un lit dans un hôpital
   * @param id : Integer l'id de lhôpital
   * @return un Objet de type Hospital
   * @throws Exception
   */
	public Hospital reserveBed(Integer id) throws Exception {
		@SuppressWarnings("null")
		Hospital hospital = hospitalRepository.findById(id).get();
		int bedAvailable = hospital.getBedAvailable();
		// On vérifie que le nombre de lit disponible n'est pas à 0
		if( bedAvailable == 0) {
			throw new Exception("Il n'est pas possible de réserver un lit. Nombre limite atteint");
		}
		// On met à jour le nombre de lit disponible
		hospital.setBedAvailable(bedAvailable-1);
		// On sauvegarde
		hospitalRepository.save(hospital);
		return hospital;
	}
	
	/**
	   * Permet d'ajouter un lit dans un hôpital
	   * @param id : Integer l'id de lhôpital
	   * @return un Objet de type Hospital
	   * @throws Exception
	   */
		public Hospital addBed(Integer id) throws Exception {
			@SuppressWarnings("null")
			Hospital hospital = hospitalRepository.findById(id).get();
			//On récupère le nombre de lit disponible
			int bedAvailable = hospital.getBedAvailable();
			// on incrémente le nombre de lit disponible de 1
			hospital.setBedAvailable(bedAvailable+1);
			// On sauvegarde
			hospitalRepository.save(hospital);
			return hospital;
		}
	
}
