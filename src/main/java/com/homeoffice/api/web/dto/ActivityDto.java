package com.homeoffice.api.web.dto;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.homeoffice.api.model.Activity;

public class ActivityDto {

	private Long id;
    private String title;
    private String description;
	
	public ActivityDto() {
		super();
	}

	public ActivityDto(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public static ActivityDto toDto(Activity activity) {
		
		return new ActivityDto(activity.getId(), activity.getTitle(), activity.getDescription());
	}

	public static Page<ActivityDto> toDtoList(Page<Activity> listActivity) {
		
		List<ActivityDto> listActivityDto = new ArrayList<ActivityDto>();
		
		for (Activity activity : listActivity) {
			listActivityDto.add(new ActivityDto(activity.getId(), activity.getTitle(), activity.getDescription()));
		}
		
		return new PageImpl<ActivityDto>(listActivityDto, listActivity.getPageable(), listActivity.getTotalElements());
	}
    
}
