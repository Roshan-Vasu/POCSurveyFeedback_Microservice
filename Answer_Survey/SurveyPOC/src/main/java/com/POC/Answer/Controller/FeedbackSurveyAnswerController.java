package com.POC.Answer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POC.Answer.Entity.FeedbackSurveyAnswer;
import com.POC.Answer.Service.FeedbackSurveyAnswerServiceImp;

@RestController
@RequestMapping("/api/surveyanswer")
public class FeedbackSurveyAnswerController {

	@Autowired
	private FeedbackSurveyAnswerServiceImp answerServiceImp;

	@GetMapping("/all")
	public List<FeedbackSurveyAnswer> getAllSurveyAnswer() {
		return answerServiceImp.getAllFeedbackAnswer();
	}

	@GetMapping("/{surveyAnswerId}")
	public FeedbackSurveyAnswer getMethodName(@PathVariable Long surveyAnswerId) {
		return answerServiceImp.getFeedbackAnswerById(surveyAnswerId);
	}

	@PostMapping("/saveSurveyAnswer")
	public FeedbackSurveyAnswer saveSurveyAnswer(@RequestBody FeedbackSurveyAnswer feedbackSurveyAnswer) {
		return answerServiceImp.saveFeedbackSurveyAnswer(feedbackSurveyAnswer);
	}

	@PutMapping("/updateSurveyAnswer")
	public FeedbackSurveyAnswer upateSurveyAnswer(@RequestBody FeedbackSurveyAnswer feedbackSurveyAnswer) {
		return answerServiceImp.updateFeedbackSurveyAnswer(feedbackSurveyAnswer);
	}

	@DeleteMapping("/deleteServeyAnswer/{surveyAnswerId}")
	public String deleteFeedbackSurveyAnswer(@PathVariable Long surveyAnswerId) {
		return answerServiceImp.deleteFeedbackSurveyAnswer(surveyAnswerId);
	}

	@GetMapping("/QuestionId/{questionId}")
	public List<FeedbackSurveyAnswer> getSurveyAnswerByQuestionID(@PathVariable Long questionId) {
		return answerServiceImp.getFeedbackAnswerByFeedbackSurveyQuestionId(questionId);
	}

	@GetMapping("/QuestionId/{questionId}/UserId/{userId}")
	public List<FeedbackSurveyAnswer> getSurveyAnswerByQuestionIDAndUserId(
			@PathVariable Long questionId, @PathVariable Long userId) {
		
		return answerServiceImp.getFeedbankAnswerByFeedbackSurveyQuestionIdAndFeedbackUserId(questionId,
				userId);
	}

}
