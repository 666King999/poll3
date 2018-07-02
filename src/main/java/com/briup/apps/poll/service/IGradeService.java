package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;

public interface IGradeService {

	/**
	 * 查询所有课程
	 * @return
	 * @throws Exception
	 */
	
	List<Grade> findAll() throws Exception;
	
	List<Grade> findById(List<String> ids) throws Exception;
	
	/**
	 * 查询课程及相关信息
	 * 
	 * @throws Exception
	 */
	
	List<GradeVM> findAllVM() throws Exception;
	
	List<GradeVM> findGradeVMById(List<String> ids) throws Exception;
	/**
	 * @Title: query
	 * @Description: TODO 根据关键词模糊查询
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	List<Grade> query(String keyWord) throws Exception;
	
	/**
	 * 删除课程
	 * @param id
	 * @throws Exception
	 */
	void deleteById(List<String> ids) throws Exception;
	
	/**
	 * 
	 * @param grade
	 * @throws Exception
	 */
	void insertOrupdate(Grade grade) throws Exception;
}
