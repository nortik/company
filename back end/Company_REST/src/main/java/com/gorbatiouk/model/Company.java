package com.gorbatiouk.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Company implements Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;
	private String name;
	private String address;
	private String city;
	private String country;
	private String email;
	private String phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company",fetch = FetchType.EAGER, orphanRemoval=true)
	@JsonManagedReference
	private List<CompanyEmployee> employee = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company",fetch = FetchType.EAGER, orphanRemoval=true)
	@JsonManagedReference
	private List<BeneficialOwner> beneficialOwner = new ArrayList<>();
	
	public Company() {
	}
	
	public Company( String name, String address, String city, String country,
			String email, String phoneNumber, List<CompanyEmployee> employee) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<CompanyEmployee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<CompanyEmployee> employee) {
		this.employee = employee;
	}
	
    public Company clone()   {
    	Company clon = new Company(this.name,this.address,
    			this.city,this.country,this.email,this.phoneNumber,null);
    return clon;
    
    
 }

	public List<BeneficialOwner> getBeneficialOwner() {
		return beneficialOwner;
	}

	public void setBeneficialOwner(List<BeneficialOwner> beneficialOwner) {
		this.beneficialOwner = beneficialOwner;
	}

}