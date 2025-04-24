package com.lacheln.dcms.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacheln.dcms.constants.CommonConstants;
import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.dto.TreatmentData;
import com.lacheln.dcms.entity.Plans;
import com.lacheln.dcms.entity.TreatmentPlans;
import com.lacheln.dcms.mapper.PlansMapper;
import com.lacheln.dcms.mapper.TreatmentPlanMapper;
import com.lacheln.dcms.repository.PlanUnitRepository;
import com.lacheln.dcms.repository.TreatmentPlanRepository;
import com.lacheln.dcms.service.TreatmentPlanService;


@Service
public class TreatmentPlanServiceImpl implements TreatmentPlanService {

	private static final Logger logger = LoggerFactory.getLogger(TreatmentPlanServiceImpl.class);
	
	private final TreatmentPlanRepository treatmentPlanRepository;
	
	@Autowired
	private PlanUnitRepository planUnitRepository;
	
	
	// This is constructor Dependency injection
	@Autowired
	public TreatmentPlanServiceImpl(TreatmentPlanRepository treatmentPlanRepository) {
		this.treatmentPlanRepository = treatmentPlanRepository; 
	}

	@Override
	public ResponseBean addTreatmentPlan(ResponseBean responseBean) throws SQLException, Exception {
		logger.info("TreatmentPlanServiceImpl.addTreatmentPlan() Invoked");
		System.out.println("Received Request is:"+ responseBean.getData().getTreatmentPlanDTO());
		try {
			
			TreatmentPlans treatmentPlans = TreatmentPlanMapper.toEntity(responseBean.getData().getTreatmentPlanDTO());
	        treatmentPlanRepository.save(treatmentPlans);
	        
	        List<Plans> planUnitList = PlansMapper.toEntityList(treatmentPlans.getTpId(), responseBean.getData().getTreatmentPlanDTO().getPlans());
	        
	        for(Plans plan : planUnitList) {
	        	planUnitRepository.save(plan);
	        }
			
	        responseBean.setMessage("Treatment Plan added successfully");
            responseBean.setStatus("success");
            responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
            logger.info("Treatment Plan added successfully");
			
		}catch(Exception e) {
			logger.error("Failed to save treatment plan", e);
		    responseBean.setMessage("Failed to save treatment plan");
		    responseBean.setStatus("Failure");
		    responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
		}
		
		return responseBean;
	}
	
	/*@Override
	public ResponseBean addTreatmentPlan(ResponseBean responsebean) throws SQLException, Exception {
		System.out.println("TreatmentPlanServiceImpl.addTreatmentPlan().");
		return treatmentPlanDao.addTreatmentPlan(responsebean);
	}
	
	@Override
	public ResponseBean updateTreatmentPlan(ResponseBean responsebean) throws SQLException, Exception {
		System.out.println("TreatmentPlanServiceImpl.updateTreatmentPlan().");
		return treatmentPlanDao.updateTreatmentPlan(responsebean);
	}
	
	@Override
	public ResponseBean deteleTreatmentPlan(ResponseBean responsebean) throws SQLException, Exception {
		System.out.println("TreatmentPlanServiceImpl.updateTreatmentPlan().");
		String tpuID = responsebean.getData().getPlandata().getTpu_id();
		return treatmentPlanDao.deleteTreatmentPlan(tpuID);
	}*/

}