package com.st.medhead.backend.model;



import java.io.Serializable;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author sebastientual
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="hospital")
public class Hospital implements Serializable {
	//@PersistenceContext
	//private EntityManager entityManager;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="bed_available")
	private int bedAvailable;
	
	@JsonIgnoreProperties("hospitals")
	@OneToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@JsonIgnoreProperties("hospitals")
	@ManyToMany
	@JoinTable( name = "hospital_speciality",  joinColumns = @JoinColumn(name = "hospital_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities;
	
	
	/**
	 * Constructeur vide ne faisant rien
	 */
	public Hospital() {
		super();
	}

	/**
	 * Constructeur permettant de créer un hôpital avec des valeurs passées en paramètre
	 * @param id : Integer id de l'hôpital
	 * @param name : String nom de l'hôpital
	 * @param bedAvailable : int nombre de lit disponible
	 */
	public Hospital(Integer id, String name, int bedAvailable) {
		super();
		
		this.id = id;
		Name = name;
		this.bedAvailable = bedAvailable;
	}
	/**
	 * Constructeur permettant de créer un hôpital avec des valeurs passées en paramètre
	 * @param id : Integer id de l'hôpital
	 * @param name : String nom de l'hôpital
	 * @param bedAvailable : int nombre de lit disponible
	 */
	public Hospital(Integer id, String name, int bedAvailable, City city) {
		super();
		
		this.id = id;
		Name = name;
		this.bedAvailable = bedAvailable;
		this.city = city;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @return the bedAvailable
	 */
	public int getBedAvailable() {
		return bedAvailable;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	
	/**
	 * @return the specialities
	 */
	public Set<Speciality> getSpecialities() {
		return this.specialities;
	}

	public void addSpeciality (Speciality speciality) {
		this.specialities.add(speciality);
		speciality.getHospitals().add(this);
	}
	
	/**
	 * @param o
	 * @return un boolean
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return specialities.contains(o);
	}

	/**
	 * @param bedAvailable the bedAvailable to set
	 */
	public void setBedAvailable(int bedAvailable) {
		this.bedAvailable = bedAvailable;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
