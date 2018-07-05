package com.briup.apps.poll.web.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.briup.apps.poll.bean.Answer;
import com.briup.apps.poll.service.IAnswerService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/excel")
@Api(tags="课调下载接口-Controller")
public class ExcelController extends BaseController{

	@Autowired
	private IAnswerService answerService;

	/***
	 * 下载Excel
	 * @throws IOException
	 */
	@GetMapping("download")
	@ApiOperation("下载课调答卷")
	public void download() throws IOException{
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个Excel表单,参数为sheet的名字
		HSSFSheet sheet = workbook.createSheet("课调答卷表");

		//创建表头
		setTitle(workbook, sheet);
		List<Answer> answers = answerService.findAll();

		//新增数据行，并且设置单元格数据
		int rowNum = 1;
		for (Answer answer:answers) {
			HSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(answer.getId());
			row.createCell(1).setCellValue(answer.getSelections());
			row.createCell(2).setCellValue(answer.getCheckes());
			row.createCell(3).setCellValue(answer.getContent());
			rowNum++;
		}
		String fileName = "survey-answer.xlsx";
	    //清空response  
        response.reset();  
        //设置response的Header  
        response.addHeader("Content-Disposition", "attachment;filename="+ fileName);  
        OutputStream os = new BufferedOutputStream(response.getOutputStream());  
        response.setContentType("application/vnd.ms-excel;charset=gb2312"); 
        //将excel写入到输出流中
        workbook.write(os);
        os.flush();
        os.close();
	}
	
	/***
	 * 设置表头
	 * @param workbook
	 * @param sheet
	 */
	private void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){
		HSSFRow row = sheet.createRow(0);
		//设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
		sheet.setColumnWidth(0, 10*256);
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 20*256);
		sheet.setColumnWidth(3, 100*256);

		//设置为居中加粗
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		HSSFCell cell;
		cell = row.createCell(0);
		cell.setCellValue("序号");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("单选");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("多选");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("简答");
		cell.setCellStyle(style);
	}
	
	@ApiOperation("上传Excel表格")
	@PostMapping("upload")
	public MsgResponse upload(MultipartFile file) {
		if (file==null) {
			return error("file不能为空");
		}
		List<Answer> answers = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
			//有多少个sheet
			int sheets = workbook.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				HSSFSheet sheet = workbook.getSheetAt(i);
				//获取多少行
				int rows = sheet.getPhysicalNumberOfRows();
				Answer answer = null;
				//遍历每一行，注意：第 0 行为标题
				for (int j = 1; j < rows; j++) {
					answer = new Answer();
					 //获得第 j 行
					HSSFRow row = sheet.getRow(j);
					answer.setSelections(row.getCell(1).getStringCellValue());//单选
					answer.setCheckes(row.getCell(2).getStringCellValue());//多选
					answer.setContent(row.getCell(3).getStringCellValue());
					answers.add(answer);
				}
			}
		
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
		return success(answers);
	}
	
}
