package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="年级相关接口-Controller")
@RestController
@RequestMapping("/grade")
public class GradeController extends BaseController{

	@Autowired
	private IGradeService gradeService;

	/**
	 * 模糊查询
	 * @param keyWord
	 * @return
	 */
	@ApiOperation("模糊查询")
	@GetMapping("query")
	public MsgResponse query(String keyWord) {
		try {
			List<Grade> list = gradeService.query(keyWord);
			return success("success", list);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}

	/**
	 * 
	 * @return
	 */
	@ApiOperation("查询所有年级")
	@GetMapping("findAllVM")
	public MsgResponse findAllVM(){
		List<GradeVM> list=new ArrayList<>();
		try {
			list=gradeService.findAllVM();
			return success("操作成功", list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return  error(e.getMessage());
		}

	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id查询年级")
	@GetMapping("findGradeById")
	public MsgResponse findGradeById(@RequestParam(value="id")String id){  
		List<GradeVM> list=new ArrayList<>();
		String str[]=id.split(",");
		List<String> ids=new ArrayList<String>();
		for(int i=0;i<str.length;i++){
			ids.add(str[i]);
		}
		try {
			list=gradeService.findGradeVMById(ids);
			return success("操作成功", list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return  error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id删除年级")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam(value="id")String id){  
		String str[]=id.split(",");
		List<String> ids=new ArrayList<String>();
		for(int i=0;i<str.length;i++){
			ids.add(str[i]);
		}
		try {
			gradeService.deleteById(ids);
			return success("操作成功", ids);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return  error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param grade
	 * @return
	 */
	@ApiOperation("更新或插入年级")
	@PostMapping("insertOrupdate")
	public  MsgResponse insertOrupdate(Grade grade){
		try {
			gradeService.insertOrupdate(grade);
			return success("操作成功", grade);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
}
