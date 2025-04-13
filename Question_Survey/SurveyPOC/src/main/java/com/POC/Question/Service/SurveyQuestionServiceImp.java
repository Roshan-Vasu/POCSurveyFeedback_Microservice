package com.POC.Question.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POC.Question.DTO.QuestionDTO;
import com.POC.Question.Entity.SurveyQuestion;
import com.POC.Question.Repository.SurveyQuestionRepository;
import com.POC.Question.Exception.*;




@Service
public class SurveyQuestionServiceImp implements SurveyQuestionService {

	@Autowired
	private SurveyQuestionRepository surveyQuestionRepository;
	
	private QuestionDTO entityToDTO(SurveyQuestion question) {
		
		QuestionDTO dto = new QuestionDTO();
		
		dto.setOrderNumber(question.getOrderNumber());
		dto.setQuestionText(question.getQuestionText());
		dto.setQuestionType(question.getQuestionType());
		
		return dto;
	}
	
	private SurveyQuestion dtoToEntity(QuestionDTO dto) {
		
		SurveyQuestion question = new SurveyQuestion();
		
		question.setOrderNumber(dto.getOrderNumber());
		question.setQuestionText(dto.getQuestionText());
		question.setQuestionType(dto.getQuestionType());
		
		return question;
	}
	
	
	@Override
	public List<QuestionDTO> getAllFeedbackSurveyQuestion() {
		
		List<SurveyQuestion> question = surveyQuestionRepository.findAll();
		
		if(question.isEmpty()) {
			 throw new QuestionNotFoundException("No Questions Found!");
		}
		
		    return question.stream()
		    	.map(q -> new QuestionDTO(
		    				q.getQuestionText(),
		    				q.getOrderNumber(),
		    				q.getQuestionType()))
		    		.collect(Collectors.toList());
	}

	@Override
	public QuestionDTO getFeedbackSurveyQuestionById(Long SurveyQuestionId) {
		
		SurveyQuestion question =  surveyQuestionRepository.findById(SurveyQuestionId)
				.orElseThrow(()-> new QuestionNotFoundException("Question not found with ID: " + SurveyQuestionId));

		return entityToDTO(question);
	}

	@Override
	public QuestionDTO addFeedbackSurveyQuestion (QuestionDTO surveyQuestion) {
		
		SurveyQuestion entityQuestion = dtoToEntity(surveyQuestion);
		
		surveyQuestionRepository.findByQuestionText(entityQuestion.getQuestionText())
		.ifPresent(existingQuestion -> {
			throw new DuplicateQuestionException("Survey Question is Already Exists " + existingQuestion.getQuestionText());
		});
		
		return entityToDTO(surveyQuestionRepository.save(entityQuestion));
	}

	@Override
	public QuestionDTO updateFeedbackSurveyQuestion(QuestionDTO surveyQuestion) {
		
		SurveyQuestion sQuestion = dtoToEntity(surveyQuestion);
		
		surveyQuestionRepository.findByQuestionText(sQuestion.getQuestionText())
			.orElseThrow(()-> new QuestionNotFoundException("Survey Question or Question Id is not found " + sQuestion.getSurveyQuestionId()));
		
		
		return entityToDTO(surveyQuestionRepository.save(sQuestion));
	}

	@Override
	public SurveyQuestion deleteFeedbackSurveyQuestion(Long surveyQuestionID) {
		SurveyQuestion surveyQuestionData =  surveyQuestionRepository.findById(surveyQuestionID).orElse(null);
		if(surveyQuestionData != null) {
			surveyQuestionRepository.delete(surveyQuestionData);
			return surveyQuestionData;
		} else {
			return null;
		}	
	}

	@Override
	public SurveyQuestion getFeedbackSurveyQuestionByFeedbackSurveyIdandOrderNo(Long SurveyQuestionId, Long OrderNo) {
		return surveyQuestionRepository.findBySurveyQuestionIdAndOrderNumber(SurveyQuestionId, OrderNo);	
	}

	

}
