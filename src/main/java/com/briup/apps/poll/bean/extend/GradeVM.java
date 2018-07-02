package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.School;

public class GradeVM {

	private Long id;
	private String name;
    private String descriptioin;
    private School school;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescriptioin() {
		return descriptioin;
	}
	public School getSchool() {
		return school;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescriptioin(String descriptioin) {
		this.descriptioin = descriptioin;
	}
	public void setSchool(School school) {
		this.school = school;
	}
}
