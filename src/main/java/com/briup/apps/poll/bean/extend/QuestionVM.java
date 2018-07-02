package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Option;
/**
 * 题目实体类
 * @author wanglu
 *
 */
public class QuestionVM {
	private Long id;
	private String name;
	private String questionType;
	
	private List<Option> option;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}
	
}
