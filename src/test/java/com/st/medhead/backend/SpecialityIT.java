package com.st.medhead.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.st.medhead.backend.controller.SpecialityController;

import com.st.medhead.backend.model.Hospital;


import jakarta.inject.Inject;

@WebMvcTest(controllers = {SpecialityController.class})
@ExtendWith(SpringExtension.class)
public class SpecialityIT {
	@Inject
    private MockMvc mockMvc;

	
	
	private Hospital hospital;
	
	@Autowired
	SpecialityController specialityController;
	
	@Test
	public void givenASpecialityAndACity_whenResquestIsGIveHospital_thenReserveBedIsPossible() throws Exception {
		
		
		mockMvc.perform(get("/speciality?id=1&city=1"))
		.andExpect(status()
		.is2xxSuccessful())
		.equals(hospital);
	}
}