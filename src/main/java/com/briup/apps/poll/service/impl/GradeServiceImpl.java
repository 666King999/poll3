package com.briup.apps.poll.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.bean.GradeExample.Criteria;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.extend.GradeVMMapper;
import com.briup.apps.poll.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService{
   
	@Autowired
	private GradeMapper gradeMapper;
	
	@Autowired
	private GradeVMMapper gradeVMMapper;
	
	//查询所有Grade
	@Override
	public List<Grade> findAll() throws Exception {
		// TODO Auto-generated method stub
		return gradeMapper.selectByExampleWithBLOBs(null);
	}
	
    //根据id查Grade
	@Override
	public List<Grade> findById(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		List<Grade> list=new ArrayList<>();
		for(String id:ids)
			list.add(gradeMapper.selectByPrimaryKey(Long.valueOf(id)));
		return list;
	}
	
	/**
	 * 模糊查询
	 */
	@Override
	public List<Grade> query(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		GradeExample example = new GradeExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(keyWord);
		return gradeMapper.selectByExampleWithBLOBs(example);
	}
	
	//一对一查询所有Grade
	@Override
	public List<GradeVM> findAllVM() throws Exception {
		// TODO Auto-generated method stub
		return gradeVMMapper.selectAll();
	}
	
	//一对一根据id查询所有Grade
	@Override
	public List<GradeVM> findGradeVMById(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		List<GradeVM> list=new ArrayList<>();
		for(String id:ids)
			list.add(gradeVMMapper.selectByPrimaryKey(Long.valueOf(id)));
		return list;
	}
	
	@Override
	public void deleteById(List<String> ids) throws Exception {
		// TODO Auto-generated method stub
		for(String id:ids)
			gradeMapper.deleteByPrimaryKey(Long.valueOf(id));
	}

	@Override
	public void insertOrupdate(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		if(grade.getId()==null)
			gradeMapper.insert(grade);
		else gradeMapper.updateByPrimaryKey(grade);
	}
	
}
