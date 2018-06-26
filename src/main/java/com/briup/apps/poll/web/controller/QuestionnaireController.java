package com.briup.apps.poll.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	//依赖注入
	@Autowired
	private IQuestionnaireService questionnaireService;
	
	//1，查询所有问卷信息
	@ApiOperation("查询所有问卷")
	@GetMapping("/findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	

	}

	//2，根据id查找问卷信息
	@ApiOperation("通过id查找问卷信息")
	@GetMapping("/finById")
	public MsgResponse findById(long id) {
		try {
			Questionnaire questionnaire = questionnaireService.findById(id);
			return MsgResponse.success("success",questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//3,保存或更新问卷信息
	@ApiOperation("添加或更新")
	@PostMapping("/add")
	public MsgResponse saveOrUpdate(Questionnaire questionnaire) {
		try {
			questionnaireService.saveOrUpdate(questionnaire);
			return MsgResponse.success("success", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//4，根据关键词实现模糊查询问卷信息
	@ApiOperation("模糊查询")
	@GetMapping("/query")
	public MsgResponse query(String keyWord) {
		try {
			List<Questionnaire> list = questionnaireService.query(keyWord);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//5，根据id删除问卷信息
	@ApiOperation("根据id删除问卷信息")
	@GetMapping("/delete")
	public MsgResponse deletById(long id) {
		try {
			questionnaireService.deleteById(id);
			return MsgResponse.success("success", "");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//6，通过id 对问卷信息进行批量删除
	@ApiOperation("根据idList 批量删除问卷信息")
	@GetMapping("/batchDelete")
	public MsgResponse batchDelete(String ids) {
		try {
			String[] idArray = ids.split("-");
			List<Long> idList = new LinkedList<>();
			for(String str:idArray) {
				idList.add(Long.valueOf(str));
			}
			questionnaireService.batchDelete(idList);
			return MsgResponse.success("success","");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
