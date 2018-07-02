package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.User;

/**
 * 添加课调模型
 * @author pibigstar
 *
 */
public class SurveyAddModel {

	private List<Grade> grades;
	
	private List<Clazz> clazzs;
	
	private List<Course> courses;
	
	private List<User> users;
	
	private List<Questionnaire> questionnaires;

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	
}
