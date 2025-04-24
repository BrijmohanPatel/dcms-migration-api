package com.lacheln.dcms.dto;

import java.util.List;

public class ResponseBean {
   
		
	ResponseData data = new ResponseData();
	
	private String message;
	private String userName;
	private String userCode;
	private long userId;
	private String statusCode;
	private String action;
	private String accessToken;
	private String email;
	private String userMobileNumber;
	private String fileName;
	private String status;
	
	/*
	Adding a default constructor for ResponseBean to ensure consistent initialization. 
	This can help avoid null pointers in case the constructor is not explicitly called.
	*/	
	/*public ResponseBean(){
		this.data = new ResponseData();
	}*/
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseData getData() {
		return data;
	}
	public void setData(ResponseData data) {
		this.data = data;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ResponseBean [data=" + data + ", message=" + message + ", userName=" + userName + ", userCode="
				+ userCode + ", userId=" + userId + ", statusCode=" + statusCode + ", action=" + action
				+ ", accessToken=" + accessToken + ", email=" + email + ", userMobileNumber=" + userMobileNumber
				+ ", fileName=" + fileName + ", status=" + status + "]";
	}
	
	
}
