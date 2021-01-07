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
import com.relevantcodes.extentreports.ExtentTest
import com.relevantcodes.extentreports.LogStatus

public class OpenApplicationInNewTab {
	long startTime
	long endTime
	long responseTime

	@Keyword
	def openApplicationInNewTab(String url,ExtentTest test,String name){

		WebUI.executeJavaScript('window.open();', [])
		int currentWindow = WebUI.getWindowIndex()

		//Switches tab #1
		WebUI.switchToWindowIndex(currentWindow + 1)

		startTime = System.currentTimeMillis()
		WebUI.navigateToUrl(url)

		//Verify Reading and approval page loading
		(new util.CommonEvents()).waitForElementPresent('Object Repository/overviewPages/readingAndApprova/tableRow',120)

		endTime = System.currentTimeMillis()
		println(name+" endTime" + endTime)
		responseTime = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTime, endTime)
		println(name+" responseTimeNewTab" + responseTime)


		//Add screen shot to report
		File imageFile = (new support.ScreenShot()).takeScreenShot()
		String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile,test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + " ResponseTime for Overview Page load in new tab: " + responseTime+" ms", image, test)
		//(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "ResponseTime: " + responseTime, (new support.ScreenShot()).takeScreenShot(), test)

		File imageFile2 = (new support.ScreenShot()).takeFullScreenShot()
		
		//Switches tab #0
		WebUI.switchToWindowIndex(currentWindow)

	}
}
