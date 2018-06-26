package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;

public interface IClazzService {

	public List<Clazz> findAll() throws Exception;
	
	public Clazz findById(long id) throws Exception;
	
	public void saveOrUpdate(Clazz clazz) throws Exception;
	
	public List<Clazz> query(String keyword) throws Exception;
	
	public void deleteById(long id) throws Exception;
	
	public void batchDelete(List<Long> ids) throws Exception;
}
