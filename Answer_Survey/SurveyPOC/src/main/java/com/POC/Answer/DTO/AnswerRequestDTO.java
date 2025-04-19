package com.POC.Answer.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class AnswerRequestDTO {
	
	
	@NotNull(message = "Answer Id Required")
	private Long  surveyAnswerId;
	
	@NotBlank(message = "Please Enter Comments")
	private String comments;
	
	@NotNull(message = "Rating is Required")
	@Min(value = 1, message = "Rating must be at least 1")
	@Max(value = 5, message = "Rating must be at most 5")
	private Integer rating;
	
	@NotNull(message = "Question Id Required")
	private Long surveyQuestionId;	
	
	@NotNull(message = "User Id Required")
	private Long feedbackUserId;
	
	
	public AnswerRequestDTO() {
		super();
	}


	public AnswerRequestDTO(@NotNull(message = "Answer Id Required") Long surveyAnswerId,
			@NotBlank(message = "Please Enter Comments") String comments,
			@NotNull(message = "Rating is Required") @Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must be at most 5") Integer rating,
			@NotNull(message = "Question Id Required") Long surveyQuestionId,
			@NotNull(message = "User Id Required") Long feedbackUserId) {
		super();
		this.surveyAnswerId = surveyAnswerId;
		this.comments = comments;
		this.rating = rating;
		this.surveyQuestionId = surveyQuestionId;
		this.feedbackUserId = feedbackUserId;
	}
	
	
	public Long getSurveyAnswerId() {
		return surveyAnswerId;
	}
	public void setSurveyAnswerId(Long surveyAnswerId) {
		this.surveyAnswerId = surveyAnswerId;
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
	public Long getSurveyQuestionId() {
		return surveyQuestionId;
	}
	public void setSurveyQuestionId(Long surveyQuestionId) {
		this.surveyQuestionId = surveyQuestionId;
	}
	public Long getFeedbackUserId() {
		return feedbackUserId;
	}
	public void setFeedbackUserId(Long feedbackUserId) {
		this.feedbackUserId = feedbackUserId;
	}
	
	
}
