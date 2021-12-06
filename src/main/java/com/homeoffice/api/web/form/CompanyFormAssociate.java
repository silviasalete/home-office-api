package com.homeoffice.api.web.form;

import java.util.List;

import com.homeoffice.api.model.Company;
import com.homeoffice.api.model.Sector;

public class CompanyFormAssociate {

	public Company company;
	public List<Sector> sectors;
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	@Override
	public String toString() {
		return "CompanyFormAssociate [company=" + company;
	}

}
