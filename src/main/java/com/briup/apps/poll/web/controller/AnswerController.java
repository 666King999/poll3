package com.briup.apps.poll.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.service.IAnswerService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController 
@RequestMapping("/answer")
@Api(tags="答卷相关接口-Controller")
public class AnswerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAnswerService answerService;
	
	@GetMapping("list")
	@ApiOperation("查询全部答卷")
	public MsgResponse list() {
		return MsgResponse.success(answerService.findAll());
	}
	
	@GetMapping("get")
	@ApiOperation("根据课调id查询全部答卷")
	public MsgResponse get(Long id) {
		try {
			return MsgResponse.success(answerService.findAllBySurveyId(id));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
