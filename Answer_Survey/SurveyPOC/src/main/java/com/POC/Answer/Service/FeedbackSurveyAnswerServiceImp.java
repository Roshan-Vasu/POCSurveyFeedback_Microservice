package com.POC.Answer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POC.Answer.DTO.AnswerRequestDTO;
import com.POC.Answer.DTO.AnswerResponseDTO;
import com.POC.Answer.DTO.QuestionDTO;
import com.POC.Answer.DTO.UserDTO;
import com.POC.Answer.Entity.FeedbackAnswer;
import com.POC.Answer.Exception.ResourceNotFoundException;
import com.POC.Answer.Repository.FeedbackAnswerRepository;
import com.POC.Answer.feign.QuestionInterface;
import com.POC.Answer.feign.UserInterface;

import feign.FeignException;

@Service
public class FeedbackSurveyAnswerServiceImp implements FeedbackSurveyAnswerService {

    @Autowired
    private QuestionInterface questionInterface;

    @Autowired
    private UserInterface userInterface;

    @Autowired
    private FeedbackAnswerRepository feedbackAnswerRepository;

    
    
    @Override
    public List<AnswerResponseDTO> getAllFeedbackAnswer() {
    	
        List<FeedbackAnswer> answers = feedbackAnswerRepository.findAll();

        return answers.stream().map(answer -> {
            QuestionDTO question = questionInterface.GetQuestionById(answer.getSurveyQuestionId());
            
            if (question == null) {
                throw new ResourceNotFoundException("Question not found for ID: " + answer.getSurveyQuestionId());
            }

            UserDTO user = userInterface.getUserById(answer.getFeedbackUserId());
            if (user == null) {
                throw new ResourceNotFoundException("User not found for ID: " + answer.getFeedbackUserId());
            }

            return new AnswerResponseDTO(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getTeamName(),
                    question.getQuestionId(),
                    question.getQuestionText(),
                    answer.getComments(),
                    answer.getRating()
            );
        }).collect(Collectors.toList());
    }

