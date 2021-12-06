package com.homeoffice.api.web.form;

import java.util.List;

import com.homeoffice.api.model.Company;
import com.homeoffice.api.model.Sector;
import com.homeoffice.api.model.User;

public class CompanyForm {
	
	public String name;
	public List<Sector> sectors;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Company toEntity() {
		return new Company(this.name, this.sectors);
	}
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
}
