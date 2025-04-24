package com.lacheln.dcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lacheln.dcms.entity.Patients;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PatientsRepository extends JpaRepository<Patients, String>{

	List<Patients> findByPatientId(String patientId);

	List<Patients> findByPatientNameContaining(String patientName);

	List<Patients> findByPatientMobileNumber(String patientMobileNumber);

	List<Patients> findByPatientRegistrationDateBetween(LocalDate start, LocalDate end);

	//The @Modifying annotation informs Spring Data JPA that this method is intended to modify the database.
	//Without @Modifying, Spring Data JPA assumes that the query is a read-only query, and using it for modifying operations may result in an exception or unexpected behavior.
	
	@Modifying
	@Query("UPDATE Patients p SET p.patientName = :name, p.patientAge = :age, p.patientGender = :gender, "
			+ "p.patientAddress  = :address, p.patientChiefComplaint = :chiefComplaint, "
			+ "p.patientIntraOralExamination = :oralExam, p.patientMedicalHistory = :medicalHistory, "
			+ "p.patientMobileNumber = :mobileNumber, p.patientOccupation = :occupation "
			+ "WHERE p.patientId = :id")
	int updatePatientDetails(@Param("id") String id, @Param("name") String name, @Param("age") int age, 
			@Param("gender") String gender, @Param("address") String address, 
			@Param("chiefComplaint") String chiefComplaint, @Param("oralExam") String oralExam, 
			@Param("medicalHistory") String medicalHistory, @Param("mobileNumber") String mobileNumber, 
			@Param("occupation") String occupation);

}
