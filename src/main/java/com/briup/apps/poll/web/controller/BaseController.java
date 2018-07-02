package com.briup.apps.poll.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.util.MsgResponse;

@RestController
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
