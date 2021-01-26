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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class DataScreenPageLoaging {


	long startTime
	long endTimeDataScreenPageLoad
	long endTimePeriodLoad
	long responseTimeDataScreenPageLoad
	long responseTimePeriodLoad

	@Keyword
	def dataScreenPageLoaging(String element,String propertyName,String matchCondition,String groupName,Boolean isActive,ExtentTest test,String name,String BeforeSearch,String imageAfterSearch,long responseTimeToSearchWithGroupName,Row row,String performaceExcelPath,XSSFWorkbook workbook,XSSFSheet sheet){

		//modify hyper link testObject according to the group name
		TestObject testObjectHyperLink = (new util.CommonEvents()).modifyObjectProperty(element,propertyName, matchCondition, groupName, isActive)

		//modify Data screen name heading testObject according to the group name
		TestObject testObjectDataScreenHeading = (new util.CommonEvents()).modifyObjectProperty('Object Repository/dataScreen/dataScreenPageHeading',propertyName, matchCondition,groupName, isActive)

		/*String frequency = "input-area picker " + findTestData("testData").getValue(3, 1)
		 println("frequency " + frequency)
		 TestObject testObjectPeriod = (new util.CommonEvents()).modifyObjectProperty('Object Repository/dataScreen/periodField','class', 'equals',frequency, false)
		 */
		startTime = System.currentTimeMillis()

		//Click on name hyperLink
		(new util.CommonEvents()).clickDynamicElement(testObjectHyperLink, FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)

		//Verify Reading and approval page loading
		(new util.CommonEvents()).waitForDynamicElementPresent(testObjectDataScreenHeading, 120)
		endTimeDataScreenPageLoad = System.currentTimeMillis()
		File imageFileDataScreenLoad = (new support.ScreenShot()).takeScreenShot()

		//Verify period loading
		(new util.CommonEvents()).waitForElementPresent('Object Repository/dataScreen/periodField', 200)
		endTimePeriodLoad = System.currentTimeMillis()
		File imageFilePeriodLoad = (new support.ScreenShot()).takeScreenShot()
		println("xxxxx")

		responseTimeDataScreenPageLoad = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTimeDataScreenPageLoad)
		println("responseTimeDataScreenPageLoad "+responseTimeDataScreenPageLoad)
		responseTimePeriodLoad = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTimePeriodLoad)
		println("responseTimePeriodLoad "+responseTimePeriodLoad)


		//Write to excel
		if(name == "Instance-1"){
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTimeDataScreenPageLoad,row,workbook,sheet)

		}

		//Add screen shot to report
		int waitTime = (new util.GenerateRandomValue()).generateRandomIntValue()
		(new support.ImplicitWait()).delayFor(waitTime)

		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> Overview page search with Group Name", BeforeSearch, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Overview Page search with Group Name: " + "<h7 style='color:green;'><b> " +responseTimeToSearchWithGroupName+ " ms </h7></b>", imageAfterSearch, test)

		String imageDataScreenLoad =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFileDataScreenLoad, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Data Screen page load: " + "<h7 style='color:green;'><b> " +responseTimeDataScreenPageLoad+" ms </h7></b>", imageDataScreenLoad, test)

		String imagePeriodLoad =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFilePeriodLoad, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Period load: " +"<h7 style='color:green;'><b> " +responseTimePeriodLoad+" ms </h7></b>", imagePeriodLoad, test)


		if(findTestData("testCases").getValue(2, 8) == false){
			//Click on overview tab
			(new util.CommonEvents()).click('Object Repository/overviewPages/readingAndApprova/overViewTab', FailureHandling.CONTINUE_ON_FAILURE)

			//Clear search
			(new util.CommonEvents()).clearText('Object Repository/overviewPages/readingAndApprova/groupName', FailureHandling.CONTINUE_ON_FAILURE)

		}
	}
}
