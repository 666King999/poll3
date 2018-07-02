package com.briup.apps.poll.dao.extend;

import com.briup.apps.poll.bean.extend.QuestionnaireVM;
/**
 * 问卷dao层编写
 * @author wanglu
 *
 */
public interface QuestionnaireVMMapper {
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	QuestionnaireVM selectById(long id);
}
