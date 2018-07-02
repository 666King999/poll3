package com.briup.apps.poll.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/question")
@Api(tags="题库管理接口-Controller")
public class QuestionController {

	//依赖注入
	@Autowired
	private IQuestionService questionService;
	
	//1，查询所有题目信息
	@ApiOperation("查询所有题目")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try {
			List<Question> list = questionService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	

	}

	//2，根据id查找题目信息
	@ApiOperation("通过id查找题目信息")
	@GetMapping("finById")
	public MsgResponse findById(long id) {
		try {
			Question question = questionService.findById(id);
			return MsgResponse.success("success",question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//3,保存或更新题目信息
	@ApiOperation("添加或更新题目信息")
	@PostMapping("add")
	public MsgResponse saveOrUpdate(Question question) {
		try {
			questionService.saveOrUpdate(question);
			return MsgResponse.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//4，根据关键词实现模糊查询题目信息
	@ApiOperation("模糊查询题目信息")
	@GetMapping("query")
	public MsgResponse query(String keyWord) {
		try {
			List<Question> list = questionService.query(keyWord);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//5，根据id删除题目信息
	@ApiOperation("根据id删除题目信息")
	@GetMapping("delete")
	public MsgResponse deletById(long id) {
		try {
			questionService.deleteById(id);
			return MsgResponse.success("success", "");
		} catch (Exception e) {			
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//6，通过id 对题目信息进行批量删除
	@ApiOperation("根据idList 批量删除题目信息")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(String ids) {
		try {
			String[] idArray = ids.split("-");
			List<Long> idList = new LinkedList<>();
			for(String str:idArray) {
				idList.add(Long.valueOf(str));
			}
			questionService.batchDelete(idList);
			return MsgResponse.success("success","");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
