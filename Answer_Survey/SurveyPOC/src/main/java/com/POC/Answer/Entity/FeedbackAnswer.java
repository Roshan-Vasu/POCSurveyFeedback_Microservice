package com.POC.Answer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class FeedbackAnswer {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Long  surveyAnswerId;
		@NotNull
		private String comments;
		@NotBlank
		@Min(1)
		@Max(5)
		private Integer rating;
		@NotBlank
		private Long surveyQuestionId;
		@NotBlank
		private Long feedbackUserId;
		
		
		
		
		public FeedbackAnswer() {
			super();
		}
		
		public FeedbackAnswer(Long surveyAnswerId, @NotNull String comments, @NotBlank Integer rating,
				@NotBlank Long surveyQuestionId, @NotBlank Long feedbackUserId) {
			super();
			this.surveyAnswerId = surveyAnswerId;
			this.comments = comments;
			this.rating = rating;
			this.surveyQuestionId = surveyQuestionId;
			this.feedbackUserId = feedbackUserId;
		}
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
