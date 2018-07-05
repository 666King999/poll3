package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.bean.AnswerExample;
import com.briup.apps.poll.bean.AnswerExample.Criteria;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AnswerMapper {
    long countByExample(Criteria criteria);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    @Select("select count(*) from poll_answers where survey_id=#{id}")
	int countBySurveyId(Long id);

    @Select("select * from poll_answers where survey_id=#{id}")
	List<Answer> selectBySurveyId(Long id);
    
}