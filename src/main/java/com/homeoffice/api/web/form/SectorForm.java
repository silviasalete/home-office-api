package com.homeoffice.api.web.form;

import com.homeoffice.api.model.Sector;

public class SectorForm {

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sector toEntity() {
		return new Sector(getName(),false);
	}
	@Override
	public String toString() {
		return "SectorForm [name=" + name + "]";
	}
	
}
