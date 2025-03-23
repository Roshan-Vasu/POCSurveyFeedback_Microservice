package com.POC.User.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POC.User.Entity.FeedbackUser;
import com.POC.User.Repository.FeedbackUserRepository;

@Service
public class FeedbackUserServiceImp implements FeedbackUserService {

	@Autowired
	private FeedbackUserRepository feedbackRepo;
	
	
	public FeedbackUser feedbackUserById(Long feedbackUserId) {
		return feedbackRepo.findById(feedbackUserId).orElse(null);
	}

	
	public List<FeedbackUser> getAllFeedbackUsers() {
		return feedbackRepo.findAll();
		
		//Java 8 
//		return feedbackRepo.findAll()
//				.stream()
//				.collect(Collectors.toList());
	}

	
	public FeedbackUser saveFeedbackUser(FeedbackUser saveFeedbackUser) {
		return feedbackRepo.save(saveFeedbackUser) ;
	}


	public FeedbackUser updateFeedbackUser(FeedbackUser feedbackUser) {	
		return feedbackRepo.save(feedbackUser);
	}

	
	public String deleteFeedbackUser(Long feedbackUserId) {
		
		if(feedbackRepo.existsById(feedbackUserId)) {
			feedbackRepo.deleteById(feedbackUserId);
			return "User deleted Successfully";
		} else {
			return "User not Found or User cannot delete";
		}
				
	}

	
	public boolean validateFeedbackUser(FeedbackUser feedbackUser) {
		
		FeedbackUser user = feedbackRepo.findByEmailId(feedbackUser.getEmailId());
	
		if (user != null) {
			if (user.getEmailId().equals(feedbackUser.getEmailId())
					&& user.getPassword().equals(feedbackUser.getPassword())) {
				return true;
			}
		} 
		return false;
		

	}
}
