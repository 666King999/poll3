package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Option;
import com.briup.apps.poll.bean.extend.OptionVM;
import com.briup.apps.poll.service.IOptionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="选项相关接口-Controller")
@RestController
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private IOptionService optionService;
	@ApiOperation("查询所有选项")
	@GetMapping("findAll")
	public MsgResponse findAll()
	{
		List<Option> list=new ArrayList<>();
		try {
			list=optionService.findAll();
			return MsgResponse.success("操作成功", list);
		}catch(Exception e)
		{
			e.printStackTrace();
			return  MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id查询选项")
	@GetMapping("findById")
	public MsgResponse findById(@RequestParam(value="id")String id)
	{  
		List<Option> list=new ArrayList<>();
		String str[]=id.split(",");
		List<String> ids=new ArrayList<String>();
		for(int i=0;i<str.length;i++)
		{
			ids.add(str[i]);
		}
		try {
			list=optionService.findById(ids);
			return MsgResponse.success("操作成功", list);
		}catch(Exception e)
		{
			e.printStackTrace();
			return  MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 模糊查询
	 * @param keyWord
	 * @return
	 */
	@ApiOperation("模糊查询")
	@GetMapping("query")
	public MsgResponse query(String keyWord) {
		try {
			List<Option> list = optionService.query(keyWord);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 
	 * @return
	 */
	@ApiOperation("查询所有选项及其相关信息")
	@GetMapping("findAllVM")
	public MsgResponse findAllVM()
	{
	    List<OptionVM> list=new ArrayList<>();
	    try {
			list=optionService.findAllVM();
			return MsgResponse.success("操作成功", list);
		}catch(Exception e)
		{
			e.printStackTrace();
			return  MsgResponse.error(e.getMessage());
		}
	
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id查询选项及其相关信息")
	@GetMapping("findOptionById")
	public MsgResponse findOptionById(@RequestParam(value="id")String id)
	{  
		List<OptionVM> list=new ArrayList<>();
		String str[]=id.split(",");
		List<String> ids=new ArrayList<String>();
		for(int i=0;i<str.length;i++)
		{
			ids.add(str[i]);
		}
		try {
			list=optionService.findOptionVMById(ids);
			return MsgResponse.success("操作成功", list);
		}catch(Exception e)
		{
			e.printStackTrace();
			return  MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("根据id删除选项")
	@GetMapping("deleteById")
	public MsgResponse deleteById(@RequestParam(value="id")String id)
	{  
		String str[]=id.split(",");
		List<String> ids=new ArrayList<String>();
		for(int i=0;i<str.length;i++)
		{
			ids.add(str[i]);
		}
		try {
			  optionService.deleteById(ids);
			return MsgResponse.success("操作成功", ids);
		}catch(Exception e)
		{
			e.printStackTrace();
			return  MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 
	 * @param option
	 * @return
	 */
	@ApiOperation("更新或插入选项")
	@PostMapping("insertOrupdate")
	public  MsgResponse insertOrupdate(Option option)
	{
		try {
			optionService.insertOrupdate(option);
			return MsgResponse.success("操作成功", option);
		}catch(Exception e)
		{
			e.printStackTrace();
			return  MsgResponse.error(e.getMessage());
		}
     }
}
