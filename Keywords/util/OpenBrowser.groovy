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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.LogStatus
import com.relevantcodes.extentreports.ExtentTest

public class OpenBrowser {

	@Keyword
	def openBrowser(WebDriver driver,ExtentTest test){

		DriverFactory.changeWebDriver(driver)
		WebUI.navigateToUrl(findTestData("testData").getValue(1,1))
		//print("a : ")
		//(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "Login Page", "ttttt", test)

		//Maximize current window and take screenshot
		(new support.MaximizeWindow()).maximizeWindow()

		//Add screen shot to report
		File imageFile = (new support.ScreenShot()).takeScreenShot()
		String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO,  "Login page", image, test)

		(new support.ExplicitWait()).waitForPageLoad(20)


	}



	/*	 (new util.CommonEvents()).verifyElementVisibleCheck('Object Repository/logIn/loginBtn','Eagle login page loaded successfully')
	 (new support.ExplicitWait()).waitForPageLoad(20)*/
}
