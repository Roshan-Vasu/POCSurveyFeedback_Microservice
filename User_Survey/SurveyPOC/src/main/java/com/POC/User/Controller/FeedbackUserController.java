package com.POC.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.POC.User.DTO.UserDTO;
import com.POC.User.Service.FeedbackUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feedbackusers")
public class FeedbackUserController {

	@Autowired
	private FeedbackUserService userService;

	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> allFeedbackUsers() {
		List<UserDTO> allusers = userService.getAllFeedbackUsers();
		return new ResponseEntity<>(allusers, HttpStatus.OK);
	}
	
	@GetMapping("/{feedbackUserId}")
	public ResponseEntity<UserDTO>  getUserById(@PathVariable Long feedbackUserId) {
		
		return new ResponseEntity<>(userService.feedbackUserById(feedbackUserId),HttpStatus.OK); 
		
		
		//return userService.feedbackUserById(feedbackUserId);
	}
	

	@PostMapping("/saveuser")
	public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDTO) {
		
		UserDTO savedUserDTO = userService.saveFeedbackUser(userDTO);
		
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

	@PutMapping("/updateuser")
	public ResponseEntity<UserDTO> updateFeedbackUser(@RequestBody @Valid UserDTO userDTO) {
		
		UserDTO updateUser = userService.updateFeedbackUser(userDTO);
		
		return new ResponseEntity<UserDTO>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{feedbackUserEmailID}")
	public String deleteUser(@PathVariable String feedbackUserEmailID) {
		return userService.deleteFeedbackUser(feedbackUserEmailID);
			
	}
	
	@GetMapping("/usermail/{feedbackUserEmailID}")
	public ResponseEntity<UserDTO> getUserByEmailID(@PathVariable String feedbackUserEmailID){
		
		UserDTO user = userService.existsByEmailId(feedbackUserEmailID);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}

//	@GetMapping("/validation")
//	public String validationUser(@RequestBody FeedbackUser user) {
//
//		if (userService.validateFeedbackUser(user) == true) {
//			return "Hi,  " + user.getFirstName();
//		} else {
//			return "Email ID and password do not match";
//		}
//
//	}
}
