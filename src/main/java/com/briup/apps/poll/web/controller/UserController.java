package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(tags="用户管理接口-Controller")
public class UserController extends BaseController{
	@Autowired
	private IUserService userService;
	@GetMapping("findAllUser")
	public MsgResponse findAllUser() {
		try {
			List<User> list = userService.findAll();
			//返回成功信息
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			User list = userService.findById(id);
			//返回成功信息
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@GetMapping("findByKeywords")
	public MsgResponse query(String keywords) {
		try {
			List<User> list = userService.query(keywords);
			//返回成功信息
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@PostMapping("saveUser")
	public MsgResponse save(User user) {
		try {
			userService.saveOrUpdate(user);
			//返回成功信息
			return success("success", user);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@PostMapping("updateUser")
	public MsgResponse Update(User user) {
		try {
			userService.saveOrUpdate(user);
			//返回成功信息
			return success("success", user);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@DeleteMapping("deleteUserById")
	public MsgResponse deleteById(long id) {
		try {
			userService.deleteById(id);
			//返回成功信息
			return success("success", id);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@DeleteMapping("batchDeleteUser")
	public MsgResponse batchDelete(Long[] ids) {
		try {
			userService.batchDelete(ids);
			//返回成功信息
			return success("success", ids);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
}
