package com.briup.apps.poll.bean;

public class Answer {
    private Long id;

    private String selections;

    private String checkes;

    private String content;

    private Long surveyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections == null ? null : selections.trim();
    }

    public String getCheckes() {
        return checkes;
    }

    public void setCheckes(String checkes) {
        this.checkes = checkes == null ? null : checkes.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
}