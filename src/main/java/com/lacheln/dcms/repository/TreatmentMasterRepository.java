package com.lacheln.dcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.entity.TreatmentMaster;

@Repository
public interface TreatmentMasterRepository extends JpaRepository<TreatmentMaster, String> {
    
}
