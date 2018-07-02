package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answer;

public interface IAnswerService {

	/**
	 * 查询全部答卷
	 * @return
	 */
	List<Answer> findAll();
	
	/**
	 * 根据课调id查询全部答卷
	 * @param id
	 * @return
	 */
	List<Answer> findAllBySurveyId(Long id) throws Exception;
	
	
}
