package com.POC.Question.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class QuestionDTO {
	
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
			@NotBlank(message = "Please select the Question Type") String questionType) {
		super();
		this.questionText = questionText;
		this.orderNumber = orderNumber;
		this.questionType = questionType;
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
