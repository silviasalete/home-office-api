package com.homeoffice.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeoffice.api.model.Company;
import com.homeoffice.api.model.Sector;
import com.homeoffice.api.model.User;
import com.homeoffice.api.repository.CompanyRepository;
import com.homeoffice.api.repository.SectorRepository;
import com.homeoffice.api.repository.UserRepository;
import com.homeoffice.api.service.CompanyService;
import com.homeoffice.api.web.form.CompanyForm;
import com.homeoffice.api.web.form.CompanyFormAssociate;
@Service
public class CompanyImpl implements CompanyService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SectorRepository sectorRepository;
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company save(CompanyForm companyForm) {	
		return companyRepository.save(companyForm.toEntity());
	}

	@Override
	public Company associateSectors(CompanyFormAssociate companyFormAssociate) {
		System.out.println("********************************");
		System.out.println(companyFormAssociate.toString());
		System.out.println("********************************");
		return companyRepository.save(companyFormAssociate.company);
	}

}
