package com.gorbatiouk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BeneficialOwner {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;	
    private String nameBO;    
	@ManyToOne
	@JsonBackReference
    private Company company;	

    public BeneficialOwner()
    {
    }

	public BeneficialOwner(Integer id, String nameBO, Company company) {
		super();
		this.id = id;
		this.nameBO = nameBO;
		this.company = company;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameBO() {
		return nameBO;
	}

	public void setNameBO(String nameBO) {
		this.nameBO = nameBO;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}   

}