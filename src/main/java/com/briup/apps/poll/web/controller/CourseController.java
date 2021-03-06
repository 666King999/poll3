package com.briup.apps.poll.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
@Api(tags="课程管理接口-Controller")
public class CourseController extends BaseController{

	@Autowired
	private ICourseService courseService;
	
	@ApiOperation("查询所有课程")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}	

	}

	@ApiOperation("通过id查找课程信息")
	@GetMapping("finById")
	public MsgResponse findById(long id) {
		try {
			Course course = courseService.findById(id);
			return success("success",course);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("添加或更新")
	@PostMapping("add")
	public MsgResponse saveOrUpdate(Course course) {
		try {
			courseService.saveOrUpdate(course);
			return success("success", course);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("模糊查询")
	@GetMapping("query")
	public MsgResponse query(String keyWord) {
		try {
			List<Course> list = courseService.query(keyWord);
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("根据id删除课程信息")
	@DeleteMapping("delete")
	public MsgResponse deletById(long id) {
		try {
			courseService.deleteById(id);
			return success("success", "");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("根据idList 批量删除课程信息")
	@DeleteMapping("batchDelete")
	public MsgResponse batchDelete(String ids) {
		try {
			String[] idArray = ids.split("-");
			List<Long> idList = new LinkedList<>();
			for(String str:idArray) {
				idList.add(Long.valueOf(str));
			}
			courseService.batchDelete(idList);
			return success("success","");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
}
