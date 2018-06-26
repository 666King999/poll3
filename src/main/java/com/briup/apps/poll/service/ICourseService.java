package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;


/**
 * @ClassName： ICourseService
 * @Description： TODO 课程信息管理相关接口
 * @author changqing
 *
 * Jun 26, 20189:32:00 AM
 */
public interface ICourseService {

	
	/**
	 * @Title: findAll
	 * @Description: TODO 查询所有课程
	 * @return
	 * @throws Exception
	 */
	List<Course> findAll() throws Exception;
		
	/**
	 * @Title: findById
	 * @Description: TODO 通过id查找课程
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Course findById(long id) throws Exception;
	
	/**
	 * @Title: saveOrUpdate
	 * @Description: TODO 添加或更新课程
	 * @param course
	 * @throws Exception
	 */
	void saveOrUpdate(Course course) throws Exception;
		
	/**
	 * @Title: query
	 * @Description: TODO 根据关键词模糊查询
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	List<Course> query(String keyWord) throws Exception;
	
	/**
	 * @Title: deleteById
	 * @Description: TODO 通过id删除
	 * @param id
	 * @throws Exception
	 */
	void deleteById(long id) throws Exception;
	
	/**
	 * @Title: batchDelete
	 * @Description: TODO 通过id List列表批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDelete(List<Long> ids) throws Exception;	
}
