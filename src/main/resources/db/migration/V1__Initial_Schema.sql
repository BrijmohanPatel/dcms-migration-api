DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` BIGINT(20) DEFAULT NULL
);

DROP TABLE IF EXISTS `patient_seq`;
CREATE TABLE `patient_seq` (
  `next_val` BIGINT(20) DEFAULT NULL
);

INSERT INTO patient_seq (next_val) VALUES (1);

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `patient_id` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `age` INT(11) DEFAULT NULL,
  `chief_complaint` VARCHAR(255) DEFAULT NULL,
  `gender` VARCHAR(255) DEFAULT NULL,
  `intra_oral_examination` VARCHAR(255) DEFAULT NULL,
  `medical_history` VARCHAR(255) DEFAULT NULL,
  `mobile_number` VARCHAR(255) DEFAULT NULL,
  `patient_name` VARCHAR(255) DEFAULT NULL,
  `occupation` VARCHAR(255) DEFAULT NULL,
  `reg_date` DATE DEFAULT NULL,
  `create_timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `last_modified` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`patient_id`)
);

ALTER TABLE patients
ADD COLUMN last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
COMMIT;

SELECT * FROM patients;

DROP TABLE IF EXISTS `treatmentplan_seq`;
CREATE TABLE `treatmentplan_seq` (
  `next_val` BIGINT(20) DEFAULT NULL
);

INSERT INTO treatmentplan_seq (next_val) VALUES(1);

DROP TABLE IF EXISTS `treatment_plans`;
CREATE TABLE `treatment_plans` (
  `tp_id` VARCHAR(255) NOT NULL,
  `case_no` VARCHAR(255) DEFAULT NULL,
  `reg_date` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT NULL,
  `total_amount` DECIMAL(10, 2) DEFAULT NULL,
  `total_balance_amount` DECIMAL(10, 2) DEFAULT NULL,
  `total_paid_amount` DECIMAL(10, 2) DEFAULT NULL,
  PRIMARY KEY (`tp_id`)
);

COMMIT;