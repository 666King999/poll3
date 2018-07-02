package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SurveyMapper {
    long countByExample(SurveyExample example);

    int deleteByExample(SurveyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Survey record);

    int insertSelective(Survey record);

    List<Survey> selectByExample(SurveyExample example);

    Survey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByExample(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);
    
    @Update("update poll_survey set status=1 where id=#{id}")
    int startBySurveyId(Long id);
    
    @Update("update poll_survey set status=0 where id=#{id}")
    int endBySurveyId(Long id);
    
}