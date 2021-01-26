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

import internal.GlobalVariable
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.LogStatus
import com.relevantcodes.extentreports.ExtentTest
import util.Model
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class NavigateToOverviewPageFromOtherPage {
	long startTime
	long endTime
	long responseTime

	@Keyword
	def navigateToOverviewPageFromOtherPage(String name, ExtentTest test,Row row,String performaceExcelPath,XSSFWorkbook workbook,XSSFSheet sheet){
		//Click on MasterData Tab
		Model m1 = (new appTest.MasterDataTabClick()).masterData(name, test)

		startTime = System.currentTimeMillis()
		//Click on overview tab
		(new util.CommonEvents()).click('Object Repository/overviewPages/readingAndApprova/overViewTab', FailureHandling.CONTINUE_ON_FAILURE)


		//Verify Reading and approval page loading
		(new util.CommonEvents()).waitForElementPresent('Object Repository/overviewPages/readingAndApprova/tableRow',200)

		endTime = System.currentTimeMillis()
		println(name+" endTime" + endTime)
		responseTime = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTime)
		println(name+" responseTime" + responseTime)


		//Add screen shot to report
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> Meter Overview Page load: " + "<h7 style='color:green;'><b> "+ m1.getResponseTime()+" ms </h7></b>", m1.getImage1(), test)


		//Write to excel
		if(name == "Instance-1"){
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTime,row,workbook,sheet)

		}

		File imageFile = (new support.ScreenShot()).takeScreenShot()
		String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile,test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Overview Page load from Meter Overview page: " + "<h7 style='color:green;'> "+ responseTime+" ms </h7>", image, test)
		//(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "ResponseTime: " + responseTime, (new support.ScreenShot()).takeScreenShot(), test)

	}
}
