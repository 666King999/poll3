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
		// TODO 查询所有课程
		return courseMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public Course findById(long id) throws Exception {
		// TODO 通过id查找
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(Course course) throws Exception {
		// TODO 判断传入的course的id是否为空，若为空执行插入，否则更新
		if(course.getId()==null) {
			courseMapper.insert(course);
		}else {
			courseMapper.updateByPrimaryKey(course);
		}
	}

	@Override
	public List<Course> query(String keyWord) throws Exception {
		// TODO 按name模糊查询
		CourseExample example = new CourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(keyWord);
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO 通过id删除
		courseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO 通过id List列表批量删除
		for(long id:ids) {
			courseMapper.deleteByPrimaryKey(id);
		}
	}


}
