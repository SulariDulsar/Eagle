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
import com.relevantcodes.extentreports.ExtentReports

import internal.GlobalVariable
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;

public class Model {
	long startTime
	long responseTime
	ExtentReports extent
	private String datepattern
	String image1
	String image2
	XSSFWorkbook workbook
	XSSFSheet sheet
	List<Row> rowDetails

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public ExtentReports getExtent() {
		return extent;
	}

	public void setExtent(ExtentReports extent) {
		this.extent = extent;
	}

	public String getDatepattern() {
		return this.datepattern
	}

	public void setDatepattern(String datepattern) {
		println("datepattern in side seter " +datepattern)
		this.datepattern = datepattern;
		println("datepattern in side after seter " +this.datepattern)
	}

	public String getimage1() {
		return image1;
	}

	public void setimage1(String image) {
		this.image1 = image;
	}

	public String getimage2() {
		return image2;
	}

	public void setimage2(String image) {
		this.image2 = image;
	}

	public String getWorkBook() {
		return workbook;
	}

	public void setWorkBook(XSSFWorkbook workbook ) {
		this.workbook = workbook;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet ) {
		this.sheet = sheet;
	}

	public List<Row> getRowDetails() {
		return rowDetails;
	}

	public void setRowDetails(List<Row> rowDetails ) {
		this.rowDetails = rowDetails;
	}

	@Keyword
	void addGlobalVariable(String name, def value) {
		GroovyShell shell1 = new GroovyShell()
		MetaClass mc = shell1.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}
}
