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

public class MasterDataTabClick {
	long startTime
	long endTime
	long responseTime

	@Keyword
	def masterData (String name, ExtentTest test) {

		startTime = System.currentTimeMillis()
		println(name+" startTime" + startTime)

		//Verify master data tab click
		(new util.CommonEvents()).click('Object Repository/masterData/masterDataTab', FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)

		(new util.CommonEvents()).waitForElementPresent('Object Repository/overviewPages/meterOverview/createNeMeterBtn',50)

		endTime = System.currentTimeMillis()
		println(name+" endTime" + endTime)
		responseTime = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTime)
		println(name+" responseTime" + responseTime)

		//Add screen shot to report
		File imageFile = (new support.ScreenShot()).takeScreenShot()
		String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile,test)

		Model m1 = new Model()
		m1.setImage1(image)
		m1.setResponseTime(responseTime)

		return m1
	}
}
