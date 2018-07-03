package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/school")
@Api(tags="学校管理接口-Controller")
public class SchoolController extends BaseController{
	@Autowired
	private ISchoolService schoolService;
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool() {
		try {
			List<School> list = schoolService.findAll();
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
			School list = schoolService.findById(id);
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
			List<School> list = schoolService.query(keywords);
			//返回成功信息
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@PostMapping("saveSchool")
	public MsgResponse save(School school) {
		try {
			schoolService.saveOrUpdate(school);
			//返回成功信息
			return success("success", school);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@PutMapping("updateSchool")
	public MsgResponse Update(School school) {
		try {
			schoolService.saveOrUpdate(school);
			//返回成功信息
			return success("success", school);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@DeleteMapping("deleteSchoolById")
	public MsgResponse deleteById(long id) {
		try {
			schoolService.deleteById(id);
			//返回成功信息
			return success("success", id);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
	@DeleteMapping("batchDeleteSchool")
	public MsgResponse batchDelete(Long[] ids) {
		try {
			schoolService.batchDelete(ids);
			//返回成功信息
			return success("success", ids);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			//返回失败信息
			return error(e.getMessage());
		}
	}
}
