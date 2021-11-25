package com.homeoffice.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeoffice.api.model.Sector;
import com.homeoffice.api.repository.SectorRepository;
import com.homeoffice.api.service.SectorService;
import com.homeoffice.api.web.form.SectorForm;

@Service
public class SectorServiceImpl implements SectorService {
	
	@Autowired
	private SectorRepository sectorRepository;

	@Override
	public List<Sector> findAll() {
		return sectorRepository.findAll();
	}

	@Override
	public Sector save(SectorForm sectorForm) {
		return sectorRepository.save(sectorForm.toEntity());
	}

	@Override
	public Sector findById(Long id) {
		return sectorRepository.findById(id).get();
	}

}
