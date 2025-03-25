package com.POC.Answer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.POC.Answer.Entity.FeedbackUser;


@FeignClient(name="User-Service",url = "http://localhost:8090")
public interface UserInterface {
	
	@GetMapping("api/feedbackusers/{feedbackUserId}")
	public FeedbackUser  getUserById(@PathVariable Long feedbackUserId);

}
