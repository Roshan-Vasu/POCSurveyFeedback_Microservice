package com.POC.Answer.DTO;

public class AnswerResponseDTO {

	
	private String firstName;
	private String lastName;
	private String teamName;
	private String role;
	
	private Long  surveyQuestionId;
	private String questionText;
	
	private String comments;
	private Integer rating;
	
	
	
	
	
	public AnswerResponseDTO() {
		super();
	}
	
	
	public AnswerResponseDTO(String firstName, String lastName, String teamName, String role, Long surveyQuestionId,
			String questionText, String comments, Integer rating) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamName = teamName;
		this.role = role;
		this.surveyQuestionId = surveyQuestionId;
		this.questionText = questionText;
		this.comments = comments;
		this.rating = rating;
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
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getSurveyQuestionId() {
		return surveyQuestionId;
	}
	public void setSurveyQuestionId(Long surveyQuestionId) {
		this.surveyQuestionId = surveyQuestionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	

	
	
}
