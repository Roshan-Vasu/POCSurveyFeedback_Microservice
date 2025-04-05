package com.POC.User.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.POC.User.DTO.UserDTO;
import com.POC.User.Entity.FeedbackUser;

import jakarta.validation.Valid;

@Service
public interface FeedbackUserService {
	

	public UserDTO feedbackUserById(Long feedBackUserId);

	public List<UserDTO> getAllFeedbackUsers();

	public UserDTO saveFeedbackUser(@Valid UserDTO userDTO);

	public UserDTO updateFeedbackUser(@Valid UserDTO userDTO);

	public String deleteFeedbackUser(String feedbackUserEmailID);
	
	public UserDTO existsByEmailId(String feedbackUserEmailID);

	public boolean validateFeedbackUser(FeedbackUser feedbackUser);

}
