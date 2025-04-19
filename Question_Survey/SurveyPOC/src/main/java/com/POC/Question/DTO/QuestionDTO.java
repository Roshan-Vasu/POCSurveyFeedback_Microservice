package com.POC.Question.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class QuestionDTO {
	
	@NotBlank(message = "Question Id Cannot be Empty")
	private Long questionId;
	@NotBlank(message = "Question Cannot be Empty")
	private String questionText;
	@NotNull(message = "Please give me a order number of Question")
	private Long orderNumber;
	@NotBlank(message = "Please select the Question Type")
	private  String questionType;
		
	
	public QuestionDTO() {
		super();
	}

	
	public QuestionDTO(@NotBlank(message = "Question Cannot be Empty") String questionText,
			@NotNull(message = "Please give me a order number of Question") Long orderNumber,
			@NotBlank(message = "Please select the Question Type") String questionType,
			@NotBlank(message = "Please select the Question Id") Long questionId) {
		super();
		this.questionText = questionText;
		this.orderNumber = orderNumber;
		this.questionType = questionType;
		this.questionId = questionId;
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
	
	public Long getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
	
}
