package com.homeoffice.api.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.homeoffice.api.model.Activity;
import com.homeoffice.api.model.User;
import com.homeoffice.api.service.ActivityService;
import com.homeoffice.api.service.UserService;
import com.homeoffice.api.web.dto.ActivityDto;
import com.homeoffice.api.web.form.ActivityForm;

@RestController
@RequestMapping("/activity")
@CrossOrigin(origins = "*")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;

	@GetMapping
	@Cacheable(value = "ListActivity")
	public Page<Activity> findAll(Pageable pagination) {		
//		http://localhost:8080/activity?page=0&size=3&sort=id,desc&sort=title,asc
		return activityService.findAll(pagination);
	}

	@GetMapping("/{id}")
	public ActivityDto findById(@PathVariable Long id) {
		return activityService.findById(id);
	}
	
	@PostMapping("/save")
	@Transactional
	@CacheEvict(value = "ListActivity", allEntries = true)
	public ResponseEntity<ActivityDto> save(@RequestBody @Valid ActivityForm activityForm,  UriComponentsBuilder uriBuilder) {
		System.out.println("activityForm: "+activityForm.toString());
		User user = new User();
		user.setId(Long.valueOf(2)); //Mock remover
		Activity activity = activityService.save(activityForm, userService.findById(user.getId()));
		
		URI uri = uriBuilder.path("/activity/{id}").buildAndExpand(activity.getId()).toUri();
		return ResponseEntity.created(uri).body(ActivityDto.toDto(activity));
	}
	
	@PutMapping("/update")
	@Transactional
	@CacheEvict(value = "ListActivity", allEntries = true)
	public ResponseEntity<ActivityDto> update(@RequestBody @Valid Activity activity) {
		return ResponseEntity.ok(activityService.update(activity)) ;
	}
	 
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "ListActivity", allEntries = true)
	public ResponseEntity<?> delet(@PathVariable Long id) {
		activityService.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}
