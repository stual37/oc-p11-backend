package com.st.medhead.backend.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;



/**
 * @author sebastientual
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="speciality")
public class Speciality implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnoreProperties("specialities")
	@ManyToMany
	@JoinTable( name = "hospital_speciality",  joinColumns = @JoinColumn(name = "speciality_id"), inverseJoinColumns = @JoinColumn(name = "hospital_id"))
	private Set<Hospital> hospitals;

	
	public Speciality() {
		super();
	}
	
	/**
	 * @param id
	 * @param idName
	 * @param name
	 */
	public Speciality(Integer id, String name, Set<Hospital> hospitals) {
		super();
		this.id = id;
		this.name = name;
		this.hospitals = hospitals;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @return the value
	 */
	public String getName() {
		return name;
	}
	
	

	/**
	 * @return the hospitals
	 */
	public Set<Hospital> getHospitals() {
		return hospitals;
	}

	/**
	 * @param hospitals the hospitals to set
	 */
	public void addHospitals(Hospital hospital) {
		this.hospitals.add(hospital);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}

	@Override
	public String toString() {
		return "'Speciality_"+this.id +"': { 'id':" + this.id + ", 'name':'" + this.name + '\'' + '}';
	}
	
	

	
	
}
