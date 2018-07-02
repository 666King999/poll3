package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Question;

public class OptionVM {

	    private Long id;	    
	    private String label;
	    private Integer score;
	    private String name;
	    private Question question;
		public Long getId() {
			return id;
		}
		public String getLabel() {
			return label;
		}
		public Integer getScore() {
			return score;
		}
		public String getName() {
			return name;
		}
		public Question getQuestion() {
			return question;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public void setScore(Integer score) {
			this.score = score;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setQuestion(Question question) {
			this.question = question;
		}
}
