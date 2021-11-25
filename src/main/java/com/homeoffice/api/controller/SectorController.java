package com.homeoffice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.api.model.Sector;
import com.homeoffice.api.service.SectorService;
import com.homeoffice.api.web.dto.ActivityDto;
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

	@GetMapping("/{id}")
	public Sector findById(@PathVariable Long id) {
		return sectorService.findById(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Sector> save(@RequestBody SectorForm sectorForm) {
		return ResponseEntity.ok(sectorService.save(sectorForm));
	}
}
