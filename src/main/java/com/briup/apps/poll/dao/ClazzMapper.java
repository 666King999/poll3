package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClazzMapper {
    long countByExample(ClazzExample example);

    int deleteByExample(ClazzExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    List<Clazz> selectByExampleWithBLOBs(ClazzExample example);

    List<Clazz> selectByExample(ClazzExample example);

    Clazz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Clazz record, @Param("example") ClazzExample example);

    int updateByExampleWithBLOBs(@Param("record") Clazz record, @Param("example") ClazzExample example);

    int updateByExample(@Param("record") Clazz record, @Param("example") ClazzExample example);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKeyWithBLOBs(Clazz record);

    int updateByPrimaryKey(Clazz record);
}