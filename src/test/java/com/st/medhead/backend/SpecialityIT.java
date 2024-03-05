package com.st.medhead.backend;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.st.medhead.backend.controller.SpecialityController;

import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.model.Speciality;
import com.st.medhead.backend.service.SpecialityService;

import jakarta.inject.Inject;

//@WebMvcTest(controllers = {SpecialityController.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpecialityIT {
	@Inject
    private MockMvc mockMvc;
/*
	@MockBean
    private SpecialityService specialityService;
	*/
		
	private Hospital hospital;
	
	
	
	@Test
	public void givenASpecialities() throws Exception {
		
		//Iterable<Speciality> specialities;
		//given(this.specialityService.getSpecialities()).willReturn(specialities);		
		mockMvc.perform(get("/specialities"))
		.andExpect(status()
		.is2xxSuccessful())
		.equals(hospital);
		
	}
	
	@Test
	public void givenASpecialityAndACity_whenResquestIsGIveHospital_thenReserveBedIsPossible() throws Exception {
		
		mockMvc.perform(get("/speciality?id=1&city=1"))
		.andExpect(status()
		.is2xxSuccessful())
		.equals(hospital);
		
	}
}