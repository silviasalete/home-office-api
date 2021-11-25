package com.homeoffice.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private boolean isDefault;
    @ManyToMany
    @JoinTable(
    		name="companies_sectors",
    		uniqueConstraints = @UniqueConstraint(columnNames = {"company_id", "sectors_id"}),
    		joinColumns = @JoinColumn(name = "sectors_id"),
    		inverseJoinColumns = @JoinColumn(name = "company_id")
    )
	public List<Company> companies;

	public Sector() {
		super();
	}
	
	public Sector(String name, boolean isDefault) {
		this.name = name;
		this.isDefault = isDefault;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", name=" + name + ", isDefault=" + isDefault + ", companies=" + companies + "]";
	}
	
}
