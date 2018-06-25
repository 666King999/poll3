package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.bean.CourseExample.Criteria;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.ICourseService;

@Service
public class CouseServiceImpl implements ICourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Course> findAll() throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public Course findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(Course course) throws Exception {
		// TODO Auto-generated method stub
		if(course.getId()==null) {
			courseMapper.insert(course);
		}else {
			courseMapper.updateByPrimaryKey(course);
		}
	}

	@Override
	public List<Course> query(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		CourseExample example = new CourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(keyWord);
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		courseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids) {
			courseMapper.deleteByPrimaryKey(id);
		}
	}


}
