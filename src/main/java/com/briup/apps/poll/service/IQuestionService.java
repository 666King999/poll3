package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;

/**
 * 题目信息的相关的service层接口
 * @author wanglu
 *
 */
public interface IQuestionService {

	
	/**
	 * 1，查询题目信息
	 * @return
	 * @throws Exception
	 */
	List<Question> findAll() throws Exception;
		
	/**
	 * 2，根据id查找题目信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Question findById(long id) throws Exception;
	
	/**
	 * 3，保存或修改题目信息
	 * @param question
	 * @throws Exception
	 */
	void saveOrUpdate(Question question) throws Exception;
		
	/**
	 * 4，根据关键词实现模糊查询题目信息
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	List<Question> query(String keyWord) throws Exception;
	
	/**
	 * 5，根据id删除题目信息	
	 * @param id
	 * @throws Exception
	 */
	void deleteById(long id) throws Exception;
	
	/**
	 * 6，通过id 对题目信息进行批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDelete(List<Long> ids) throws Exception;	
}
