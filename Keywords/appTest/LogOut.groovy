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

public class LogOut {

	@Keyword
	def logOut(ExtentTest test,String name){

		//Logout from the application
		(new util.CommonEvents()).click('Object Repository/user/userBtn', FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ExplicitWait()).waitForElementVisible('Object Repository/user/signout', 20, FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(3)


		(new util.CommonEvents()).click('Object Repository/user/signout', FailureHandling.CONTINUE_ON_FAILURE)
		(new util.CommonEvents()).verifyElementVisibleCheck('Object Repository/logIn/loginBtn','logout successfully')
		(new support.ExplicitWait()).waitForPageLoad(16)

		/*//Add screen shot to report
		File imageFile = (new support.ScreenShot()).takeScreenShot()
		String image =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, name + "Logout", image, test)*/

	}
}
