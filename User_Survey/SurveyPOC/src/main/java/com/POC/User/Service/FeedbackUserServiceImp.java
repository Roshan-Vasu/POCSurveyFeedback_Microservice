package com.POC.User.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POC.User.DTO.UserDTO;
import com.POC.User.Entity.FeedbackUser;
import com.POC.User.Exception.DuplicateResources;
import com.POC.User.Exception.ResourceNotFoundException;
import com.POC.User.Repository.FeedbackUserRepository;

@Service
public class FeedbackUserServiceImp implements FeedbackUserService {


	@Autowired
	private FeedbackUserRepository feedbackRepo;
	
	
	private UserDTO entityToDTO (FeedbackUser user) {
		
		UserDTO dto = new UserDTO();
		
		dto.setUserName(user.getUserName());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmailId(user.getEmailId());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setRole(user.getRole());
		dto.setTeamName(user.getTeamName());
		
		return dto;
	}
	
	
	private FeedbackUser DTOtoEntity (UserDTO userdto) {
		
		FeedbackUser users = new FeedbackUser();
		
		users.setUserName(userdto.getUserName());
		users.setFirstName(userdto.getFirstName());
		users.setLastName(userdto.getLastName());
		users.setEmailId(userdto.getEmailId());
		users.setPhoneNumber(userdto.getPhoneNumber());
		users.setRole(userdto.getRole());
		users.setTeamName(userdto.getTeamName());
		
		return users;
	}
	
	
	public UserDTO feedbackUserById(Long feedbackUserId) {
		FeedbackUser user = feedbackRepo.findById(feedbackUserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + feedbackUserId));
		return entityToDTO(user);
	}

	
	public List<UserDTO> getAllFeedbackUsers() {
		
		List <FeedbackUser> allUsers = feedbackRepo.findAll();
		
		if(allUsers.isEmpty()) {
			  throw new ResourceNotFoundException("No Users found");
		}
		
		
		List<UserDTO> dtos = new ArrayList<>();
		
		for (FeedbackUser user : allUsers) {
		    UserDTO userDTO = new UserDTO();
		    userDTO.setUserName(user.getUserName());
		    userDTO.setFirstName(user.getFirstName());
		    userDTO.setLastName(user.getLastName());
		    userDTO.setEmailId(user.getEmailId());
		    userDTO.setPhoneNumber(user.getPhoneNumber());
		    userDTO.setRole(user.getRole());
		    userDTO.setTeamName(user.getTeamName());
		    dtos.add(userDTO);
		}

		return dtos;
		
	}

	
	public UserDTO saveFeedbackUser(UserDTO userDTO) {
		
		FeedbackUser saveFeedbackUser = DTOtoEntity(userDTO);
		
		if(feedbackRepo.existsByUserName(saveFeedbackUser.getUserName())) {
			throw new DuplicateResources("UserName is alreaday exists");
		}
		
		if(feedbackRepo.existsByEmailId(saveFeedbackUser.getEmailId())) {
			throw new DuplicateResources("Email ID is alreaday exists");
		}
		
		if(feedbackRepo.existsByPhoneNumber(saveFeedbackUser.getPhoneNumber())) {
			throw new DuplicateResources("Phone Numnber is alreaday exists");
		}
		
		FeedbackUser savedUser = feedbackRepo.save(saveFeedbackUser) ;
		
		return entityToDTO(savedUser);
	}


	public UserDTO updateFeedbackUser(UserDTO userDTO) {	
		
		FeedbackUser getExistUser = feedbackRepo.findByEmailId(userDTO.getEmailId())
				.orElseThrow(()-> new ResourceNotFoundException("User with email " + userDTO.getEmailId()+ " not found"));
		
		getExistUser.setFirstName(userDTO.getFirstName());
		getExistUser.setLastName(userDTO.getLastName());
		getExistUser.setPhoneNumber(userDTO.getPhoneNumber());
		getExistUser.setRole(userDTO.getRole());
		getExistUser.setTeamName(userDTO.getTeamName());
		
		FeedbackUser feedbackUser = feedbackRepo.save(getExistUser);
		return entityToDTO(feedbackUser);
		
		
	}

	
	public String deleteFeedbackUser(String feedbackUserEmailID) {
		
		FeedbackUser getExistUser = feedbackRepo.findByEmailId(feedbackUserEmailID)
				.orElseThrow(()-> new ResourceNotFoundException("User with email " + feedbackUserEmailID + " not found"));
		
		feedbackRepo.deleteById(getExistUser.getFeedbackUserId());
		
		return feedbackUserEmailID + "Successfully Deleted";
			
			
				
	}
	
	
	
	


	@Override
	public boolean validateFeedbackUser(FeedbackUser feedbackUser) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public UserDTO existsByEmailId(String feedbackUserEmailID) {
		
		FeedbackUser user = feedbackRepo.findByEmailId(feedbackUserEmailID)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Email ID: " + feedbackUserEmailID));
		return entityToDTO(user);
		
		
	}

	
//	public boolean validateFeedbackUser(FeedbackUser feedbackUser) {
//		
//		FeedbackUser user = feedbackRepo.findByEmailId(feedbackUser.getEmailId());
//	
//		if (user != null) {
//			if (user.getEmailId().equals(feedbackUser.getEmailId())
//					&& user.getPassword().equals(feedbackUser.getPassword())) {
//				return true;
//			}
//		} 
//		return false;
//		
//
//	}
}
