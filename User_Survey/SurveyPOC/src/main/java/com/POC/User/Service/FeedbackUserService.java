package com.POC.User.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.POC.User.Entity.FeedbackUser;

@Service
public interface FeedbackUserService {

	public FeedbackUser feedbackUserById(Long feedBackUserId);

	public List<FeedbackUser> getAllFeedbackUsers();

	public FeedbackUser saveFeedbackUser(FeedbackUser feedbackUser);

	public FeedbackUser updateFeedbackUser(FeedbackUser feedbackUser);

	public String deleteFeedbackUser(Long feedBackUserId);

	public boolean validateFeedbackUser(FeedbackUser feedbackUser);

}
