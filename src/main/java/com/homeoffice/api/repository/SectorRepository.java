package com.homeoffice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeoffice.api.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long>{

}
