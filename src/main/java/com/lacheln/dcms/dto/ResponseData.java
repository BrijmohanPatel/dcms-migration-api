package com.lacheln.dcms.dto;

import java.util.List;

import com.lacheln.dcms.entity.Patients;

public class ResponseData {

    private PatientDTO patientDTO;

    private List<Patients> patientsList;
    
    private TreatmentPlanDTO treatmentPlanDTO;
    
    private List<TreatmentPlanDTO> treatmentPlanList;
     
    
    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public List<Patients> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patients> patientsList) {
        this.patientsList = patientsList;
    }
       

	public TreatmentPlanDTO getTreatmentPlanDTO() {
		return treatmentPlanDTO;
	}

	public void setTreatmentPlanDTO(TreatmentPlanDTO treatmentPlanDTO) {
		this.treatmentPlanDTO = treatmentPlanDTO;
	}

	public List<TreatmentPlanDTO> getTreatmentPlanList() {
		return treatmentPlanList;
	}

	public void setTreatmentPlanList(List<TreatmentPlanDTO> treatmentPlanList) {
		this.treatmentPlanList = treatmentPlanList;
	}
	
	
	TreatmentMasterDTO treatmentMasterData = new TreatmentMasterDTO();
	
	public TreatmentMasterDTO getTreatmentMasterData() {
		return treatmentMasterData;
	}

	public void setTreatmentMasterData(TreatmentMasterDTO treatmentMasterData) {
		this.treatmentMasterData = treatmentMasterData;
	}
	
	List<TreatmentMasterDTO> treatmentMasterList;

	public List<TreatmentMasterDTO> getTreatmentMasterList() {
		return treatmentMasterList;
	}
	public void setTreatmentMasterList(List<TreatmentMasterDTO> treatmentMasterList) {
		this.treatmentMasterList = treatmentMasterList;
	}
	

	@Override
	public String toString() {
		return "ResponseData [patientDTO=" + patientDTO + ", patientsList=" + patientsList + ", treatmentPlanDTO="
				+ treatmentPlanDTO + ", treatmentPlanList=" + treatmentPlanList + "]";
	}
   
}