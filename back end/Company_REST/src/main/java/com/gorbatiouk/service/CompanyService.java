package com.gorbatiouk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.gorbatiouk.model.BeneficialOwner;
import com.gorbatiouk.model.Company;
import com.gorbatiouk.model.CompanyEmployee;
import com.gorbatiouk.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Transactional(readOnly = true)
	public List<Company> findAll() {
		return companyRepository.findAll();
	}
	
	
	public Company findById(int companyId) {
		return companyRepository.findById(companyId);
	}
	
	@Transactional
	public Company save(Company company) {
		if (company.getId() == null) {
			System.out.println("creating");
			return companyRepository.create(company);
		} else {
			System.out.println("updating");
			return companyRepository.update(company);
		}
	}
	
	@Transactional
	public void update(String data) {
		Gson gson = new Gson();
		//BeneficialOwner tempBO = gson.fromJson(data, BeneficialOwner.class);
		Company tempCompany = gson.fromJson(data, Company.class);
		
		for(CompanyEmployee companyEmployee : tempCompany.getEmployee())  {
			   companyEmployee.setCompany(tempCompany);
		}
		
		for(BeneficialOwner beneficialOwner : tempCompany.getBeneficialOwner())  {
			beneficialOwner.setCompany(tempCompany);
			beneficialOwner.setId(null);
		}
		
		save(tempCompany);
	}
	
	@Transactional
	public void add(String data) {
		Gson gson = new Gson();
				
		//List<CompanyEmployee> tempListEmployee = gson.fromJson(data, CompanyEmployee.class);
		Company tempCompany = gson.fromJson(data, Company.class);
		
		for(CompanyEmployee companyEmployee : tempCompany.getEmployee())  {
			   companyEmployee.setCompany(tempCompany);
			   companyEmployee.setId(null);
		}		
		
		tempCompany.setId(null);
		
		save(tempCompany);
	}	
	
	@Transactional
	public void delete(Integer id) {
		companyRepository.delete(id);
	}
	
}

	