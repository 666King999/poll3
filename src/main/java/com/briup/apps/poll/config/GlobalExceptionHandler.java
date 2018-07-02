package com.briup.apps.poll.config;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.apps.poll.util.MsgResponse;

/**
 * 全局异常捕获，统一处理
 * @author pibigstar
 *
 */

@ControllerAdvice // 注解定义全局异常处理类
public class GlobalExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 处理所有不可知异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	MsgResponse handleException(Exception e, HttpServletRequest request) throws Exception{
		log.info("请求地址：" + request.getRequestURL());
        //log.error("异常信息：",e);
        log.error("异常信息："+e.getMessage(),e);
        return MsgResponse.error(e.getMessage());
	}
	
}
