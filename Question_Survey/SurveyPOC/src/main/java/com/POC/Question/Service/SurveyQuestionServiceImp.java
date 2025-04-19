package com.POC.Question.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POC.Question.DTO.QuestionDTO;
import com.POC.Question.Entity.FeedbackQuestion;
import com.POC.Question.Exception.DuplicateQuestionException;
import com.POC.Question.Exception.QuestionNotFoundException;
import com.POC.Question.Repository.SurveyQuestionRepository;




@Service
public class SurveyQuestionServiceImp implements SurveyQuestionService {

	@Autowired
	private SurveyQuestionRepository questionRepo;
	
	private QuestionDTO entityToDTO(FeedbackQuestion question) {
		
		QuestionDTO dto = new QuestionDTO();
		dto.setQuestionId(question.getSurveyQuestionId());
		dto.setOrderNumber(question.getOrderNumber());
		dto.setQuestionText(question.getQuestionText());
		dto.setQuestionType(question.getQuestionType());
		
		return dto;
	}
	
	private FeedbackQuestion dtoToEntity(QuestionDTO dto) {
		
		FeedbackQuestion question = new FeedbackQuestion();
		
		question.setSurveyQuestionId(dto.getQuestionId());
		question.setOrderNumber(dto.getOrderNumber());
		question.setQuestionText(dto.getQuestionText());
		question.setQuestionType(dto.getQuestionType());
		
		return question;
	}
	
	
	@Override
	public List<QuestionDTO> getAllFeedbackSurveyQuestion() {
		
		List<FeedbackQuestion> question = questionRepo.findAll();
		
		if(question.isEmpty()) {
			 throw new QuestionNotFoundException("No Questions Found!");
		}
		
		    return question.stream()
		    	.map(q -> new QuestionDTO(
		    			q.getQuestionText(),
		    			q.getOrderNumber(),
		    			q.getQuestionType(),
		    			q.getSurveyQuestionId()))
		    	.collect(Collectors.toList());
		    	
	}

	@Override
	public QuestionDTO getFeedbackSurveyQuestionById(Long SurveyQuestionId) {
		
		FeedbackQuestion question =  questionRepo.findById(SurveyQuestionId)
				.orElseThrow(()-> new QuestionNotFoundException("Question not found with ID: " + SurveyQuestionId));

		return entityToDTO(question);
	}

	@Override
	public QuestionDTO addFeedbackSurveyQuestion (QuestionDTO surveyQuestion) {
		
		FeedbackQuestion entityQuestion = dtoToEntity(surveyQuestion);
		
		questionRepo.findByQuestionText(entityQuestion.getQuestionText())
		.ifPresent(existingQuestion -> {
			throw new DuplicateQuestionException(String.format("Survey Question is Already Exists: \"%s\"", entityQuestion.getQuestionText()));
		});
		
		return entityToDTO(questionRepo.save(entityQuestion));
	}

	@Override
	public QuestionDTO updateFeedbackSurveyQuestion(QuestionDTO surveyQuestion) {
		
		FeedbackQuestion sQuestion = dtoToEntity(surveyQuestion);
		
		questionRepo.findById(sQuestion.getSurveyQuestionId())
			.orElseThrow(()-> new QuestionNotFoundException("Survey Question or Question Id is not found " + sQuestion.getSurveyQuestionId()));
		return entityToDTO(questionRepo.save(sQuestion));
	}

	@Override
	public QuestionDTO deleteFeedbackSurveyQuestion(Long surveyQuestionID) {
		FeedbackQuestion surveyQuestionData =  questionRepo.findById(surveyQuestionID).orElse(null);
		if(surveyQuestionData != null) {
			questionRepo.delete(surveyQuestionData);
			return entityToDTO(surveyQuestionData);
		} else {
			return null;
		}	
	}

	@Override
	public QuestionDTO getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(Long SurveyQuestionId, Long OrderNo) {
		
		FeedbackQuestion question = questionRepo.findBySurveyQuestionIdAndOrderNumber(SurveyQuestionId, OrderNo);
		
		if(question == null) {
			 throw new QuestionNotFoundException("Question Not found with ID: "+ SurveyQuestionId + " Order No: "+ OrderNo);
		}
		return entityToDTO(question);	
	}

	

}
