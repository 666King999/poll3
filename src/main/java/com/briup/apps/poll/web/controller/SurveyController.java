package com.briup.apps.poll.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.service.IAnswerService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/survey")
@Api(tags = "课调管理接口-Controller")
public class SurveyController extends BaseController{
	
	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswerService answerService;
	
	@ApiOperation("查看当前所有课调")
	@GetMapping("findAll")
	public MsgResponse list() {
		return success("成功！", surveyService.findAllWithModel());
	}
	
	@ApiOperation("添加课调时拿到所有相关信息")
	@GetMapping("getAllInfo")
	public MsgResponse getAllInfo() {
		return success(surveyService.findAllInfo());
	}
	
	
	@ApiOperation("添加课调")
	@GetMapping("add")
	public MsgResponse add(Survey survey) {
		return success(surveyService.findAllInfo());
	}
	
	@PutMapping("update")
	@ApiOperation("修改课调")
	public MsgResponse Update(Survey survey) {
		return success("修改 成功！", surveyService.update(survey));
	}
	
	@ApiOperation("删除课调")
	@GetMapping("delete")
	public MsgResponse delete(Long id) {
		return success(surveyService.findAllInfo());
	}
	
	@ApiOperation("批量删除")
	@GetMapping("batchDelete")
	@ApiImplicitParam(example="1-5-12")
	public MsgResponse batchDelete(String ids) {
		try {
			return success("批量删除成功",surveyService.batchDelete(ids));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@GetMapping("check")
	@ApiOperation("课调审核")
	public MsgResponse check(Long id) {
		try {
			return success(answerService.findAllBySurveyId(id));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@PostMapping("start")
	@ApiOperation("开启课调")
	public MsgResponse start(Long id) {
		return success("开启成功", surveyService.start(id));
	}
	
	@PostMapping("end")
	@ApiOperation("结束课调")
	public MsgResponse end(Long id) {
		return success("结束成功", surveyService.end(id));
	}
	
	@GetMapping("look")
	@ApiOperation("查看进度")
	public MsgResponse look(Long id) {
		return success(surveyService.look(id));
	}

}
