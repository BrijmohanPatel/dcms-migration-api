package com.lacheln.dcms.service;

import java.sql.SQLException;

import com.lacheln.dcms.dto.ResponseBean;

public interface PatientsService {
	
	ResponseBean addPatient(ResponseBean responsebean) throws SQLException, Exception;
	
	ResponseBean searchPatient(ResponseBean responsebean) throws SQLException, Exception;
	
	ResponseBean selectPatient(ResponseBean responsebean) throws SQLException, Exception;

	ResponseBean getAllPatients();

	ResponseBean updatePatient(ResponseBean responsebean) throws SQLException, Exception;

	ResponseBean deletePatient(ResponseBean responsebean);

}
