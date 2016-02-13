package com.gorbatiouk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CompanyEmployee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;		
	private String name;	
	@ManyToOne
	@JsonBackReference
    private Company company;	
		
	public CompanyEmployee() {
		
	}			


	public CompanyEmployee(Integer id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
