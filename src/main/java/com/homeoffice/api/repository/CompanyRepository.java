package com.homeoffice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeoffice.api.model.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
