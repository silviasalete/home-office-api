package com.homeoffice.api.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.homeoffice.api.model.Activity;
import com.homeoffice.api.model.User;
import com.homeoffice.api.repository.ActivityRepository;
import com.homeoffice.api.service.ActivityService;
import com.homeoffice.api.web.dto.ActivityDto;
import com.homeoffice.api.web.form.ActivityForm;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	ActivityRepository activityRepository;
	
	@Override
	public Page<ActivityDto> findAll(Pageable pagination) {
		
		 Page<Activity>       activityList = activityRepository.findAll(pagination);
		 
		return ActivityDto.toDtoList(activityList);
	}

	@Override
	public ActivityDto findById(Long id) {
		
		return ActivityDto.toDto(activityRepository.findById(id).get());
	}

	@Override
	public Activity save(ActivityForm activityForm, User user) {
		Activity activity = activityForm.toEntity();
		activity.setCreatedBy(user);
		activity.setCreatedIn(new Date());
		activity.setUpdatedBy(user);
		activity.setUpdatedIn(new Date());
		activityRepository.save(activity);
		return activity;
	}

	@Override
	public ActivityDto update(ActivityForm activityForm) {
		
		Activity activity = activityRepository.findById(activityForm.getId()).get();
		activity.setTitle(activityForm.getTitle());
		activity.setDescription(activityForm.getDescription());
		
		return ActivityDto.toDto(activity);
	}

	@Override
	public void delete(Long id) {
		activityRepository.deleteById(id);
	}
}
