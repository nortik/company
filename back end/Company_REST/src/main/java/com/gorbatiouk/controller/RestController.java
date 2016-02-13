package com.gorbatiouk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gorbatiouk.model.Company;
import com.gorbatiouk.service.CompanyService;


@Controller
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/company")
public class RestController {
	
	@Autowired
	private CompanyService companyService;

	//all
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllCompanies() {						
		System.out.println("GET ALL");
		return companyService.findAll();
	}

	//get
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Company getCompany(@PathVariable String id) {
		System.out.println("GET");
		return companyService.findById(Integer.parseInt(id));
	}
	
	//delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeCompany(@PathVariable String id) {
		System.out.println("DELETE");
		companyService.delete(Integer.parseInt(id));
	}

	//Add a new Company
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addCompany(@RequestBody String body){
		System.out.println("POST");
		companyService.add(body);
	}
	
	//Update a new Company
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@PathVariable String id,@RequestBody String body) {
		System.out.println("PUT");
		companyService.update(body);
	}
	
	
}
