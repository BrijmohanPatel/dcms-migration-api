package com.lacheln.dcms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacheln.dcms.entity.TreatmentPlans;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlans, String>{
	
	
	List<TreatmentPlans> findByCaseNo(String caseNo);

    List<TreatmentPlans> findByStatus(String status);

    List<TreatmentPlans> findByRegDateBetween(String startDate, String endDate);

}
