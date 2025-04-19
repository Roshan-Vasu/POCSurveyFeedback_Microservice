package com.POC.Question.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.POC.Question.DTO.QuestionDTO;

import jakarta.validation.Valid;

@Service
public interface SurveyQuestionService {

	public List<QuestionDTO> getAllFeedbackSurveyQuestion();
	
	public QuestionDTO getFeedbackSurveyQuestionById(@Valid Long surveyQuestionId);
	
	public QuestionDTO addFeedbackSurveyQuestion(@Valid QuestionDTO surveyQuestion);
	
	public QuestionDTO updateFeedbackSurveyQuestion(@Valid QuestionDTO surveyQuestion);
	
	public QuestionDTO deleteFeedbackSurveyQuestion(@Valid Long  surveyQuestionId);
	
	public QuestionDTO getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(@Valid Long SurveyQuestionId,@Valid Long OrderNo);
	
}
