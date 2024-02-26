package com.st.medhead.backend;


import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.st.medhead.backend.model.City;
import com.st.medhead.backend.model.Hospital;
import com.st.medhead.backend.model.Speciality;
import com.st.medhead.backend.repository.CityRepository;
import com.st.medhead.backend.repository.HospitalRepository;
import com.st.medhead.backend.repository.SpecialityRepository;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
	}
	
	
	@Bean
	CommandLineRunner initDatabase(SpecialityRepository specialityRepository, HospitalRepository hospitalRepository, CityRepository cityRepository) {
		//On créé les villes
		City city1 = new City(1, "PARIS");
		City city2 = new City(2, "BORDEAUX");
		City city3 = new City(3, "MARSEILLE");

		
		Set<Hospital> hospitals1 =  new HashSet<Hospital>();
		Set<Hospital> hospitals2 =  new HashSet<Hospital>();
		Set<Hospital> hospitals3 =  new HashSet<Hospital>();
		Set<Hospital> hospitals4 =  new HashSet<Hospital>();
		//On créé les hôpitaux
		Hospital hospital1 = new Hospital(1, "Hôpital Fred Brooks", 2, city1);
		Hospital hospital2 = new Hospital(2, "Hôpital Julia Crusher", 0, city2);
		Hospital hospital3 = new Hospital(3, "Hôpital Beverly Bashir", 5, city3);
	
		//On créé les spécialités
		hospitals1.add(hospital1);
		hospitals1.add(hospital2);
		Speciality speciality1 = new Speciality(1, "Cardiologie", hospitals1);
		// On nettoie le Set
		//hospitals.clear();
		hospitals2.add(hospital1);
		hospitals2.add(hospital3);
		Speciality speciality2 = new Speciality(2, "Immunologie", hospitals2);
		// On nettoie le Set
		//hospitals.clear();
		hospitals3.add(hospital3);
		Speciality speciality3 = new Speciality(3, "Neuropathologie", hospitals3);
		// On nettoie le Set
		//hospitals.clear();
		hospitals4.add(hospital3);
		Speciality speciality4 = new Speciality(4, "Diagnostic", hospitals3);
		
		
		//On enregistre toutes les données
		return args -> {
			cityRepository.save(city1);
			cityRepository.save(city2);
			cityRepository.save(city3);
			hospitalRepository.save(hospital1);
			hospitalRepository.save(hospital2);
			hospitalRepository.save(hospital3);
			specialityRepository.save(speciality1);
			specialityRepository.save(speciality2);
			specialityRepository.save(speciality3);
			specialityRepository.save(speciality4);
			
		};
		
	}
	
	
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
				registry.addMapping("/**")
				.allowCredentials(true)
				.allowedOriginPatterns("http://*", "localhost", "127.0.0.1", "192.*")
				.allowedMethods("GET", "POST")
				.allowedHeaders("*")
				.exposedHeaders("*")
                .allowCredentials(true).maxAge(3600);
			}
		};
	}

}
