package com.POC.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.User.Entity.FeedbackUser;

@Repository
public interface FeedbackUserRepository extends JpaRepository<FeedbackUser,Long > {

	public FeedbackUser findByEmailId(String emailId);
}
