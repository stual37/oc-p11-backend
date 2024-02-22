package com.st.medhead.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author sebastientual
 */
@Data
@Entity
@Table(name="city")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="name")
	private String Name;
/*
    @JsonIgnoreProperties("city")
    @OneToOne
    @JoinColumn(name = "hospitals_id")
    private Hospital Hospitals;
*/

    public City() {
        
    }

    public City(Integer id, String Name) {
        this.id = id;
        this.Name = Name;
    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
/*
    public Hospital getHospitals() {
        return this.Hospitals;
    }
    
    public void setHospital(Hospital Hospital) {
        this.Hospitals =Hospital;
    }
*/

}
