package com.lacheln.dcms.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "patients")
public class Patients implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
	@GenericGenerator(name = "patient_seq", strategy = "com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator",
		parameters = { 
				@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
				@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "UNQ"),
				@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
		})
	@Column(name = "PATIENT_ID")
	private String patientId;

	@Column(name = "PATIENT_NAME")
	private String patientName;

	@Column(name = "GENDER")
	private String patientGender;

	@Column(name = "MOBILE_NUMBER")
	private String patientMobileNumber;

	@Column(name = "AGE")
	private Integer patientAge;

	@Column(name = "OCCUPATION")
	private String patientOccupation;

	@Column(name = "ADDRESS")
	private String patientAddress;

	@Column(name = "MEDICAL_HISTORY")
	private String patientMedicalHistory;

	@Column(name = "CHIEF_COMPLAINT")
	private String patientChiefComplaint;

	@Column(name = "INTRA_ORAL_EXAMINATION")
	private String patientIntraOralExamination;

	@Column(name = "REG_DATE")
	private LocalDate patientRegistrationDate;

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

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
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

	public String getPatientIntraOralExamination() {
		return patientIntraOralExamination;
	}

	public void setPatientIntraOralExamination(String patientIntraOralExamination) {
		this.patientIntraOralExamination = patientIntraOralExamination;
	}
	
	public LocalDate getPatientRegistrationDate() {
		return patientRegistrationDate;
	}

	public void setPatientRegistrationDate(LocalDate patientRegistrationDate) {
		this.patientRegistrationDate = patientRegistrationDate;
	}

	@Override
	public String toString() {
		return "Patients [patientId=" + patientId + ", patientName=" + patientName + ", patientGender=" + patientGender
				+ ", patientMobileNumber=" + patientMobileNumber + ", patientAge=" + patientAge + ", patientOccupation="
				+ patientOccupation + ", patientAddress=" + patientAddress + ", patientMedicalHistory="
				+ patientMedicalHistory + ", patientChiefComplaint=" + patientChiefComplaint
				+ ", patientIntraOralExamination=" + patientIntraOralExamination + ", patientRegistrationDate="
				+ patientRegistrationDate + "]";
	}

}
