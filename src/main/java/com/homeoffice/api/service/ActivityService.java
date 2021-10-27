package com.homeoffice.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.homeoffice.api.model.Activity;
import com.homeoffice.api.model.User;
import com.homeoffice.api.web.dto.ActivityDto;
import com.homeoffice.api.web.form.ActivityForm;

public interface  ActivityService {

	Page<Activity> findAll(Pageable pagination);
	ActivityDto findById(Long id);
	Activity save(ActivityForm activityForm, User user);
	ActivityDto update(Activity activity);
	void delete(Long id);
}
