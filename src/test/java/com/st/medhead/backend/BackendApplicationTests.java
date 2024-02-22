package com.st.medhead.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.st.medhead.backend.controller.LoginController;

@SpringBootTest
class BackendApplicationTests {

	
	@Autowired
	private LoginController loginController;

	@Test
	void contextLoads() {
		assertThat(loginController).isNotNull();
	}

}
