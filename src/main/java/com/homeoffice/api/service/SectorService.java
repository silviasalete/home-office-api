package com.homeoffice.api.service;

import java.util.List;

import com.homeoffice.api.model.Sector;
import com.homeoffice.api.web.form.SectorForm;

public interface SectorService{

	List<Sector> findAll();
	Sector save(SectorForm sectorForm);

}
