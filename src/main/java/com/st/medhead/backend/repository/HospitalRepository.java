package com.st.medhead.backend.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.st.medhead.backend.model.City;
import com.st.medhead.backend.model.Hospital;

/**
 * @author sebastientual
 */
@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer> {

    Hospital findByCity(City city);
    
	
}