package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.extend.ClazzVM;

/**
 * @ClassName： IClazzService
 * @Description： TODO 班级模块相关接口
 * @author changqing
 *
 * Jun 26, 20187:28:18 PM
 */
public interface IClazzService {

	/**
	 * @Title: findById
	 * @Description: TODO 通过id单表查询所有班级
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Clazz> findAll() throws Exception;
	
	/**
	 * @Title: findById
	 * @Description: TODO 通过id单表查询班级
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Clazz findById(long id) throws Exception;
	
	/**
	 * @Title: saveOrUpdate
	 * @Description: TODO 添加或更新班级
	 * @param clazz
	 * @throws Exception
	 */
	public void saveOrUpdate(Clazz clazz) throws Exception;
	
	/**
	 * @Title: query
	 * @Description: TODO 通过关键词查询班级
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<Clazz> query(String keyword) throws Exception;
	
	/**
	 * @Title: deleteById
	 * @Description: TODO 通过id删除班级
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(long id) throws Exception;
	
	/**
	 * @Title: batchDelete
	 * @Description: TODO 通过id批量删除班级信息
	 * @param ids
	 * @throws Exception
	 */
	public void batchDelete(List<Long> ids) throws Exception;
	
	/**
	 * @Title: selectAll
	 * @Description: TODO 查询所有班级并携 相应的 年级与 班主任老师
	 * @return
	 */
	public List<ClazzVM> selectAll() throws Exception;
}
