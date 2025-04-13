package com.POC.Question.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.POC.Question.DTO.QuestionDTO;
import com.POC.Question.Entity.SurveyQuestion;

@Service
public interface SurveyQuestionService {

	public List<QuestionDTO> getAllFeedbackSurveyQuestion();
	
	public QuestionDTO getFeedbackSurveyQuestionById(Long surveyQuestionId);
	
	public QuestionDTO addFeedbackSurveyQuestion(QuestionDTO surveyQuestion);
	
	public QuestionDTO updateFeedbackSurveyQuestion(QuestionDTO surveyQuestion);
	
	public SurveyQuestion deleteFeedbackSurveyQuestion(Long  surveyQuestionId);
	
	public SurveyQuestion getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(Long SurveyQuestionId, Long OrderNo);
	
}
