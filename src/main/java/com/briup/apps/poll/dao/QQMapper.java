package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.QQ;
import com.briup.apps.poll.bean.QQExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QQMapper {
    long countByExample(QQExample example);

    int deleteByExample(QQExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QQ record);

    int insertSelective(QQ record);

    List<QQ> selectByExample(QQExample example);

    QQ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QQ record, @Param("example") QQExample example);

    int updateByExample(@Param("record") QQ record, @Param("example") QQExample example);

    int updateByPrimaryKeySelective(QQ record);

    int updateByPrimaryKey(QQ record);
}