package com.briup.apps.poll.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.briup.apps.poll.bean.extend.SurveyVM;

public interface SurveyVMMapper {
	
	
	@Select("select * from poll_survey")
	@Results({
		@Result(property="user",column="user_id",one=@One(select="com.briup.apps.poll.dao.UserMapper.selectByPrimaryKey")),
		@Result(property="clazz",column="clazz_id",one=@One(select="com.briup.apps.poll.dao.ClazzMapper.selectByPrimaryKey")),
		@Result(property="questionnaire",column="questionnaire_id",one=@One(select="com.briup.apps.poll.dao.QuestionnaireMapper.selectByPrimaryKey"))
	})
	List<SurveyVM> findAllWithModel();

	
	
	@Select("select * from poll_survey")
	List<SurveyVM> findAllInfo();

}
