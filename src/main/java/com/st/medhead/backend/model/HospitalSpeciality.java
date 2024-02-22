/**
 * 
 */
package com.st.medhead.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * 
 * @author sebastientual
 */
@SuppressWarnings("serial")
@Embeddable
public class HospitalSpeciality implements Serializable {
	@Column(name = "id_hospital")
	Integer idHopsital;
	
	@Column(name = "id_speciality")
	Integer idSpectiality;

	/**
	 * 
	 */
	public HospitalSpeciality() {
		super();
		
	}

	/**
	 * @param idHopsital
	 * @param idSpectiality
	 */
	public HospitalSpeciality(Integer idHopsital, Integer idSpectiality) {
		super();
		this.idHopsital = idHopsital;
		this.idSpectiality = idSpectiality;
	}
	
	
	
}
