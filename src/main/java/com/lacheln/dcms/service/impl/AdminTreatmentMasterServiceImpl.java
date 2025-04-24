package com.lacheln.dcms.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacheln.dcms.constants.CommonConstants;
import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.dto.TreatmentMasterDTO;
import com.lacheln.dcms.entity.TreatmentMaster;
import com.lacheln.dcms.repository.TreatmentMasterRepository; // Assuming you have a repository for DB operations
import com.lacheln.dcms.service.AdminTreatmentMasterService;

@Service
public class AdminTreatmentMasterServiceImpl implements AdminTreatmentMasterService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminTreatmentMasterServiceImpl.class);

    @Autowired
    private TreatmentMasterRepository treatmentMasterRepository; // Assuming a repository for database interactions

    @Override
    public ResponseBean saveTreatmentMaster(ResponseBean responseBean) throws SQLException, Exception {
        // Convert ResponseBean to TreatmentMaster entity
    	try {
    		TreatmentMaster treatmentMaster = new TreatmentMaster();
        	treatmentMaster.setTreatmentName(responseBean.getData().getTreatmentMasterData().getTreatmentName());
        	treatmentMaster.setTreatmentAddedDate(Timestamp.from(Instant.now()));
        	treatmentMaster = treatmentMasterRepository.save(treatmentMaster);
        	
        	responseBean.setMessage("Treatment Master added successfully");
            responseBean.setStatus("success");
            responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
            logger.info("Treatment Master added successfully");
            
        	
    	}catch(Exception e) {
    		logger.error("Failed to save treatment Master Data: {}", e);
		    responseBean.setMessage("Failed to save treatment Master");
		    responseBean.setStatus("Failure");
		    responseBean.setStatusCode(CommonConstants.STATUSCODE_500);
    	}
        
        
        return responseBean;
    }

    @Override
    public ResponseBean getTreatmentMaster() throws SQLException, Exception {
        // Implement your logic to get treatment master here
        System.out.println("Getting treatment master");
        
        ResponseBean responseBean  = new ResponseBean();
        List<TreatmentMaster> treatmentMasterEntityList= treatmentMasterRepository.findAll();
        
        List<TreatmentMasterDTO> treatmentMasterDTOList = convertToDTO(treatmentMasterEntityList);
        
        responseBean.setMessage("Treatment Master Fetched successfully");
        responseBean.setStatus("success");
        responseBean.setStatusCode(CommonConstants.STATUSCODE_200);
        responseBean.getData().setTreatmentMasterList(treatmentMasterDTOList);
        logger.info("Treatment Master fetched successfully");
        return responseBean;
    }

    @Override
    public ResponseBean updateTreatmentMaster(ResponseBean responseBean) throws SQLException, Exception {
        // Implement your logic to update treatment master here
        System.out.println("Updating treatment master: " + responseBean);
        //treatmentMasterRepository.update(responseBean); // Example method
        return responseBean;
    }

    @Override
    public ResponseBean deleteTreatmentMaster(ResponseBean responseBean) throws SQLException, Exception {
        System.out.println("Deleting treatment master: " + responseBean);
        //treatmentMasterRepository.delete(responseBean); // Example method
        return responseBean;
    }
    
 // Helper methods to convert between ResponseBean and TreatmentMaster
    private TreatmentMaster convertToEntity(ResponseBean responseBean) {
        TreatmentMaster treatmentMaster = new TreatmentMaster();
        
        treatmentMaster.setTreatmentName(responseBean.getData().getTreatmentMasterData().getTreatmentName());
        treatmentMaster.setTreatmentAddedDate(Timestamp.from(Instant.now()));
        return treatmentMaster;
    }
    
    private List<TreatmentMasterDTO> convertToDTO(List<TreatmentMaster> treatmentMasterEntityList){
    	
    	List<TreatmentMasterDTO> treatmentMasterDTO = new ArrayList<TreatmentMasterDTO>();
        for(TreatmentMaster treatments: treatmentMasterEntityList) {
        	TreatmentMasterDTO trtMstDTO = new TreatmentMasterDTO();
        	trtMstDTO.setTmID(treatments.getTmId());
        	trtMstDTO.setTreatmentName(treatments.getTreatmentName());
        }
    	
    	return treatmentMasterDTO;
    }
    
}
