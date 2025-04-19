package com.POC.Answer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.Answer.Entity.FeedbackAnswer;

@Repository
public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswer, Long> {

	public List<FeedbackAnswer> findBySurveyQuestionId(Long surveyQuestionId);
	
	public List<FeedbackAnswer> findBySurveyQuestionIdAndFeedbackUserId(Long surveyQuestionId,  Long feedbackUserId);
}
