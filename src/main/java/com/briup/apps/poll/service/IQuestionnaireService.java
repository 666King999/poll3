package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;

/**
 * 问卷信息的相关的service层接口
 * @author wanglu
 *
 */
public interface IQuestionnaireService {

	/**
	 * 1，查询问卷信息
	 * @return
	 * @throws Exception
	 */
	List<Questionnaire> findAll() throws Exception;
		
	/**
	 *2，根据id查找问卷信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Questionnaire findById(long id) throws Exception;
	
	/**
	 * 3，保存或修改问卷信息 
	 * @param questionnaire
	 * @throws Exception
	 */
	void saveOrUpdate(Questionnaire questionnaire) throws Exception;
		
	/**
	 * 4，根据关键词实现模糊查询问卷信息
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	List<Questionnaire> query(String keyWord) throws Exception;
	
	/**
	 * 5，根据id删除问卷信息
	 * @param id
	 * @throws Exception
	 */
	void deleteById(long id) throws Exception;
	
	/**
	 * 6，通过id 对问卷信息进行批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDelete(List<Long> ids) throws Exception;	
}
