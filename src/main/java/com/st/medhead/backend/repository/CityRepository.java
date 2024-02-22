package com.st.medhead.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.st.medhead.backend.model.City;

/**
 * 
 * @author sebastientual
 */
@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    
}
