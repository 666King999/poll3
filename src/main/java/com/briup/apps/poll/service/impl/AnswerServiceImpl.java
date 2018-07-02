package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.AnswerExample;
import com.briup.apps.poll.bean.AnswerExample.Criteria;
import com.briup.apps.poll.dao.AnswerMapper;
import com.briup.apps.poll.service.IAnswerService;

@Service
public class AnswerServiceImpl implements IAnswerService{

	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public List<Answer> findAll() {
		return answerMapper.selectByExample(null);
	}

	@Override
	public List<Answer> findAllBySurveyId(Long id) {
		AnswerExample example = new AnswerExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andSurveyIdEqualTo(id);
		return answerMapper.selectByExample(example);
	}

}
