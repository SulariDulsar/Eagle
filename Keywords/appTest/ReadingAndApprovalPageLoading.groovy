package appTest

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
import com.relevantcodes.extentreports.LogStatus
import com.relevantcodes.extentreports.ExtentTest

import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadingAndApprovalPageLoading {
	long startTime
	long endTime
	long responseTime

	@Keyword
	def readingAndApprovalPageLoading(String name,String imageLoginPage,Row row,String performaceExcelPath, ExtentTest test,XSSFWorkbook workbook,XSSFSheet sheet){

		//Login to application
		startTime = (new appTest.Login()).login(name,test)
		println(name+" startTime" + startTime)

		//Verify Reading and approval page loading
		(new util.CommonEvents()).waitForElementPresent('Object Repository/overviewPages/readingAndApprova/tableRow',300)

		endTime = System.currentTimeMillis()
		println(name+" endTime" + endTime)
		responseTime = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTime)
		println(name+" responseTime" + responseTime)


		//Write to excel
		if(name == "Instance-1"){
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTime,row,workbook,sheet)

		}

		//Add screen shot to report
		File imageFile = (new support.ScreenShot()).takeScreenShot()
		String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile,test)

		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b>  Login page", imageLoginPage, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b>  ResponseTime for Overview Page load: " +"<h7 style='color:green;'><b> " + responseTime+" ms </h7></b>", image, test)
		//(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "ResponseTime: " + responseTime, (new support.ScreenShot()).takeScreenShot(), test)


		println("xxxxxxxxxxxxxxx")

	}
}
