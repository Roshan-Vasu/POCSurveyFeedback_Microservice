package com.POC.Question.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.Question.Entity.FeedbackQuestion;

@Repository
public interface SurveyQuestionRepository extends JpaRepository<FeedbackQuestion, Long> {

    FeedbackQuestion findBySurveyQuestionIdAndOrderNumber(Long surveyQuestionId, Long orderNumber);

	Optional<FeedbackQuestion> findByQuestionText(String questionText);
}
