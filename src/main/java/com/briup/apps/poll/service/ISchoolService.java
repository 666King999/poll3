package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

public interface ISchoolService {
	List<School> findAll() throws Exception;
	
	School findById(long id) throws Exception;
	
	List<School> query(String keywords) throws Exception;
	
	void saveOrUpdate(School school) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void batchDelete(Long[] ids) throws Exception;
}
