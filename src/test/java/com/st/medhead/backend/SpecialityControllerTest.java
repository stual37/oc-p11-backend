/**
 * 
 */
package com.st.medhead.backend;

import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.st.medhead.backend.service.SpecialityService;

/**
 * 
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpecialityControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpecialityService specialityService;


    @SuppressWarnings("null")
    @Test
    void getSpecialities() throws Exception {
    	mockMvc.perform(get("/specialities"))
    	.andExpect(status().isOk())
    	// .andExpect(jsonPath("$[0].name", is("Cardiologie")))
    	;
    }

    @Test
    void getHospitalsBySpecialityIdAndCity() throws Exception {
    	mockMvc.perform(get("/speciality?id=1&city=1"))
    	.andExpect(status().isOk())
		;
    }

}
