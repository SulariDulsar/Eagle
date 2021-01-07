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

public class SearchOverviewPage {

	long startTime
	long endTime
	long responseTime
	File imageFile
	String image

	@Keyword
	def searchOnlyWithGroupType(String element,String name,ExtentTest test){

		(new support.ImplicitWait()).delayFor(5)

		(new util.CommonEvents()).click('Object Repository/overviewPages/readingAndApprova/groupTypeDropDown', FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(5)

		//Add screen shot to report
		imageFile = (new support.ScreenShot()).takeScreenShot()
		image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + "Overview page search", image, test)


		(new util.CommonEvents()).click(element, FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(5)
		(new support.ExplicitWait()).waitForElementClickable('Object Repository/common/searchBtn', 60, FailureHandling.CONTINUE_ON_FAILURE)


		startTime = System.currentTimeMillis()

		(new util.CommonEvents()).click('Object Repository/common/searchBtn',FailureHandling.STOP_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)

		//Verify Reading and approval page loading
		(new util.CommonEvents().waitForElementNotPresent('Object Repository/common/spinner', 120))


		endTime = System.currentTimeMillis()

		responseTime = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTime)

		//Add screen shot to report
		imageFile = (new support.ScreenShot()).takeScreenShot()
		image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + " ResponseTime for Overview Page search: " + responseTime+" ms", image, test)

	}

	@Keyword
	def searchOnlyWithGroupName(String element,String name,String groupName,ExtentTest test){

		(new support.ImplicitWait()).delayFor(5)

		(new util.CommonEvents()).setStringvalue('Object Repository/overviewPages/readingAndApprova/groupName',groupName)
		(new support.ImplicitWait()).delayFor(5)

		//Add screen shot to report
		imageFile = (new support.ScreenShot()).takeScreenShot()
		image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + "Overview page search with Group Name", image, test)


		(new util.CommonEvents()).click(element, FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(5)
		(new support.ExplicitWait()).waitForElementClickable('Object Repository/common/searchBtn', 60, FailureHandling.CONTINUE_ON_FAILURE)


		startTime = System.currentTimeMillis()

		(new util.CommonEvents()).click('Object Repository/common/searchBtn',FailureHandling.STOP_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)

		//Verify Reading and approval page loading
		(new util.CommonEvents().waitForElementNotPresent('Object Repository/common/spinner', 120))


		endTime = System.currentTimeMillis()

		responseTime = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTime)

		//Add screen shot to report
		imageFile = (new support.ScreenShot()).takeScreenShot()
		image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + " ResponseTime for Overview Page search with Group Name: " + responseTime+" ms", image, test)

	}
}
