package com.POC.Question.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POC.Question.Entity.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {

    SurveyQuestion findBySurveyQuestionIdAndOrderNumber(Long surveyQuestionId, Long orderNumber);

	List<SurveyQuestion> getAllFeedbackSurveyQuestion();
	Optional<SurveyQuestion> findByQuestionText(String questionText);
}
