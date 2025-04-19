package com.POC.Answer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.POC.Answer.DTO.UserDTO;


@FeignClient(name="User-Service",url = "http://localhost:8090")
public interface UserInterface {
	
	@GetMapping("api/feedbackusers/{feedbackUserId}")
	public UserDTO getUserById(@PathVariable Long feedbackUserId);

}
