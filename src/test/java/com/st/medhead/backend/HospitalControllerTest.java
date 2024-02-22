package com.st.medhead.backend;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.service.HospitalService;

//@WebMvcTest(controllers = HospitalControllerTest.class)
@SpringBootTest
@AutoConfigureMockMvc
class HospitalControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalService hospitalService;

    @Test
    void getHospitals() throws Exception {
      ArrayList<Hospital> listHospital = (ArrayList<Hospital>) hospitalService.getAllHospitals();
      
    	mockMvc.perform(get("/hospitals"))
			.andExpect(status().isOk());
    }


    @Test
    void reserveBed() throws Exception {
      ResultActions res = 	mockMvc.perform(MockMvcRequestBuilders
    	.put("/hospital/reserve-bed/1"))
		  .andExpect(status().isOk());

    }

/*
    @Test
    void addBed() throws Exception {
    	Integer nbBed = hospitalService.getHospitalsById(3).get().getBedAvailable();

    	mockMvc.perform(MockMvcRequestBuilders
    		.put("/hospital/add-bed/3"))
    		.andExpect(status().isOk());
    }
    */
}
