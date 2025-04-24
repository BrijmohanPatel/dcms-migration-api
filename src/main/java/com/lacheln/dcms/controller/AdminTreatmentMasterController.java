package com.lacheln.dcms.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lacheln.dcms.dto.ResponseBean;
import com.lacheln.dcms.service.AdminTreatmentMasterService;

@RestController
@RequestMapping("/treatmentMaster")
public class AdminTreatmentMasterController {
    
    @Autowired
    private AdminTreatmentMasterService adminTrtMasterService;

    @PostMapping("/save")
    public ResponseBean saveTreatmentMaster(@RequestBody ResponseBean responseBean) throws SQLException, Exception {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("AdminTreatmentMasterController.saveTreatmentMaster() ::  " + responseBean);
        responseBean = adminTrtMasterService.saveTreatmentMaster(responseBean);
        return responseBean;
    }

    @GetMapping("/get")
    public ResponseBean getTreatmentMaster() throws SQLException, Exception {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("AdminTreatmentMasterController.getTreatmentMaster()");
        ResponseBean responseBean = adminTrtMasterService.getTreatmentMaster();
        return responseBean;
    }

    @PostMapping("/update")
    public ResponseBean updateTreatmentMaster(@RequestBody ResponseBean responseBean) throws SQLException, Exception {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("AdminTreatmentMasterController.updateTreatmentMaster() ::  " + responseBean);
        responseBean = adminTrtMasterService.updateTreatmentMaster(responseBean);
        return responseBean;
    }

    @PostMapping("/delete")
    public ResponseBean deleteTreatmentMaster(@RequestBody ResponseBean responseBean) throws SQLException, Exception {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("AdminTreatmentMasterController.deleteTreatmentMaster() ::  " + responseBean);
        responseBean = adminTrtMasterService.deleteTreatmentMaster(responseBean);
        return responseBean;
    }
}
