package com.POC.Answer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.Answer.Entity.FeedbackSurveyAnswer;

@Repository
public interface FeedbackAnswerRepository extends JpaRepository<FeedbackSurveyAnswer, Long> {

	public List<FeedbackSurveyAnswer> findBySurveyQuestionId(Long surveyQuestionId);
	
	public List<FeedbackSurveyAnswer> findBySurveyQuestionIdAndFeedbackUserId(Long surveyQuestionId,  Long feedbackUserId);
}
