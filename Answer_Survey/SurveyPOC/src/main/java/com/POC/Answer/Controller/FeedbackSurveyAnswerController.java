package com.POC.Answer.Controller;

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

import com.POC.Answer.DTO.AnswerRequestDTO;
import com.POC.Answer.DTO.AnswerResponseDTO;
import com.POC.Answer.Service.FeedbackSurveyAnswerServiceImp;

@RestController
@RequestMapping("/api/surveyanswer")
public class FeedbackSurveyAnswerController {

    @Autowired
    private FeedbackSurveyAnswerServiceImp answerServiceImp;

   

    @GetMapping("/all")
    public ResponseEntity<List<AnswerResponseDTO>> getAllSurveyAnswer() {
    	
    	List <AnswerResponseDTO> dto = answerServiceImp.getAllFeedbackAnswer();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{surveyAnswerId}")
    public ResponseEntity<AnswerResponseDTO > getSurveyAnswerById(@PathVariable Long surveyAnswerId) {
    	AnswerResponseDTO dto =	answerServiceImp.getFeedbackAnswerById(surveyAnswerId);
    	return ResponseEntity.ok(dto);
    }

    @PostMapping("/saveSurveyAnswer")
    public ResponseEntity<AnswerResponseDTO>  saveSurveyAnswer(@RequestBody AnswerRequestDTO answerRequestDTO) {
    		
    	AnswerResponseDTO dto =	answerServiceImp.saveFeedbackSurveyAnswer(answerRequestDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/updateSurveyAnswer")
    public ResponseEntity<AnswerResponseDTO> updateSurveyAnswer(@RequestBody AnswerRequestDTO answerRequestDTO) {
        AnswerResponseDTO dto = answerServiceImp.updateFeedbackSurveyAnswer(answerRequestDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deleteSurveyAnswer/{surveyAnswerId}")
    public ResponseEntity<AnswerResponseDTO> deleteFeedbackSurveyAnswer(@PathVariable Long surveyAnswerId) {
        AnswerResponseDTO dto = answerServiceImp.deleteFeedbackSurveyAnswer(surveyAnswerId);
        return ResponseEntity.ok(dto);
    }
}
