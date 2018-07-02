package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.OptionVM;

public interface OptionVMMapper {

	 List<OptionVM> selectAll();
	 OptionVM selectByPrimaryKey(Long id);
}
