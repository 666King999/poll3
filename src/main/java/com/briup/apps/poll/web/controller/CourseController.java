package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ICourseService courseService;
	
	@ApiOperation("查询所有课程")
	@GetMapping("/findAllCourse")
	public MsgResponse findAllCourses(){
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// 返回失败信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
}
