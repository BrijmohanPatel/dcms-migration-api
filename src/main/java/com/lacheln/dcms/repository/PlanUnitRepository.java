package com.lacheln.dcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacheln.dcms.entity.Plans;

public interface PlanUnitRepository extends JpaRepository<Plans, String> {
	
}
