package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 问卷controller层编写
 * @author wanglu
 *
 */
@Api(tags="问卷相关接口-Controller")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController extends BaseController{
	@Autowired
	private IQuestionnaireService qnService;
	
	@ApiOperation(value="批量删除问卷",notes="删除问卷的同时会把问卷和问题的关系解除掉，而问题保留")
	@PostMapping("batchDeleteQuestion")
	public MsgResponse batchDeleteQuestion(long[] ids){
		try {
			qnService.batchDelete(ids);
			return success("批量删除成功", null);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
		
	}
	@ApiOperation(value="根据ID删除问卷信息",
			notes="删除问卷的同时会把问卷和问题的关系解除掉，而问题保留")
	@GetMapping("deleteQuestionnaireById")
	public MsgResponse deleteQuestionnaireById(long id){
		try {
			qnService.deleteById(id);
			return success("删除成功", null);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或修改问卷信息",notes="如果问卷参数中包含id执行更新操作，否则执行修改操作")
	@PostMapping("saveOrUpdateQuestionnaire")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
		try {
			qnService.saveOrUpdate(questionnaire, questionIds);
			return success("保存或修改成功", null);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID查询问卷",notes="问卷下具有问题信息")
	@GetMapping("findQuestionnaireVMById")
	public MsgResponse findQuestionnaireVMById(long id){
		try {
			QuestionnaireVM qnVM = qnService.findById(id);
			// 返回成功信息
			return success("success", qnVM);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			// 返回失败信息
			return error(e.getMessage()) ;
		}
	}
	
	@ApiOperation(value="查询所有问卷",notes="单表")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = qnService.findAll();
			// 返回成功信息
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			// 返回失败信息
			return error(e.getMessage()) ;
		}
	}
}
