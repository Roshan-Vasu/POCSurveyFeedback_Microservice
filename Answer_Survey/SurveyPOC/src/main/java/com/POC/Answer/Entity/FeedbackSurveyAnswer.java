package com.POC.Answer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class FeedbackSurveyAnswer {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long  surveyAnswerId;
		private String comments;
		private Integer rating;
		private Long surveyQuestionId;	
		private Long feedbackUserId;
		public Long getSurveyAnswerId() {
			return surveyAnswerId;
		}
		public void setSurveyAnswerId(Long surveyAnswerId) {
			this.surveyAnswerId = surveyAnswerId;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public Integer getRating() {
			return rating;
		}
		public void setRating(Integer rating) {
			this.rating = rating;
		}
		public Long getSurveyQuestionId() {
			return surveyQuestionId;
		}
		public void setSurveyQuestionId(Long surveyQuestionId) {
			this.surveyQuestionId = surveyQuestionId;
		}
		public Long getFeedbackUserId() {
			return feedbackUserId;
		}
		public void setFeedbackUserId(Long feedbackUserId) {
			this.feedbackUserId = feedbackUserId;
		}
		
		
}
