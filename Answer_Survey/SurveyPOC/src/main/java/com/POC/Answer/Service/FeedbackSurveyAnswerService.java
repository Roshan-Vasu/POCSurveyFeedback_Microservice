package com.POC.Answer.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.POC.Answer.DTO.AnswerRequestDTO;
import com.POC.Answer.DTO.AnswerResponseDTO;

@Service
public interface FeedbackSurveyAnswerService {

	public List<AnswerResponseDTO> getAllFeedbackAnswer();
	
	public AnswerResponseDTO getFeedbackAnswerById(Long surveyAnswerId);
	
	public AnswerResponseDTO saveFeedbackSurveyAnswer(AnswerRequestDTO requestDTO);
	
	public AnswerResponseDTO updateFeedbackSurveyAnswer(AnswerRequestDTO requestDTO);
	
	public AnswerResponseDTO deleteFeedbackSurveyAnswer(Long surveyAnswerId);
	
	public List<AnswerResponseDTO> getFeedbackAnswerByFeedbackSurveyQuestionId(Long surveyQuestionId );
	
	public List<AnswerResponseDTO> getFeedbankAnswerByFeedbackSurveyQuestionIdAndFeedbackUserId(Long surveyQuestionId,  Long feedbackUserId);
}
