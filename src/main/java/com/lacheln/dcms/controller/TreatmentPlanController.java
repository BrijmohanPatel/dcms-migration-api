package com.lacheln.dcms.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacheln.dcms.dto.DateRangeDTO;
import com.lacheln.dcms.dto.PatientDTO;
import com.lacheln.dcms.dto.PlansDTO;
import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.dto.ResponseData;
import com.lacheln.dcms.dto.TreatmentPlanDTO;
import com.lacheln.dcms.service.TreatmentPlanService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/DCMS/api/treatmentPlans")
public class TreatmentPlanController {
	
	private static final Logger logger = LoggerFactory.getLogger(TreatmentPlanController.class);
	
	@Autowired
	TreatmentPlanService treatmentPlanService;
	
	@GetMapping("/test")
	public @ResponseBody ResponseBean test() throws Exception {
		logger.info("TreatmentPlanController.test()");

		PlansDTO plansDTO = new PlansDTO();
		List<PlansDTO> plansList = new ArrayList<PlansDTO>();
		plansList.add(plansDTO);
		
		TreatmentPlanDTO treatmentPlanDTO = new TreatmentPlanDTO();
		treatmentPlanDTO.setPlans(plansList);
		
		ResponseData responseBean = new ResponseData();
		responseBean.setTreatmentPlanDTO(treatmentPlanDTO);
		ResponseBean  respBean = new ResponseBean();
		respBean.setData(responseBean);
		return respBean;
	}
	
	@PostMapping("/addTreatmentPlan")
	public @ResponseBody ResponseBean addTreatmentPlan(@RequestBody ResponseBean responseBean) throws Exception {
		logger.info("TreatmentPlanController.addTreatmentPlan() ::  " + responseBean.toString());
		return treatmentPlanService.addTreatmentPlan(responseBean);
	}

}
