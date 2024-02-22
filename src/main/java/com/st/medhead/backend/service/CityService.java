package com.st.medhead.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.medhead.backend.model.City;
import com.st.medhead.backend.repository.CityRepository;

import lombok.Data;

/**
 * 
 * @author sebastientual
 */
@Data
@Service
public class CityService {
    @Autowired
	//private HospitalRepository hospitalRepository;
    private CityRepository cityRepository;

    /**
     * Permet de récupérer la liste des villes
     * @return un objet itérable des villes
     */
    public Iterable<City> getCities() {
        return cityRepository.findAll();
    }

    /**
     * Permet de récupérer un ville en fonction de son id
     * @param id  : Integer id de la ville
     * @return un objet sur la ville
     */
    @SuppressWarnings("null")
    public Optional<City> getCityById(Integer id) {
        return cityRepository.findById(id);
    }
}