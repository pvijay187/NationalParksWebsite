package com.techelevator.capstone.model.survey;

public class Survey {
	
	private Long id;
	private String favPark;
	private String email;
	private String state;
	private String activityLevel;
	public String getFavPark() {
		return favPark;
	}
	public void setFavPark(String favPark) {
		this.favPark = favPark;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long surveyId) {
		this.id = surveyId;
	}


}
