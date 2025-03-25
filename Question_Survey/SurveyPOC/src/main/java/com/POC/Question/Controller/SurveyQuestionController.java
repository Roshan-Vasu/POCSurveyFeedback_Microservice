package com.POC.Question.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POC.Question.Entity.SurveyQuestion;
import com.POC.Question.Service.SurveyQuestionServiceImp;

@RestController
@RequestMapping("/api/surveyquestion")
public class SurveyQuestionController {

	@Autowired
	private SurveyQuestionServiceImp questionServiceImp;
	
	@GetMapping("/AllSurveyQuestion")
	public List<SurveyQuestion> getAllSurveyQuestion() {
		return questionServiceImp.getAllFeedbackSurveyQuestion();
	}
	
	@GetMapping("/{surveyQuestionId}")
	public SurveyQuestion GetQuestionById(@PathVariable Long surveyQuestionId) {
		return questionServiceImp.getFeedbackSurveyQuestionById(surveyQuestionId);
	}
	
	@PostMapping("/AddSurveyQuestion")
	public SurveyQuestion postMethodName(@RequestBody SurveyQuestion surveyQuestion) {
		return questionServiceImp.addFeedbackSurveyQuestion(surveyQuestion);
	}
	
	@PutMapping("/UpdateSurveyQuestion")
	public SurveyQuestion updateSurveyQuestion( @RequestBody SurveyQuestion surveyQuestion) {
		return questionServiceImp.updateFeedbackSurveyQuestion(surveyQuestion);
	}
	
	@DeleteMapping("/DeleteSurveyQuestion/{surveyQuestionId}")
	public SurveyQuestion deleteSurveyQuestion(@PathVariable Long surveyQuestionId) {
		return questionServiceImp.deleteFeedbackSurveyQuestion(surveyQuestionId);
	}
	
	@GetMapping("/SurveyQuestionID/{surveyQuestionId}/OrderNumber/{orderNumber}")
	public SurveyQuestion getSurveyQuestionByFeedbackSurveyIdAndOrderNumber(@PathVariable Long surveyQuestionId,  @PathVariable Long orderNumber) {
		return questionServiceImp.getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(surveyQuestionId, orderNumber);
	}
	
}
