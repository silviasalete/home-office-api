package com.homeoffice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeoffice.api.model.Activity;

@Repository
public interface  ActivityRepository extends JpaRepository<Activity, Long>{

}
