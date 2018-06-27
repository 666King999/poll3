package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private ISchoolService schoolService;
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool() {
		try {
			List<School> list = schoolService.findAll();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			School list = schoolService.findById(id);
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findByKeywords")
	public MsgResponse query(String keywords) {
		try {
			List<School> list = schoolService.query(keywords);
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("saveSchool")
	public MsgResponse save(School school) {
		try {
			schoolService.saveOrUpdate(school);
			//返回成功信息
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateSchool")
	public MsgResponse Update(School school) {
		try {
			schoolService.saveOrUpdate(school);
			//返回成功信息
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("deleteSchoolById")
	public MsgResponse deleteById(long id) {
		try {
			schoolService.deleteById(id);
			//返回成功信息
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("batchDeleteSchool")
	public MsgResponse batchDelete(Long[] ids) {
		try {
			schoolService.batchDelete(ids);
			//返回成功信息
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
}
