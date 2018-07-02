package com.briup.apps.poll.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Option;
import com.briup.apps.poll.bean.OptionExample;
import com.briup.apps.poll.bean.OptionExample.Criteria;
import com.briup.apps.poll.bean.extend.OptionVM;
import com.briup.apps.poll.dao.OptionMapper;
import com.briup.apps.poll.dao.extend.OptionVMMapper;
import com.briup.apps.poll.service.IOptionService;

@Service
public class OptionServiceImpl implements IOptionService{

	@Autowired
	private OptionMapper optionMapper;
	@Autowired
	private OptionVMMapper optionVMMapper;
	@Override
	public List<Option> findAll() throws Exception {
		// TODO Auto-generated method stub
		return optionMapper.selectByExampleWithBLOBs(null);
	}
    
	@Override
	public List<Option> findById(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		List<Option> list=new ArrayList<>();
		for(String id:ids)
			list.add(optionMapper.selectByPrimaryKey(Long.valueOf(id)));
		return list;
	}
	
	 /**
     * 
     */
	@Override
	public List<Option> query(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		OptionExample example = new OptionExample();
		Criteria criteria = example.createCriteria();
		criteria.andLabelLike(keyWord);
		return optionMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public List<OptionVM> findAllVM() throws Exception {
		// TODO Auto-generated method stub
		return optionVMMapper.selectAll();
	}
  
	@Override
	public List<OptionVM> findOptionVMById(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		List<OptionVM> list=new ArrayList<>();
		for(String id:ids)
			list.add(optionVMMapper.selectByPrimaryKey(Long.valueOf(id)));
		return list;
	}
	@Override
	public void deleteById(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		for(String id:ids)
			optionMapper.deleteByPrimaryKey(Long.valueOf(id));
	}

	@Override
	public void insertOrupdate(Option option) throws Exception {
		// TODO Auto-generated method stub
		if(option.getId()==null)
			optionMapper.insert(option);
		else optionMapper.updateByPrimaryKey(option);
	}
	
}
