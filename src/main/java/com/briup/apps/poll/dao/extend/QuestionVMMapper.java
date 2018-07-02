package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionVM;
/**
 * 题目dao层编写
 * @author wanglu
 *
 */
public interface QuestionVMMapper {
	/**
	 * 查询所有题目
	 * @return
	 */
	List<QuestionVM> selectAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	List<QuestionVM> selectByQuestionnaireId(long id);
}
