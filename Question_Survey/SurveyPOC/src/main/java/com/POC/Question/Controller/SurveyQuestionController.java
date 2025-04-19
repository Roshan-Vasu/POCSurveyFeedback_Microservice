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

import com.POC.Question.DTO.QuestionDTO;
import com.POC.Question.Service.SurveyQuestionServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/surveyquestion")
public class SurveyQuestionController {

	@Autowired
	private SurveyQuestionServiceImp questionServiceImp;
	
	@GetMapping("/all")
	public ResponseEntity<List<QuestionDTO>> getAllSurveyQuestion() {
		List<QuestionDTO> dto = questionServiceImp.getAllFeedbackSurveyQuestion();
		
		return ResponseEntity.ok(dto);
		
	}
	
	@GetMapping("/{surveyQuestionId}")
	public ResponseEntity<QuestionDTO> GetQuestionById(@PathVariable @Valid Long surveyQuestionId) {
		QuestionDTO dto = questionServiceImp.getFeedbackSurveyQuestionById(surveyQuestionId);
		
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/addquestion")
	public ResponseEntity<QuestionDTO> addQuestion(@RequestBody @Valid QuestionDTO question) {
		QuestionDTO dto = questionServiceImp.addFeedbackSurveyQuestion(question);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/updatequestion")
	public ResponseEntity<QuestionDTO> updateSurveyQuestion( @RequestBody @Valid QuestionDTO question) {
		QuestionDTO dto = questionServiceImp.updateFeedbackSurveyQuestion(question);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/deletequestion/{surveyQuestionId}")
	public ResponseEntity<QuestionDTO> deleteSurveyQuestion(@PathVariable @Valid Long surveyQuestionId) {
		QuestionDTO dto = questionServiceImp.deleteFeedbackSurveyQuestion(surveyQuestionId);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/survey/{surveyQuestionId}/order/{orderNumber}")
	public ResponseEntity<QuestionDTO> getSurveyQuestionByFeedbackSurveyIdAndOrderNumber(@PathVariable @Valid Long surveyQuestionId, @PathVariable @Valid Long orderNumber) {
		
		QuestionDTO dto = questionServiceImp.getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(surveyQuestionId, orderNumber);
		return ResponseEntity.ok(dto);
	}
	
}
