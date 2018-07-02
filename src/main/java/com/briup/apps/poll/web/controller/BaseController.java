package com.briup.apps.poll.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.util.MsgResponse;

@RestController
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	
	/**
	 * 返回信息封装
	 * @param msg
	 * @param data
	 * @return
	 */
	protected MsgResponse success(String msg,Object data) {
		return MsgResponse.success(msg, data);
	}
	protected MsgResponse success(Object data) {
		return MsgResponse.success(data);
	}
	protected MsgResponse error(String msg) {
		return MsgResponse.error(msg);
	}
	
	
}
