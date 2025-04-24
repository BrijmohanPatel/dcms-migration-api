package com.lacheln.dcms.dto;

public class TreatmentMasterDTO {
	
	private String tmID;
	private String treatmentName;
	
	
	public String getTmID() {
		return tmID;
	}



	public void setTmID(String tmID) {
		this.tmID = tmID;
	}


	public String getTreatmentName() {
		return treatmentName;
	}


	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}




	@Override
	public String toString() {
		return "TreatmentMasterDTO [tmID=" + tmID + ", treatmentName=" + treatmentName + "]";
	}
	
}
