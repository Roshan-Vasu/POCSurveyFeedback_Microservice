package com.POC.Answer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.POC.Answer.DTO.QuestionDTO;


@FeignClient(name="Question-Service",url = "http://localhost:8080")
public interface QuestionInterface {

	@GetMapping("api/surveyquestion/{surveyQuestionId}")
	public QuestionDTO GetQuestionById(@PathVariable Long surveyQuestionId);
}
