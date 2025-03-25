package com.POC.Answer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POC.Answer.Entity.FeedbackSurveyAnswer;
import com.POC.Answer.Entity.FeedbackUser;
import com.POC.Answer.Entity.SurveyQuestion;
import com.POC.Answer.Repository.FeedbackAnswerRepository;
import com.POC.Answer.feign.QuestionInterface;
import com.POC.Answer.feign.UserInterface;

@Service
public class FeedbackSurveyAnswerServiceImp implements FeedbackSurveyAnswerService {

	@Autowired
	QuestionInterface questionInterface;
	
	@Autowired
	UserInterface userInterface;
	
	@Autowired
	private FeedbackAnswerRepository feedbackAnswerRepository; 
	
	@Override
	public List<FeedbackSurveyAnswer> getAllFeedbackAnswer() {
		return feedbackAnswerRepository.findAll();
	}

	@Override
	public FeedbackSurveyAnswer getFeedbackAnswerById(Long surveyAnswerId) {
		return feedbackAnswerRepository.findById(surveyAnswerId).orElse(null);
	}

	@Override
	public FeedbackSurveyAnswer saveFeedbackSurveyAnswer(FeedbackSurveyAnswer feedbackSurveyAnswer) {
		
		SurveyQuestion question = questionInterface.GetQuestionById(feedbackSurveyAnswer.getSurveyQuestionId());
		
		FeedbackUser user = userInterface.getUserById(feedbackSurveyAnswer.getFeedbackUserId());
		
		if (user != null) {
			if (question != null) {
				return feedbackAnswerRepository.save(feedbackSurveyAnswer);
			} else {
				throw new RuntimeException("Invalid Question ID");
			}

		} else {
			throw new RuntimeException("Invalid User ID");
		}

		
		
		
	}

	@Override
	public FeedbackSurveyAnswer updateFeedbackSurveyAnswer(FeedbackSurveyAnswer feedbackSurveyAnswer) {
		return feedbackAnswerRepository.save(feedbackSurveyAnswer);
	}

	@Override
	public String deleteFeedbackSurveyAnswer(Long surveyAnswerId) {
		
		if(feedbackAnswerRepository.existsById(surveyAnswerId)) {
				feedbackAnswerRepository.deleteById(surveyAnswerId);
				return "Answer Deleted Successfully";
		} else {
			return "Answer cannot be deleted or Someting worng";
		}
	}

	@Override
	public List<FeedbackSurveyAnswer> getFeedbackAnswerByFeedbackSurveyQuestionId(Long surveyQuestionId) {
		return feedbackAnswerRepository.findBySurveyQuestionId(surveyQuestionId);
	}

	@Override
	public List<FeedbackSurveyAnswer> getFeedbankAnswerByFeedbackSurveyQuestionIdAndFeedbackUserId(
			Long surveyQuestionId, Long feedbackUserId) {
	
		return feedbackAnswerRepository.findBySurveyQuestionIdAndFeedbackUserId(surveyQuestionId, feedbackUserId);
	}
}
