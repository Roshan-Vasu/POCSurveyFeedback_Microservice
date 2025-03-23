package com.POC.Question.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.POC.Question.Entity.SurveyQuestion;

@Service
public interface SurveyQuestionService {

	public List<SurveyQuestion> getAllFeedbackSurveyQuestion();
	
	public SurveyQuestion getFeedbackSurveyQuestionById(Long surveyQuestionId);
	
	public SurveyQuestion addFeedbackSurveyQuestion(SurveyQuestion surveyQuestion);
	
	public SurveyQuestion updateFeedbackSurveyQuestion(SurveyQuestion surveyQuestion);
	
	public SurveyQuestion deleteFeedbackSurveyQuestion(Long  surveyQuestionId);
	
	public SurveyQuestion getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(Long SurveyQuestionId, Long OrderNo);
	
}
