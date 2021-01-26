package support

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.relevantcodes.extentreports.ExtentReports as ExtentReports
import com.relevantcodes.extentreports.ExtentTest as ExtentTest
import com.relevantcodes.extentreports.LogStatus as LogStatus
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import internal.GlobalVariable as GlobalVariable
import com.katalon.plugin.keyword.extentReport.Extent as Ext
import java.text.SimpleDateFormat
import java.io.File

public class Report {

	public String reportName = findTestData("report").getValue(1,1);
	private String reportPath;
	public ExtentReports extent = null;
	private static Report self;
	public String folderPathReport;
	File file;

	private  Report () {
		if(findTestData("testData").getValue(6,1) == "development"){
			folderPathReport = findTestData("report").getValue(2,1)+ "PerformanceTest-Development-" + GlobalVariable.datepattern + "\\";
			file = new File(folderPathReport)
		}else if(findTestData("testData").getValue(6,1) == "staging"){
			folderPathReport = findTestData("report").getValue(2,2)+ "PerformanceTest-Staging-" + GlobalVariable.datepattern + "\\";
			file = new File(folderPathReport)
		}

		//Create directory
		try{

			file.mkdir()

		}catch(IOException e){

		}


		reportName = reportName + GlobalVariable.datepattern  + ".html";
		reportPath = folderPathReport + reportName ;
		//print("path" + findTestData("report").getValue(2,1))


		//initialize ExtentReports

		try {
			extent = new ExtentReports(reportPath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		//To add system or environment info by using the addSystemInfo method.
		extent.addSystemInfo("Environment",findTestData("testData").getValue(6,1));
		extent.config().reportName(findTestData("report").getValue(1,1))

	}

	public static Report getInstance() {
		if (self == null){
			self = new Report();
		}

		return (self);

	}

	public ExtentTest getReportTest(String name,String description) {
		ExtentTest test;
		test = extent.startTest(name,description);
		return test;
	}

	public void endReportTest(ExtentTest test){
		//System.out.println(test.getClass()+"  "+test.getTest().getName()+" Start---------------");
		extent.endTest(test);
		//System.out.println(test.getClass()+"  "+test.getTest().getName()+" End---------------");

	}

	public void flushReport(boolean report){
		try {
			(new support.ImplicitWait().delayFor(10))
			extent.flush();
			//System.out.println("MID");
			(new support.ImplicitWait().delayFor(10))

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Out");
	}

	public void getResultStatus(LogStatus status, String stepName, String detail, ExtentTest test) throws Exception {
		if (status == LogStatus.FAIL) {
			test.log(LogStatus.FAIL, stepName, detail);
		} else if (status == LogStatus.INFO) {
			test.log(LogStatus.INFO, stepName, detail);
		} else if (status == LogStatus.PASS) {
			test.log(LogStatus.PASS, stepName, detail);
		} else if (status == LogStatus.ERROR){
			test.log(LogStatus.ERROR,stepName,detail);

		}
	}

	public String getReportPath() {
		return reportPath;
	}

	public String getReportName(){

		return reportName ;
	}


	public String getFolderPath(){

		return folderPathReport ;
	}


	/*@Keyword
	 def createReport(ExtentReports report){
	 println("******* Report created")
	 extent = report;
	 }
	 @Keyword
	 def setReport(ExtentReports extent){
	 println("******* Report set "+ extent.toString())
	 extent = extent;
	 }
	 @Keyword
	 def getReport(){
	 println("******* Report get "+ extent.toString())
	 return extent;
	 }
	 @Keyword
	 def getReportName(){
	 println("******* Report name "+ reportName)
	 return reportName;
	 }
	 @Keyword
	 def getReportTest(String name){
	 println("******* Report test "+ name)
	 ExtentTest extentTest;
	 return extentTest;
	 }
	 @Keyword
	 def endTest(ExtentTest test){
	 extent.endTest(test);
	 }
	 @Keyword
	 def flushReport(){
	 extent.flush()
	 }*/
}


