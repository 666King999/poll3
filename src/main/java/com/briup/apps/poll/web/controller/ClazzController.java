package com.briup.apps.poll.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clazz")
@Api(tags="班级管理接口-Controller")
public class ClazzController extends BaseController{

	@Autowired
	private IClazzService clazzService;
	
	@ApiOperation("查询所有班级")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try {
			List<Clazz> list = clazzService.findAll();
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}	

	}

	@ApiOperation("通过id查找班级信息")
	@GetMapping("finById")
	public MsgResponse findById(long id) {
		try {
			Clazz course = clazzService.findById(id);
			return success("success",course);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("添加或更新")
	@PostMapping("add")
	public MsgResponse saveOrUpdate(Clazz course) {
		try {
			clazzService.saveOrUpdate(course);
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
			List<Clazz> list = clazzService.query(keyWord);
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("根据id删除班级信息")
	@DeleteMapping("delete")
	public MsgResponse deletById(long id) {
		try {
			clazzService.deleteById(id);
			return success("success", "");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("根据idList 批量删除班级信息")
	@DeleteMapping("batchDelete")
	public MsgResponse batchDelete(String ids) {
		try {
			String[] idArray = ids.split("-");
			List<Long> idList = new LinkedList<>();
			for(String str:idArray) {
				idList.add(Long.valueOf(str));
			}
			clazzService.batchDelete(idList);
			return success("success","");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有班级",notes="查询班级信息以及对应的年级与老师")
	@GetMapping("selectAllClazz")
	public MsgResponse selectAllClazz(){
		try {
			List<ClazzVM> list = clazzService.selectAll();
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}	

	}
	
	@ApiOperation(value="根据id查找班级",notes="查询班级信息以及对应的年级与老师")
	@GetMapping("selectById")
	public MsgResponse selectById(long id){
		try {
			ClazzVM clazzVM = clazzService.selectById(id);
			return success("success", clazzVM);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}	

	}
}
