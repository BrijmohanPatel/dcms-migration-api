package com.lacheln.dcms.service;

import java.sql.SQLException;
import com.lacheln.dcms.dto.ResponseBean;

public interface TreatmentPlanService {
	
	ResponseBean addTreatmentPlan(ResponseBean responsebean) throws SQLException, Exception;
	
	//ResponseBean updateTreatmentPlan(ResponseBean responsebean) throws SQLException, Exception;
	
	//ResponseBean deteleTreatmentPlan(ResponseBean responsebean) throws SQLException, Exception;
}
