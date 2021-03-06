package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Option;
import com.briup.apps.poll.bean.OptionExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;
/**
 * 题目service层编写
 * @author wanglu
 *
 */
@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionMapper optionMapper;
	
	/**
	 * 查询所有题目
	 */
	@Override
	public List<Question> findAll() throws Exception {
		QuestionExample example = new QuestionExample();
		return questionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.selectAll();
	}

	/**
	 * 保存或修改问题（包含选项）
	 * */
	@Override
	public void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception {
		//1. 分离questionVM,从中获取到Question Option
		List<Option> option = questionVM.getOptions();
		Question question = new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		
		//question 问题对象，option 所有问题的选项
		//2. 判断保存还是修改
		if(question.getId() == null){
			//2.1 保存
			if(question.getQuestiontype().equals("简答题")){
				//2.1.1 保存简答题，只需要保存题目相关信息
				questionMapper.insert(question);
			} else {
				//2.1.2 保存单选和多选题的时候需要先保存题目信息，再保存选项信息
				questionMapper.insert(question);
				//如何获取刚刚插入到问题的ID
				long questionId = question.getId();
				for(Option op : option){
					//为每个option设置question_id
					op.setQuestionId(questionId);
					//保存选项
					optionMapper.insert(op);
				}
			}
		} else {
			//2.2 修改
			//2.2.1 修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.2.2 修改选项信息（添加新选项，删除旧选项，对原来选项修改）
			//1. 删除该题目原有的选项
			OptionExample example = new OptionExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionMapper.deleteByExample(example);
			//2. 重新添加选项
			long questionId = question.getId();
			for(Option op : option){
				//为每个option设置question_id
				op.setQuestionId(questionId);
				//保存选项
				optionMapper.insert(op);
			}
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
		
	}

	/**
	 * 批量删除
	 */
	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids) {
			questionMapper.deleteByPrimaryKey(id);
		}
	}

}

















