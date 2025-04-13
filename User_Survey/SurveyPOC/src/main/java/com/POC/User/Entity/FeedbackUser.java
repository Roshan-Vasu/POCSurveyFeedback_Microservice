package com.POC.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FeedbackUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackUserId;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	private String role;
	private String teamName;
	private String password;
	
	
	public FeedbackUser() {
		
	}
	
	public FeedbackUser(Long feedbackUserId, String userName, String firstName, String lastName, String emailId,
			String phoneNumber, String role, String teamName, String password) {
		super();
		this.feedbackUserId = feedbackUserId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.teamName = teamName;
		this.password = password;
	}

	public Long getFeedbackUserId() {
		return feedbackUserId;
	}

	public void setFeedbackUserId(Long feedbackUserId) {
		this.feedbackUserId = feedbackUserId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "FeedbackUser [feedbackUserId=" + feedbackUserId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", role=" + role
				+ ", teamName=" + teamName + ", password=" + password + "]";
	}

	
}
