package com.POC.User.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POC.User.Entity.FeedbackUser;
import com.POC.User.Service.FeedbackUserService;

@RestController
@RequestMapping("/api/feedbackusers")
public class FeedbackUserController {

	@Autowired
	private FeedbackUserService userService;

	@GetMapping("/All")
	public List<FeedbackUser> allFeedbackUsers() {
		List<FeedbackUser> allUsers = userService.getAllFeedbackUsers();

		if (allUsers != null)
			return allUsers;
		else
			return Collections.emptyList();
	}
	
	@GetMapping("/{feedbackUserId}")
	public FeedbackUser  getUserById(@PathVariable Long feedbackUserId) {
		return userService.feedbackUserById(feedbackUserId);
	}
	

	@PostMapping("/saveuser")
	public FeedbackUser saveUser(@RequestBody FeedbackUser user) {
		return userService.saveFeedbackUser(user);
	}

	@PutMapping("/updateuser")
	public FeedbackUser updateFeedbackUser(@RequestBody FeedbackUser user) {
		return userService.updateFeedbackUser(user);
	}

	@DeleteMapping("/delete/{feedbackUserId}")
	public String deleteUser(@PathVariable Long feedbackUserId) {
		return userService.deleteFeedbackUser(feedbackUserId);
	}

	@GetMapping("/validation")
	public String validationUser(@RequestBody FeedbackUser user) {

		if (userService.validateFeedbackUser(user) == true) {
			return "Hi,  " + user.getFirstName();
		} else {
			return "Email ID and password do not match";
		}

	}
}
