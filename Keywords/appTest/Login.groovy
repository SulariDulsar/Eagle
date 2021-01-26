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
import com.relevantcodes.extentreports.LogStatus
import com.relevantcodes.extentreports.ExtentTest

import internal.GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.edge.EdgeDriver as EdgeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

public class Login {

	@Keyword
	def login(String name,ExtentTest test){

		long startTime = System.currentTimeMillis()
		println("startTime begin "+startTime)

		//Click on Login button
		(new util.CommonEvents()).click('Object Repository/logIn/loginBtn',FailureHandling.STOP_ON_FAILURE)


		/*//Add screen shot to report
		 File imageFile = (new support.ScreenShot()).takeScreenShot()
		 String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		 (new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + " Once click on Login button", image, test)*/

		boolean flag =(new util.CommonEvents()).verifyElementPresent('Object Repository/logIn/signPage',5,FailureHandling.OPTIONAL)
		print("Flag "+ flag)

		if (flag){
			(new util.CommonEvents().setStringvalue('Object Repository/logIn/loginEmail', findTestData("testData").getValue(11, 1)))
			(new util.CommonEvents().click('Object Repository/logIn/nextBtn', FailureHandling.CONTINUE_ON_FAILURE))
			(new support.ImplicitWait().delayFor(2))
			(new util.CommonEvents().setStringvalue('Object Repository/logIn/loginPW', findTestData("testData").getValue(12, 1)))
			(new support.ImplicitWait().delayFor(2))

			//click o sign-in button
			(new util.CommonEvents().click('Object Repository/logIn/signInBtn', FailureHandling.CONTINUE_ON_FAILURE))
			(new support.ImplicitWait().delayFor(2))

			//Click on yes button
			startTime = System.currentTimeMillis()
			println  ("correct start time " +startTime)
			(new util.CommonEvents().click('Object Repository/logIn/permissionConfirmationBtn', FailureHandling.CONTINUE_ON_FAILURE))



		}


		/*(new support.ImplicitWait().delayFor(20))
		 (new support.ExplicitWait()).waitForPageLoad(60)*/

		/*//Verify Login
		 (new util.CommonEvents()).verifyElementVisibleCheck('Object Repository/user/userBtn','Login to eagle application successfully')*/

		/*//reload page
		 (new util.CommonEvents()).refreshCurrentWebPage()
		 startTime = System.currentTimeMillis()*/



		return startTime
	}
}
