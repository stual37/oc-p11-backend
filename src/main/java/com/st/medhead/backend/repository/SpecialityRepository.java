/**
 * 
 */
package com.st.medhead.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.st.medhead.backend.model.Speciality;

/**
 * @author sebastientual
 */
@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Integer> {
	

}