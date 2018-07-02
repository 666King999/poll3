package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.Option;
import com.briup.apps.poll.bean.extend.OptionVM;

public interface IOptionService {

	/**
	 * 查询所有选项
	 * @return
	 * @throws Exception
	 */
	List<Option> findAll() throws Exception;
	
	
	List<Option> findById(List<String> ids) throws Exception;
	/**
	 * 查询选项及其关联信息
	 */
     List<OptionVM> findAllVM() throws Exception;
	
     List<OptionVM> findOptionVMById(List<String> ids) throws Exception;
     
     /**
 	 * @Title: query
 	 * @Description: TODO 根据关键词模糊查询
 	 * @param keyWord
 	 * @return
 	 * @throws Exception
 	 */
 	List<Option> query(String keyWord) throws Exception;
 	
	/**
	 * 根据id删除选项
	 * @param ids
	 * @throws Exception
	 */
	void deleteById(List<String> ids) throws Exception;
	
    /**
     * 更新或删除
     * @param options
     * @throws Exception
     */
    void insertOrupdate(Option option) throws Exception;
}
