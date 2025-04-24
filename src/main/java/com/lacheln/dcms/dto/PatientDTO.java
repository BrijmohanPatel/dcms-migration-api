package com.lacheln.dcms.dto;

public class PatientDTO {

	private String patientId;
	private String patientName;
	private String patientGender;
	private String patientMobileNumber;
	private int patientAge;
	private String patientOccupation;
	private String patientAddress;
	private String patientMedicalHistory;
	private String patientChiefComplaint;
	private String patientRegistrationDate;
	private String patientIntraOralExamination;
	
	//Search operation parameters
	private String searchByOption;
    private String searchByOptionValue;
    private DateRangeDTO searchByDate;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}
	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientOccupation() {
		return patientOccupation;
	}
	public void setPatientOccupation(String patientOccupation) {
		this.patientOccupation = patientOccupation;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientMedicalHistory() {
		return patientMedicalHistory;
	}
	public void setPatientMedicalHistory(String patientMedicalHistory) {
		this.patientMedicalHistory = patientMedicalHistory;
	}
	public String getPatientChiefComplaint() {
		return patientChiefComplaint;
	}
	public void setPatientChiefComplaint(String patientChiefComplaint) {
		this.patientChiefComplaint = patientChiefComplaint;
	}
	public String getPatientRegistrationDate() {
		return patientRegistrationDate;
	}
	public void setPatientRegistrationDate(String patientRegistrationDate) {
		this.patientRegistrationDate = patientRegistrationDate;
	}
	public String getPatientIntraOralExamination() {
		return patientIntraOralExamination;
	}
	public void setPatientIntraOralExamination(String patientIntraOralExamination) {
		this.patientIntraOralExamination = patientIntraOralExamination;
	}
	public String getSearchByOption() {
		return searchByOption;
	}
	public void setSearchByOption(String searchByOption) {
		this.searchByOption = searchByOption;
	}
	public String getSearchByOptionValue() {
		return searchByOptionValue;
	}
	public void setSearchByOptionValue(String searchByOptionValue) {
		this.searchByOptionValue = searchByOptionValue;
	}
	public DateRangeDTO getSearchByDate() {
		return searchByDate;
	}
	public void setSearchByDate(DateRangeDTO searchByDate) {
		this.searchByDate = searchByDate;
	}
	
	@Override
	public String toString() {
		return "PatientDTO [patientId=" + patientId + ", patientName=" + patientName + ", patientGender="
				+ patientGender + ", patientMobileNumber=" + patientMobileNumber + ", patientAge=" + patientAge
				+ ", patientOccupation=" + patientOccupation + ", patientAddress=" + patientAddress
				+ ", patientMedicalHistory=" + patientMedicalHistory + ", patientChiefComplaint="
				+ patientChiefComplaint + ", patientRegistrationDate=" + patientRegistrationDate
				+ ", patientIntraOralExamination=" + patientIntraOralExamination + ", searchByOption=" + searchByOption
				+ ", searchByOptionValue=" + searchByOptionValue + ", searchByDate=" + searchByDate + "]";
	}
    
	
}
