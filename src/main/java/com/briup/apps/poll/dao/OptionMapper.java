package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Option;
import com.briup.apps.poll.bean.OptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionMapper {
    long countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Option record);

    int insertSelective(Option record);

    List<Option> selectByExampleWithBLOBs(OptionExample example);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExampleWithBLOBs(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKeyWithBLOBs(Option record);

    int updateByPrimaryKey(Option record);
}