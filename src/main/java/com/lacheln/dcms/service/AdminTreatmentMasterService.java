package com.lacheln.dcms.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.lacheln.dcms.dto.ResponseBean;

@Service
public interface AdminTreatmentMasterService {

    ResponseBean saveTreatmentMaster(ResponseBean responseBean) throws SQLException, Exception;

    ResponseBean getTreatmentMaster() throws SQLException, Exception;

    ResponseBean updateTreatmentMaster(ResponseBean responseBean) throws SQLException, Exception;

    ResponseBean deleteTreatmentMaster(ResponseBean responseBean) throws SQLException, Exception;
}
