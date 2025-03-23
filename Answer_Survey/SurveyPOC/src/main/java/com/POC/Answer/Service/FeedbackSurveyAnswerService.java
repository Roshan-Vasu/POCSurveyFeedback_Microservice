package com.POC.Answer.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.POC.Answer.Entity.FeedbackSurveyAnswer;

@Service
public interface FeedbackSurveyAnswerService {

	public List<FeedbackSurveyAnswer> getAllFeedbackAnswer();
	
	public FeedbackSurveyAnswer getFeedbackAnswerById(Long surveyAnswerId);
	
	public FeedbackSurveyAnswer saveFeedbackSurveyAnswer(FeedbackSurveyAnswer feedbackSurveyAnswer);
	
	public FeedbackSurveyAnswer updateFeedbackSurveyAnswer(FeedbackSurveyAnswer feedbackSurveyAnswer);
	
	public String deleteFeedbackSurveyAnswer(Long surveyAnswerId);
	
	public List<FeedbackSurveyAnswer> getFeedbackAnswerByFeedbackSurveyQuestionId(Long surveyQuestionId );
	
	public List<FeedbackSurveyAnswer> getFeedbankAnswerByFeedbackSurveyQuestionIdAndFeedbackUserId(Long surveyQuestionId,  Long feedbackUserId);
}
