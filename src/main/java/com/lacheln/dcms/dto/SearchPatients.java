package com.lacheln.dcms.dto;

public class SearchPatients {
	
	String search_by_option;
	String search_by_optionvalue;
		
	public String getSearch_by_option() {
		return search_by_option;
	}
	public void setSearch_by_option(String search_by_option) {
		this.search_by_option = search_by_option;
	}
	public String getSearch_by_optionvalue() {
		return search_by_optionvalue;
	}
	public void setSearch_by_optionvalue(String search_by_optionvalue) {
		this.search_by_optionvalue = search_by_optionvalue;
	}
	
	DateRangeDTO dateRangeDTO;

	public DateRangeDTO getDateRangeDTO() {
		return dateRangeDTO;
	}
	public void setDateRangeDTO(DateRangeDTO dateRangeDTO) {
		this.dateRangeDTO = dateRangeDTO;
	}

	
	
}