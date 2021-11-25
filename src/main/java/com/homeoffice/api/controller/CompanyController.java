package com.homeoffice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.api.model.Company;
import com.homeoffice.api.service.CompanyService;
import com.homeoffice.api.web.form.CompanyForm;
import com.homeoffice.api.web.form.CompanyFormAssociate;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@PostMapping("/save")
	public Company save(@RequestBody CompanyForm companyForm) {
		return companyService.save(companyForm);
	}

	@PostMapping("/associate")
	public Company associateSectors(@RequestBody CompanyFormAssociate companyFormAssociate) {
		System.out.println("2********************************");
		System.out.println(companyFormAssociate.toString());
		System.out.println("2********************************");
		return companyService.associateSectors(companyFormAssociate);
	}
}
