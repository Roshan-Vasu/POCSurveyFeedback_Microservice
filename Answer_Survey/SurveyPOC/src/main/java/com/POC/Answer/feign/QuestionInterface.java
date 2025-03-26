package com.POC.Answer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.POC.Answer.Entity.SurveyQuestion;


@FeignClient(name="Question-Service",url = "http://localhost:8080")
public interface QuestionInterface {

	@GetMapping("api/surveyquestion/{surveyQuestionId}")
	public SurveyQuestion GetQuestionById(@PathVariable Long surveyQuestionId);
}
