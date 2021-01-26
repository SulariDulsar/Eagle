package util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Font;

import util.Model
import java.text.SimpleDateFormat


public class WriteExcel {

	@Keyword
	public void writeRowToExcel(long time) throws IOException{
		FileInputStream fis = new FileInputStream(findTestData("report").getValue(6, 1));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Row row = sheet.createRow(rowCount+1);
		Cell cell = row.createCell(0);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(time);
		FileOutputStream fos = new FileOutputStream(findTestData("report").getValue(6, 1));
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	public void writeColumnToExcel(String filePath,long responseTime,Row row,XSSFWorkbook workbook,XSSFSheet sheet) throws IOException{

		CellStyle style = workbook.createCellStyle();
		Cell cell
		//Create font setting
		Font  font = workbook.createFont();
		int lastColumnIndex = 0;
		
		if(row.getRowNum()== 0){

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String date = dateFormat.format(new Date());
			
			lastColumnIndex = row.lastCellNum
			(new util.Model()).addGlobalVariable('lastColumnIndex', lastColumnIndex);
			
			cell = row.createCell(lastColumnIndex);
			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(date+ "\n"+ "(milliseconds)");
			style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setBold(true);
			style.setFont(font);
			
			
			
			

		}else{
			lastColumnIndex = GlobalVariable.lastColumnIndex;
			println("B > "+lastColumnIndex)
			cell = row.createCell(lastColumnIndex);
			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(responseTime);
		

		}
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setWrapText(true)
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER)
		
		cell.setCellStyle(style);
		
		//Auto sized column
		sheet.autoSizeColumn(cell.columnIndex)
		
		FileOutputStream fos2 = new FileOutputStream(filePath);
		workbook.write(fos2);

		fos2.close();

	}


	@Keyword
	public  getNumOfRowInSheet(String filePath) throws IOException{

		List<Row> rowDetails = new ArrayList<>();

		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet;
		
		
		if(findTestData("testData").getValue(6,1) == "staging"){
			sheet = workbook.getSheet("MK3-Staging");
		}
		
		if(findTestData("testData").getValue(6,1) == "development"){
			sheet = workbook.getSheet("MK3-Development");
		}
		
		//int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		int firstRowNum = sheet.getFirstRowNum()
		int lastRowNum = sheet.getLastRowNum()
		println("firstRoeNum " + firstRowNum)
		println("lastRowNum " + lastRowNum)

		//Row row = sheet.getRow(firstRowNum)
		Row row;

		for(int rowNum=firstRowNum;rowNum<=lastRowNum;rowNum++){
			row = sheet.getRow(rowNum)
			rowDetails.add(row)

		}

		//set image for return
		Model m = new Model()
		m.setWorkBook(workbook)
		m.setRowDetails(rowDetails)
		m.setSheet(sheet)
		
		return m

	}




}
