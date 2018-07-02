package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
/**
 * 问卷service层接口编写
 * @author wanglu
 *
 */
public interface IQuestionnaireService {
	/*
	 * 查询所有问卷
	 */
	List<Questionnaire> findAll() throws Exception;
	
	QuestionnaireVM findById(long id) throws Exception;
	
	void saveOrUpdate(Questionnaire questionnaire , long[] questionIds) throws Exception;

	void deleteById(long id) throws Exception;
	
	void batchDelete(long[] ids) throws Exception;
}