    @Override
    public AnswerResponseDTO getFeedbackAnswerById(Long surveyAnswerId) {
    	
        FeedbackAnswer answer = feedbackAnswerRepository.findById(surveyAnswerId)
                .orElseThrow(() -> new ResourceNotFoundException("Answer not found with id: " + surveyAnswerId));

        QuestionDTO question = questionInterface.GetQuestionById(answer.getSurveyQuestionId());
        if (question == null) {
            throw new ResourceNotFoundException("Question not found for ID: " + answer.getSurveyQuestionId());
        }

        UserDTO user = userInterface.getUserById(answer.getFeedbackUserId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found for ID: " + answer.getFeedbackUserId());
        }

        return new AnswerResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getTeamName(),
                question.getQuestionId(),
                question.getQuestionText(),
                answer.getComments(),
                answer.getRating()
        );
        
        
    }

    @Override
    public AnswerResponseDTO saveFeedbackSurveyAnswer(AnswerRequestDTO requestDTO) {
    	QuestionDTO question;
        try {
            question = questionInterface.GetQuestionById(requestDTO.getSurveyQuestionId());
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException("Question not found with ID: " + requestDTO.getSurveyQuestionId());
        }

        UserDTO user;
        try {
            user = userInterface.getUserById(requestDTO.getFeedbackUserId());
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException("User not found with ID: " + requestDTO.getFeedbackUserId());
        }

        FeedbackAnswer answer = new FeedbackAnswer();
        answer.setSurveyQuestionId(requestDTO.getSurveyQuestionId());
        answer.setFeedbackUserId(requestDTO.getFeedbackUserId());
        answer.setComments(requestDTO.getComments());
        answer.setRating(requestDTO.getRating());

        FeedbackAnswer savedAnswer = feedbackAnswerRepository.save(answer);

        return new AnswerResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getTeamName(),
                question.getQuestionId(),
                question.getQuestionText(),
                savedAnswer.getComments(),
                savedAnswer.getRating()
        );
    }

    @Override
    public AnswerResponseDTO updateFeedbackSurveyAnswer(AnswerRequestDTO requestDTO) {
        FeedbackAnswer existingAnswer = feedbackAnswerRepository.findById(requestDTO.getSurveyAnswerId())
                .orElseThrow(() -> new ResourceNotFoundException("Answer not found with ID: " + requestDTO.getSurveyAnswerId()));

        QuestionDTO question = questionInterface.GetQuestionById(requestDTO.getSurveyQuestionId());
        if (question == null) {
            throw new ResourceNotFoundException("Invalid Question ID");
        }

        UserDTO user = userInterface.getUserById(requestDTO.getFeedbackUserId());
        if (user == null) {
            throw new ResourceNotFoundException("Invalid User ID");
        }

        existingAnswer.setSurveyQuestionId(requestDTO.getSurveyQuestionId());
        existingAnswer.setFeedbackUserId(requestDTO.getFeedbackUserId());
        existingAnswer.setComments(requestDTO.getComments());
        existingAnswer.setRating(requestDTO.getRating());

        FeedbackAnswer updatedAnswer = feedbackAnswerRepository.save(existingAnswer);

        return new AnswerResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getTeamName(),
                question.getQuestionId(),
                question.getQuestionText(),
                updatedAnswer.getComments(),
                updatedAnswer.getRating()
        );
    }

    @Override
    public AnswerResponseDTO deleteFeedbackSurveyAnswer(Long surveyAnswerId) {
    	
    	 FeedbackAnswer answer = feedbackAnswerRepository.findById(surveyAnswerId)
    			 .orElseThrow(() -> new ResourceNotFoundException("Answer Not Found with this id " + surveyAnswerId));
    	
        UserDTO user = userInterface.getUserById(answer.getFeedbackUserId());
        QuestionDTO question = questionInterface.GetQuestionById(answer.getSurveyQuestionId());
       
        feedbackAnswerRepository.deleteById(surveyAnswerId);

        return new AnswerResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getTeamName(),
                question.getQuestionId(),
                question.getQuestionText(),
                answer.getComments(),
                answer.getRating()
        );
    }

    @Override
    public List<AnswerResponseDTO> getFeedbackAnswerByFeedbackSurveyQuestionId(Long surveyQuestionId) {
        List<FeedbackAnswer> answers = feedbackAnswerRepository.findBySurveyQuestionId(surveyQuestionId);
        
        return answers.stream().map(answer -> {
            QuestionDTO question = questionInterface.GetQuestionById(answer.getSurveyQuestionId());
            if (question == null) {
                throw new ResourceNotFoundException("Question not found for ID: " + answer.getSurveyQuestionId());
            }

            UserDTO user = userInterface.getUserById(answer.getFeedbackUserId());
            if (user == null) {
                throw new ResourceNotFoundException("User not found for ID: " + answer.getFeedbackUserId());
            }

            return new AnswerResponseDTO(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getTeamName(),
                    question.getQuestionId(),
                    question.getQuestionText(),
                    answer.getComments(),
                    answer.getRating()
            );
        }).collect(Collectors.toList());
    }

    @Override
    public List<AnswerResponseDTO> getFeedbankAnswerByFeedbackSurveyQuestionIdAndFeedbackUserId(Long surveyQuestionId, Long feedbackUserId) {
        List<FeedbackAnswer> answers = feedbackAnswerRepository.findBySurveyQuestionIdAndFeedbackUserId(surveyQuestionId, feedbackUserId);
        
        return answers.stream().map(answer -> {
            QuestionDTO question = questionInterface.GetQuestionById(answer.getSurveyQuestionId());
            if (question == null) {
                throw new ResourceNotFoundException("Question not found for ID: " + answer.getSurveyQuestionId());
            }

            UserDTO user = userInterface.getUserById(answer.getFeedbackUserId());
            if (user == null) {
                throw new ResourceNotFoundException("User not found for ID: " + answer.getFeedbackUserId());
            }

            return new AnswerResponseDTO(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole(),
                    user.getTeamName(),
                    question.getQuestionId(),
                    question.getQuestionText(),
                    answer.getComments(),
                    answer.getRating()
            );
        }).collect(Collectors.toList());
    }
}
