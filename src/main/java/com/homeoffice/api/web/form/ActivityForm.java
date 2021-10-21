package com.homeoffice.api.web.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.homeoffice.api.model.Activity;
import com.sun.istack.NotNull;

public class ActivityForm {

	@NotNull @NotEmpty @Length(min = 5)
    private String title;
	@NotNull @NotEmpty @Length(min = 5)
    private String description;
	private Long id;
    
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

	public Activity toEntity() {
		return new Activity(getTitle(),getDescription());
	}

	@Override
	public String toString() {
		return "ActivityForm [title=" + title + ", description=" + description + "]";
	}

}
