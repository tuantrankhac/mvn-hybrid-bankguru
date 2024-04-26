package com.data.hrm;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import commons.GlobalConstants;

public class EmployeeData {
	public static EmployeeData getEmployee() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\hrm\\data\\Employee.json"), EmployeeData.class);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@JsonProperty("empFirstName")
	private String empFirstName;
	
	@JsonProperty("empLastName")
	private String empLastName;
	
	@JsonProperty("empUserName")
	private String empUserName;
	
	@JsonProperty("empPassword")
	private String empPassword;

	public String getEmpFirstName() {
		return empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public String getEmpPassword() {
		return empPassword;
	}
	
	@JsonProperty("ContactDetail")
	ContactDetail ContactDetail;
	
	public class ContactDetail{
		@JsonProperty("editFirstName")
		private String editFirstName;
		
		@JsonProperty("editLastName")
		private String editLastName;
		
		
	}
	
	public String getEditFirstName() {
		return ContactDetail.editFirstName;
	}
	
	public String getEditLastName() {
		return ContactDetail.editLastName;
	}
}
