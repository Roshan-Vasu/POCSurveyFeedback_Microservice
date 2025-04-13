package com.POC.User.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.User.Entity.FeedbackUser;

@Repository
public interface FeedbackUserRepository extends JpaRepository<FeedbackUser,Long > {

	public Optional<FeedbackUser> findByEmailId(String emailId);
	
	boolean existsByEmailId(String emailid);
	
	boolean existsByUserName(String userName);
	
	boolean existsByPhoneNumber(String phoneNumber);
	
	
}
