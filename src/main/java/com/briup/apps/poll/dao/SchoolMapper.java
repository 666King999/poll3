package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    long countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);

    int deleteByPrimaryKey(Long id);

    int insert(School record);

    int insertSelective(School record);

    List<School> selectByExampleWithBLOBs(SchoolExample example);

    List<School> selectByExample(SchoolExample example);

    School selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExampleWithBLOBs(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKeyWithBLOBs(School record);

    int updateByPrimaryKey(School record);
}