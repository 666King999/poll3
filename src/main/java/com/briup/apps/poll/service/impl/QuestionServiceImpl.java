package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.QuestionExample.Criteria;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.service.IQuestionService;

/**
 * 题目service层实现类
 * @author wanglu
 *
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

	//依赖注入
	@Autowired
	private QuestionMapper questionMapper;
	
	//1，查询所有题目信息
	@Override
	public List<Question> findAll() throws Exception {
		return questionMapper.selectByExample(null);
	}

	//2，根据id查找题目信息
	@Override
	public Question findById(long id) throws Exception {
		return questionMapper.selectByPrimaryKey(id);
	}

	//3,保存或更新题目信息
	@Override
	public void saveOrUpdate(Question question) throws Exception {
		// TODO 判断传入的question的id是否为空，若为空执行插入，否则更新
		if(question.getId()==null) {
			questionMapper.insert(question);
		}else {
			questionMapper.updateByPrimaryKey(question);
		}
	}

	//4，根据关键词实现模糊查询题目信息
	@Override
	public List<Question> query(String keyWord) throws Exception {
		QuestionExample example = new QuestionExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(keyWord);
		return questionMapper.selectByExample(example);
	}

	//5，根据id删除题目信息
	@Override
	public void deleteById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
	}

	//6，通过id 对题目信息进行批量删除
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids) {
			questionMapper.deleteByPrimaryKey(id);
		}
	}


}
