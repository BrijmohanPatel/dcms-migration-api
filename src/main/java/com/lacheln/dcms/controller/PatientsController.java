package com.lacheln.dcms.controller;

import java.sql.SQLException;

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
import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.dto.ResponseData;
import com.lacheln.dcms.service.PatientsService;
import com.lacheln.dcms.service.impl.PatientsServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/DCMS/api/patients")
public class PatientsController {

	private static final Logger logger = LoggerFactory.getLogger(PatientsController.class);

	@Autowired
	PatientsService patientsService;

	/*@Value("${dateFormat}")
	String dateFormat;*/

	@GetMapping("/test")
	public  ResponseBean test() throws Exception {
		logger.info("PatientsController.test()");

		DateRangeDTO searchDate = new DateRangeDTO();
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setSearchByDate(searchDate);
		ResponseData respData = new ResponseData();
		respData.setPatientDTO(patientDTO);
		ResponseBean  respBean = new ResponseBean();
		respBean.setData(respData);
		return respBean;
	}

	@PostMapping("/addPatient")
	public  ResponseBean addPatient(@RequestBody ResponseBean responsebean) throws Exception {
		logger.info("PatientsController.addPatient() ::  " + responsebean.toString());
		return patientsService.addPatient(responsebean);
	}

	@PostMapping("/searchPatient")
	public  ResponseBean searchPatient(@RequestBody ResponseBean responsebean) throws Exception {
		logger.info("PatientsController.searchPatient() ::  " + responsebean);
		return patientsService.searchPatient(responsebean);
	}


	/*@PostMapping(value = "/selectPatient")
	public  ResponseBean selectPatient(@RequestBody ResponseBean responsebean) throws Exception {
		logger.info("PatientsController.selectPatient() ::  " + responsebean);
		return patientsService.selectPatient(responsebean);

	}*/

	@GetMapping(value = "getAllPatients")
	public  ResponseBean getAllPatients() throws Exception {
		logger.info("PatientsController.getAllPatients()");
			return patientsService.getAllPatients();
	}

		
	@PostMapping(value = "/updatePatient")
	public  ResponseBean updatePatient(@RequestBody ResponseBean responsebean) throws Exception {
		System.out.println("PatientsController.updatePatient()::"+ responsebean);
		return patientsService.updatePatient(responsebean);
	}
	
	@PostMapping(value="/deletePatient")
	public  ResponseBean deletePatient(@RequestBody ResponseBean responsebean) throws SQLException, Exception {
		System.out.println("PatientsController.deletePatient() :: ");
		return patientsService.deletePatient(responsebean);
	}
}
