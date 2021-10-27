package com.homeoffice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.api.model.Sector;
import com.homeoffice.api.service.SectorService;
import com.homeoffice.api.web.form.SectorForm;

@RestController
@RequestMapping("/sector")
@CrossOrigin(origins = "*")
public class SectorController {
	
	@Autowired
	private SectorService sectorService;

	@GetMapping
	public List<Sector> all() {
		return sectorService.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Sector> save(@RequestBody SectorForm sectorForm) {
		return ResponseEntity.ok(sectorService.save(sectorForm));
	}
}
