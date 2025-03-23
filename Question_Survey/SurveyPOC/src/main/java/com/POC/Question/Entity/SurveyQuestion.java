package com.POC.Question.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class SurveyQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  surveyQuestionId;
	private String questionText;
	private Long orderNumber;
	private  String questionType;
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
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	
	

}
