package com.homeoffice.api.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	public String name;
    @ManyToMany(mappedBy = "companies")
    @JoinTable(
    		name="companies_sectors",
    		uniqueConstraints = @UniqueConstraint(columnNames = {"company_id", "sectors_id"}),
    		joinColumns = @JoinColumn(name = "company_id"),
    		inverseJoinColumns = @JoinColumn(name = "sectors_id")
    )
	public List<Sector> sectors;
    
	public Company() {
		super();
	} 

	public Company(String name) {
		super();
		this.name = name;
	}

	public Company(Long id, String name, List<Sector> sectors) {
		super();
		this.id = id;
		this.name = name;
		this.sectors = sectors;
	}

	public Company(String name, List<Sector> sectors) {
		super();
		this.name = name;
		this.sectors = sectors;
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

	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	
}
