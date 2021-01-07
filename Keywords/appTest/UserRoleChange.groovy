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

public class UserRoleChange {

	@Keyword
	def userRoleChange(String userRoleElemnt){

		(new support.ExplicitWait()).waitForPageLoad(30)

		//Click on user Role
		(new util.CommonEvents()).click('Object Repository/processRole/currentusetRole',FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)

		//Change role to DataProcessor
		(new util.CommonEvents()).click(userRoleElemnt, FailureHandling.STOP_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)
	}
}
