package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.extend.SurveyAddModel;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.AnswerMapper;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService{

	@Autowired
	private SurveyVMMapper surveyModelMapper;
	@Autowired
	private SurveyMapper surveyMapper;
	
	@Autowired
	private AnswerMapper answerMapper;
	
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	
	
	@Override
	public List<SurveyVM> findAllWithModel() {
		return surveyModelMapper.findAllWithModel();
	}

	@Override
	public SurveyAddModel findAllInfo() {
		List<Grade> grades = gradeMapper.selectByExample(null);
		List<Clazz> clazzs = clazzMapper.selectByExample(null);
		List<User> users = userMapper.selectByExample(null);
		List<Questionnaire> questionnaires = questionnaireMapper.selectByExample(null);
		List<Course> courses = courseMapper.selectByExample(null);
		SurveyAddModel surveyAddModel = new SurveyAddModel();
		surveyAddModel.setClazzs(clazzs);
		surveyAddModel.setGrades(grades);
		surveyAddModel.setCourses(courses);
		surveyAddModel.setUsers(users);
		surveyAddModel.setQuestionnaires(questionnaires);
		return surveyAddModel;
	}

	@Override
	public void addSurvey(Survey survey) {
		surveyMapper.insert(survey);
	}

	@Override
	public int batchDelete(String ids) throws Exception{
		String[] split = ids.split("-");
		int i = 0;
		for (String id : split) {
			i+=surveyMapper.deleteByPrimaryKey(Long.parseLong(id));
		}
		return i;
	}

	@Override
	public int delete(Long id) {
		return surveyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int start(Long id) {
		
		return surveyMapper.startBySurveyId(id);
	}

	@Override
	public int end(Long id) {
		
		return surveyMapper.endBySurveyId(id);
	}

	@Override
	public int update(Survey survey) {

		return surveyMapper.updateByPrimaryKey(survey);
	}

	@Override
	public double look(Long id) {
		Survey survey = surveyMapper.selectByPrimaryKey(id);
		List<Answer> answers = answerMapper.selectBySurveyId(survey.getId());
		int sum = 0;
		for (Answer answer : answers) {
			String[] selectStr = answer.getSelections().split("|");
			String[] checkStr = answer.getSelections().split("|");
			for (String string : checkStr) {
				if (string.equals("|")) {
					continue;
				}
				sum+=Integer.parseInt(string);
			}
			for (String string : selectStr) {
				if (string.equals("|")) {
					continue;
				}
				sum+=Integer.parseInt(string);
			}
		}
		
		return sum/answers.size();
	}
	
}
