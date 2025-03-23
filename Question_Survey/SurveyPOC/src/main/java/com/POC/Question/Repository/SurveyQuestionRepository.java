package com.POC.Question.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POC.Question.Entity.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {

    SurveyQuestion findBySurveyQuestionIdAndOrderNumber(Long surveyQuestionId, Long orderNumber);
}
