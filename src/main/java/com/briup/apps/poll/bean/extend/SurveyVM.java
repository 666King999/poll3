package com.briup.apps.poll.bean.extend;

import java.io.Serializable;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.User;

public class SurveyVM implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String status;

	private String code;

	private String surveydate;
	
	private Grade grade;
	
	private User user;
	
	private Clazz clazz;
	
	private Questionnaire questionnaire;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSurveydate() {
		return surveydate;
	}

	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	

}
