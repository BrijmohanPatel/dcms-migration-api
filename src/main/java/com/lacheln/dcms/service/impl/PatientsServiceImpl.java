package com.lacheln.dcms.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.lacheln.dcms.dto.PatientDTO;
import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.dto.ResponseData;
import com.lacheln.dcms.entity.Patients;
import com.lacheln.dcms.exception.DateValidationException;
import com.lacheln.dcms.repository.PatientsRepository;
import com.lacheln.dcms.service.PatientsService;
import com.lacheln.dcms.constants.CommonConstants;
import com.lacheln.dcms.utilities.DateUtil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class PatientsServiceImpl implements PatientsService{
	
    private static final Logger logger = LoggerFactory.getLogger(PatientsServiceImpl.class);

	private final PatientsRepository patientsRepository;

	@Autowired
	public PatientsServiceImpl(PatientsRepository patientsRepository) {
		this.patientsRepository = patientsRepository;
	}

	@Transactional
	public ResponseBean addPatient(ResponseBean responseBean){
		logger.info("PatientsServiceImpl.addPatient() Invoked");
		
		try {
            Patients patient = new Patients();
            String regDate = responseBean.getData().getPatientDTO().getPatientRegistrationDate();
            
            if (DateUtil.isValidRegistrationDate(regDate)) {
            	
                patient.setPatientRegistrationDate(DateUtil.parseRegDateToLocalDate(regDate));           
            }else {
            	logger.error("Failed to parse date: {}", regDate);
        	    responseBean.setMessage("Failed to parse date. Please provide a valid date format.");
        	    responseBean.setStatus("Failure");
        	    responseBean.setStatusCode(CommonConstants.STATUSCODE_400);
        	    return responseBean;
            }
            
            patient.setPatientName(responseBean.getData().getPatientDTO().getPatientName());
	        patient.setPatientMobileNumber(responseBean.getData().getPatientDTO().getPatientMobileNumber());
	        patient.setPatientAddress(responseBean.getData().getPatientDTO().getPatientAddress());
	        patient.setPatientGender(responseBean.getData().getPatientDTO().getPatientGender());
	        patient.setPatientAge(responseBean.getData().getPatientDTO().getPatientAge());        
	        patient.setPatientOccupation(responseBean.getData().getPatientDTO().getPatientOccupation());
	        patient.setPatientMedicalHistory(responseBean.getData().getPatientDTO().getPatientMedicalHistory());
	        patient.setPatientChiefComplaint(responseBean.getData().getPatientDTO().getPatientChiefComplaint());
	        patient.setPatientIntraOralExamination(responseBean.getData().getPatientDTO().getPatientIntraOralExamination());
	        
            Patients savedPatient = patientsRepository.save(patient);

            responseBean.setMessage("Patient added successfully");
            responseBean.setStatus("success");
            //responseBean.getData().set().setPatient_id(savedPatient.getPatientId());
            responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
            logger.info("Patient added successfully");
            
        } catch (DataIntegrityViolationException e) {
            handleDataIntegrityViolationException(e, responseBean);
            
        } catch (Exception e) {
            handleGenericException(e, responseBean);
        }

        return responseBean;
	}

	private void handleParseException(ParseException e, ResponseBean responseBean) {
	    logger.error("Failed to parse date", e);
	    responseBean.setMessage("Failed to parse date. Please provide a valid date format.");
	    responseBean.setStatus("Failure");
	    responseBean.setStatusCode(CommonConstants.STATUSCODE_400);
	}

	private void handleDataIntegrityViolationException(DataIntegrityViolationException e, ResponseBean responseBean) {
	    logger.error("Duplicate entry. Patient with the same ID or mobile number already exists.", e);
	    responseBean.setMessage("Duplicate entry. Patient with the same ID or mobile number already exists.");
	    responseBean.setStatus("Failure");
	    responseBean.setStatusCode(CommonConstants.STATUSCODE_409);
	}

	private void handleGenericException(Exception e, ResponseBean responseBean) {
	    logger.error("Failed to add patient", e);
	    responseBean.setMessage("Failed to add patient");
	    responseBean.setStatus("Failure");
	    responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
	}

	@Override
	public ResponseBean searchPatient(ResponseBean responseBean) throws SQLException, Exception {
		logger.info("PatientsServiceImpl.searchPatient():");
	
        List<Patients> patientsList = null;

        try {
        	String searchOption = responseBean.getData().getPatientDTO().getSearchByOption();
        	String searchOptionValue = responseBean.getData().getPatientDTO().getSearchByOptionValue();
        	
            if ("caseNo".equals(searchOption)) {
                patientsList = patientsRepository.findByPatientId(searchOptionValue);

            } else if ("patientName".equals(searchOption)) {
                patientsList = patientsRepository.findByPatientNameContaining(searchOptionValue);

            } else if ("mobileNumber".equals(searchOption)) {
                patientsList = patientsRepository.findByPatientMobileNumber(searchOptionValue);

            } else if ("Date".equals(searchOption)) {
            	
            	LocalDate startDate = null;
            	LocalDate endDate = null;
          
            	if(DateUtil.isValidRegistrationDate(responseBean.getData().getPatientDTO().getSearchByDate().getStartDate())) {
            		startDate = DateUtil.parseRegDateToLocalDate(responseBean.getData().getPatientDTO().getSearchByDate().getStartDate().toString());
            	}else {
            	    throw new DateValidationException("Input date is null or empty or Invalid start date format. Please use 'yyyy-MM-dd'.");
            	}
            	
            	if(DateUtil.isValidRegistrationDate(responseBean.getData().getPatientDTO().getSearchByDate().getEndDate())) {
            		endDate = DateUtil.parseRegDateToLocalDate(responseBean.getData().getPatientDTO().getSearchByDate().getEndDate().toString());
            	}else {
            	
                    throw new DateValidationException("Input date is null or empty or Invalid end date format. Please use 'yyyy-MM-dd'.");
            	}
            	patientsList = patientsRepository.findByPatientRegistrationDateBetween(startDate, endDate);
            }

            if (patientsList == null || patientsList.isEmpty()) {
                responseBean.setMessage("No Patient Found!!!");
            } else {
                responseBean.setMessage("Patient Found successfully");
            }

            responseBean.setStatus("success");
            responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
            responseBean.getData().setPatientsList(patientsList);

        } catch (DateValidationException e) {
            logger.error("Date validation error (Valid): " + e.getMessage());
            responseBean.setMessage("Failed to search patient!");
            responseBean.setStatus("Failure");
            responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
            
        } catch (Exception e) {
        	logger.error("Unknown Exception: " + e.getMessage());
            responseBean.setMessage("Failed to search patient!");
            responseBean.setStatus("Failure");
            responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
        }

        return responseBean;
	}

	
	
	
	@Override
	public ResponseBean selectPatient(ResponseBean responsebean) throws SQLException, Exception {
		System.out.println("PatientsServiceImpl.selectPatient().");
		
		String selectedCaseNo = responsebean.getData().getPatientDTO().getPatientId();
		
		/*selectPatient is dependent on TreatmentPlan. First Treatment plan needs to be added.*/
		
		return responsebean;
	}
	
	@Override
	public ResponseBean getAllPatients() {
	    logger.info("PatientsServiceImpl.getAllPatients().");
	    ResponseBean responseBean = new ResponseBean();
	    ResponseData responseData = new ResponseData();
	    List<Patients> patientsList;

	    try {
	        patientsList = patientsRepository.findAll();
	        
	        /*
	        patientsList.forEach(patient -> {
	            patient.setPatientRegistrationDate(DateUtil.convertPatientRegDateFormat(patient.getPatientRegistrationDate()));
	        });*/
	        
	       for(int i=0; i < patientsList.size(); i++) {
	    	   patientsList.get(i).setPatientRegistrationDate(DateUtil.parseRegDateToLocalDate(patientsList.get(i).getPatientRegistrationDate().toString()));
	       }

			 
	        responseBean.setMessage("Successfully fetched Patients!");
	        responseBean.setStatus(CommonConstants.SUCCESS);
	        responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
	        responseData.setPatientsList(patientsList);
	        responseBean.setData(responseData);

	    } catch (DataAccessException e) {
	        logger.error("Error while fetching patients data: {}", e.getMessage(), e);
	        responseBean.setMessage("Error while fetching patients data");
	        responseBean.setStatus(CommonConstants.ERROR);
	        responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
	        responseData.setPatientsList(patientsList = new ArrayList<>());
	        responseBean.setData(responseData);
	        
	    } catch (Exception e) {
	        logger.error("Unexpected error: {}", e.getMessage(), e);
	        responseBean.setMessage("Unexpected error");
	        responseBean.setStatus(CommonConstants.ERROR);
	        responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
	        responseData.setPatientsList(patientsList = new ArrayList<>());
	        responseBean.setData(responseData);
	    }

	    return responseBean;
	}

	
	@Transactional
	@Override
	public ResponseBean updatePatient(ResponseBean responseBean){
		logger.info("PatientsServiceImpl.updatePatient().");

		int updateStatus = 0;

		PatientDTO patientDTO = null;

		try {

			if (responseBean != null && responseBean.getData() != null && responseBean.getData().getPatientDTO() != null) {

				patientDTO = responseBean.getData().getPatientDTO();

				String patientId = patientDTO.getPatientId();
				String patientName = patientDTO.getPatientName();
				String gender = patientDTO.getPatientGender();
				String patientMobileNumber = patientDTO.getPatientMobileNumber();
				int patientAge = patientDTO.getPatientAge();
				String patientOccupation = patientDTO.getPatientOccupation();
				String patientAddress = patientDTO.getPatientAddress();
				String patientMedicalHistory = patientDTO.getPatientMedicalHistory();
				String patientChiefComplaint = patientDTO.getPatientChiefComplaint();
				String patientIntraOralExamination = patientDTO.getPatientIntraOralExamination();

				updateStatus = patientsRepository.updatePatientDetails(
						patientId, patientName, patientAge, gender, patientAddress, patientChiefComplaint, 
						patientIntraOralExamination, patientMedicalHistory, patientMobileNumber,   
						patientOccupation
						);
				
			} else {
				logger.error("Response or its components are null");
				patientDTO = new PatientDTO();
				responseBean.setMessage("Response or its contents are null");
				responseBean.setStatus(CommonConstants.ERROR);
				responseBean.setStatusCode(CommonConstants.STATUSCODE_400);
				return responseBean;
			}


			if(updateStatus > 0) {

				responseBean.setMessage("Successfully updated Patient details!");
				responseBean.setStatus(CommonConstants.SUCCESS);
				responseBean.setStatusCode(CommonConstants.STATUSCODE_200);

			} else {

				responseBean.setMessage("No Record found to update!");
				responseBean.setStatus(CommonConstants.FAILED);
				responseBean.setStatusCode(CommonConstants.STATUSCODE_400);
			}

			responseBean.getData().setPatientDTO(patientDTO);


		} catch (Exception exception) {
			logger.error("Unexpected exception: {}", exception.getMessage(), exception);
			responseBean.setMessage("Unexpected error. Failed to update the data.");
			responseBean.setStatus(CommonConstants.ERROR);
			responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
		}

		return responseBean;
	}

	
	/*To delete a patient that patient should not have any treatment or any treatmentplan active.
	If Active then return the message that "There are treatment plans associated with the ID"
	If Closed then Soft delete the user.*/
	@Override
	public ResponseBean deletePatient(ResponseBean responseBean) {
		System.out.println("PatientsServiceImpl.deletePatient().");
		Boolean deleteStatus = false;
		String deletePatientId = "";
		
		if(responseBean.getData() != null  && responseBean.getData().getPatientDTO() != null &&  responseBean.getData().getPatientDTO().getPatientId() != null) {
			deletePatientId = responseBean.getData().getPatientDTO().getPatientId();
		}
		
		
		if(deletePatientId != null && deletePatientId.length() > 0) {
			
			if(isPatientAllowedToDelete(deletePatientId)) {
				patientsRepository.deleteById(deletePatientId);
				
				if(patientsRepository.findByPatientId(deletePatientId) == null || 
					patientsRepository.findByPatientId(deletePatientId).isEmpty() || patientsRepository.findByPatientId(deletePatientId).size() == 0) {
					deleteStatus = true;
				}
			}else {
				responseBean.setMessage("Failed to delete patient! The patient is already associated with an active treatment plan.");
				responseBean.setStatus(CommonConstants.FAILED);
				responseBean.setStatusCode(CommonConstants.STATUSCODE_400);
			}
			
			
			
		}else {
			responseBean.setMessage("Failed to delete patient! The patient ID is null.");
			responseBean.setStatus(CommonConstants.FAILED);
			responseBean.setStatusCode(CommonConstants.STATUSCODE_400);

		}
		
		if(deleteStatus) {
			responseBean.setMessage("Successfully deleted Patient details!");
			responseBean.setStatus(CommonConstants.SUCCESS);
			responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
		}else {
			
		}
		
		return responseBean;
		
	}
	
	public boolean isPatientAllowedToDelete(String patientID) {
		
		boolean isPatientAllowedToDelete = false;
		
		//patientsRepository.findByPatientId(deletePatientId);	
		
				
		return isPatientAllowedToDelete;
	}

}
