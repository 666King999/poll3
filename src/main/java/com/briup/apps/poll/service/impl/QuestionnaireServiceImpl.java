package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireExample.Criteria;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.service.IQuestionnaireService;
/**
 * 问卷service层实现类
 * @author wanglu
 *
 */
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	//依赖注入
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	//1，查询所有问卷信息
	@Override
	public List<Questionnaire> findAll() throws Exception {
		return questionnaireMapper.selectByExampleWithBLOBs(null);
	}

	//2，根据id查找问卷信息
	@Override
	public Questionnaire findById(long id) throws Exception {
		return questionnaireMapper.selectByPrimaryKey(id);
	}

	//3,保存或更新问卷信息
	@Override
	public void saveOrUpdate(Questionnaire questionnaire) throws Exception {
		if(questionnaire.getId()==null) {
			questionnaireMapper.insert(questionnaire);
		}else {
			questionnaireMapper.updateByPrimaryKey(questionnaire);
		}
	}

	//4，根据关键词实现模糊查询问卷信息
	@Override
	public List<Questionnaire> query(String keyWord) throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(keyWord);
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}
	//5，根据id删除问卷信息
	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapper.deleteByPrimaryKey(id);
	}
	
	//6，通过id 对问卷信息进行批量删除
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids) {
			questionnaireMapper.deleteByPrimaryKey(id);
		}
	}


}
