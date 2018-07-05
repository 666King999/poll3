package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyAddModel;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	
	List<SurveyVM> findAllWithModel();
	
	/**
	 * 添加的时候，显示全部数据
	 * @return
	 */
	SurveyAddModel findAllInfo();
	
	/**
	 * 添加
	 * @param survey
	 */
	void addSurvey(Survey survey);
	/**
	 * 修改课调
	 * @param survey
	 * @return
	 */
	int update(Survey survey);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int batchDelete(String ids) throws Exception;

	/**
	 * 开启课调
	 * @param id
	 * @return
	 */
	int start(Long id);
	
	/**
	 * 结束课调
	 * @param id
	 * @return
	 */
	int end(Long id);
	
	/**
	 * 查看进度
	 * @param id
	 * @return
	 */
	double look(Long id);
	
}
