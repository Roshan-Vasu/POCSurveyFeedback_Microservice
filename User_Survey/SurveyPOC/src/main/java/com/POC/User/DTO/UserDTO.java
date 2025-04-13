package com.POC.User.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class UserDTO {

	@NotBlank(message = "User Name cannot be empty")
	@Size(min = 3, max = 50, message = "User Name must be between 3 to 10 Character" )
	private String userName;
	
	@NotBlank(message = "First Name cannot be empty")
	@Size(min = 3, max = 20, message = "First Name must be between 3 to 20 Character" )
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be empty")
	@Size(min = 3, max = 20, message = "Last Name must be between 3 to 20 Character" )
	private String lastName;
	
	@NotBlank(message = "EmailID Cannot be empty")
	@Email(message = "Invalid Email format")
	private String emailId;
	
	@NotBlank(message = "Phone Number Cannot be empty")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone Number Must be 10 Number")
	private String phoneNumber;
	
	@NotBlank(message = "Role Cannot be empty")
	private String role;
	
	@NotBlank(message = "Team Name Cannot be empty")
	private String teamName;


	public UserDTO() {
		super();
	}


	public UserDTO(
			@NotBlank(message = "User Name cannot be empty") @Size(min = 3, max = 50, message = "User Name must be between 3 to 10 Character") String userName,
			@NotBlank(message = "First Name cannot be empty") @Size(min = 3, max = 20, message = "First Name must be between 3 to 20 Character") String firstName,
			@NotBlank(message = "Last Name cannot be empty") @Size(min = 3, max = 20, message = "Last Name must be between 3 to 20 Character") String lastName,
			@NotBlank(message = "EmailID Cannot be empty") @Email(message = "Invalid Email format") String emailId,
			@NotBlank(message = "Phone Number Cannot be empty") @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number Must be 10 Number") String phoneNumber,
			@NotBlank(message = "Role Cannot be empty") String role,
			@NotBlank(message = "Team Name Cannot be empty") String teamName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.teamName = teamName;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
}
