package com.lacheln.dcms.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lacheln.dcms.service.impl.PatientsServiceImpl;

public class DateUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static boolean isValidRegistrationDate(String input) {
		logger.info("DateUtil.isValidRegistrationDate : originalDate is : {}", input);
        if (input == null || input.isEmpty()) {
            logger.warn("Input is null or empty. Returning false.");
            return false;
        }

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
        try {
            // Parse the input string to check if it's a valid date
        	LocalDate localDate = LocalDate.parse(input, formatter);
            logger.info("Successfully parsed date: " + localDate.toString());
            return true;
        } catch (Exception e) {
            // If there's a parsing exception, it's not a valid date
            logger.error("Parsing failed. Returning false. Error: " + e.getMessage());
            return false;
        }
    }

	public static LocalDate parseRegDateToLocalDate(String originalDate) throws ParseException {
		logger.info("DateUtil.parseRegDateToLocalDate : originalDate is : {}", originalDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(originalDate, formatter);
		logger.info("DateUtil.parseRegDateToLocalDate : formated originalDate is : {}", localDate.toString());
		return localDate;
	}
}
