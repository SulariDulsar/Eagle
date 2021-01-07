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
import com.kms.katalon.core.util.KeywordUtil

import org.json.JSONObject
import com.kms.katalon.core.testobject.ConditionType


import internal.GlobalVariable

public class CommonEvents {

	//KeywordLogger log = new KeywordLogger()

	@Keyword
	def  openBrowser(String url) {
		WebUI.openBrowser(url, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def  verifyElementVisibleCheck(String element, String message) {

		assert WebUI.verifyElementVisible(findTestObject(element)) == true : message
	}


	@Keyword
	def  verifyElementVisible(String element) {
		boolean flag = false ;
		flag = WebUI.verifyElementVisible(findTestObject(element))
		print("xxxFlag "+ flag)

		return flag ;
	}

	@Keyword
	def  verifyElementPresent(String element,int waitTime, FailureHandling failureHandling) {
		boolean flag = false ;
		print("yyyyyyFlag "+ flag)
		flag = WebUI.verifyElementPresent(findTestObject(element),waitTime,failureHandling)
		print("xxxxFlag "+ flag)

		return flag
	}


	@Keyword
	def  verifyDynamicElementVisibleCheck(String element, FailureHandling failureHandling) {
		boolean flag = false
		try {
			TestObject to = new TestObject("objectName")
			to.addProperty("xpath", ConditionType.EQUALS, element)
			flag =  WebUI.verifyElementPresent((to),10, failureHandling)

		}catch (com.kms.katalon.core.webui.exception.WebElementNotFoundException ex) {
			flag = false;
			KeywordUtil.logInfo("Unable to locate correct sponsored product" + ex)

			//this.println("Unable to locate correct sponsored product but it’s cool…")
		}catch (com.kms.katalon.core.exception.StepErrorException e) {
			flag = false;
			KeywordUtil.logInfo("Unable to locate correct sponsored product" + e)

			//this.println("Unable to locate correct sponsored product but it’s cool…")
		}

		//print("Flag "+ flag)

		return flag;

	}



	@Keyword
	def  click(String element,FailureHandling failureHandling ) {

		WebUI.click(findTestObject(element),failureHandling)
	}

	@Keyword
	def doubleClick (String element,FailureHandling failureHandling) {
		WebUI.doubleClick(findTestObject(element), failureHandling)
	}

	@Keyword
	def clickDynamicElement (TestObject testObject ,FailureHandling failureHandling) {

		WebUI.click(testObject,failureHandling)

	}

	@Keyword
	def modifyObjectProperty (String element,String propertyName,String matchCondition,String modifyValue,Boolean isActive) {

		TestObject testObject = WebUI.modifyObjectProperty(findTestObject(element), propertyName, matchCondition, modifyValue, isActive)

		return testObject
	}



	@Keyword
	def setStringvalue(String element,String testData){
		WebUI.setText(findTestObject(element), testData)
	}

	@Keyword
	def verifyElementText(String element,String elementTxt,String message) {

		WebUI.verifyElementText(findTestObject(element), elementTxt)

	}

	@Keyword
	def clearText(String element,FailureHandling failureHandling) {

		WebUI.clearText(findTestObject(element), failureHandling)

	}


	@Keyword
	def verifyEqual (String actual,String expected,FailureHandling failureHandling){

		WebUI.verifyEqual(actual, expected, failureHandling)
	}

	@Keyword
	def verifyEqualWithoutFailureHandling (String actual,String expected){

		WebUI.verifyEqual(actual, expected)
	}

	@Keyword
	def getText (String element,FailureHandling failureHandling) {
		WebUI.getText(findTestObject(element), failureHandling)

	}

	@Keyword
	def getAttribute (String element,String value,FailureHandling failureHandling) {
		WebUI.getAttribute(findTestObject(element), value,failureHandling)

	}


	@Keyword
	def verifyElementChecked (String element,int waitTime,FailureHandling failureHandling) {
		WebUI.verifyElementChecked(findTestObject(element), 0, failureHandling)

	}

	@Keyword
	def waitForElementPresent (String element,int waitTime) {
		WebUI.waitForElementPresent(findTestObject(element),waitTime)

	}

	@Keyword
	def waitForDynamicElementPresent (TestObject testObject,int waitTime) {
		WebUI.waitForElementPresent(testObject,waitTime)

	}

	@Keyword
	def waitForElementNotPresent (String element,int waitTime) {
		WebUI.waitForElementNotPresent(findTestObject(element),waitTime)

	}


	@Keyword
	def selecetCheckBox (String element,FailureHandling failureHandling) {
		WebUI.check(findTestObject(element), failureHandling)

	}


	@Keyword
	def UnSelecetCheckBox (String element,int waitTime,FailureHandling failureHandling) {
		WebUI.uncheck(findTestObject(element), failureHandling)
	}

	@Keyword
	def refreshCurrentWebPage () {
		long startTime = System.currentTimeMillis()
		
		WebUI.refresh()
		
		return startTime 
	}



	@Keyword
	def getDynamicText (String element,FailureHandling failureHandling) {
		TestObject to = new TestObject("objectName")
		to.addProperty("xpath", ConditionType.EQUALS, element)
		println("text")
		try {
			WebUI.getText(to, failureHandling)
			println("text =" + WebUI.getText(to, failureHandling))
		} catch (com.kms.katalon.core.exception.StepFailedException e) {
			return null
		}



	}

	@Keyword
	def selectElementfromList (String xpath,FailureHandling failureHandling) {

		TestObject to = new TestObject("objectName1")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)

		(new support.ImplicitWait()).delayFor(5)
		(new util.CommonEvents()).clickDynamicElement(xpath,FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def scrollToElement (String element,int waitTime,FailureHandling failureHandling) {

		(new support.ImplicitWait()).delayFor(3)
		//TestObject tObj = findTestObject(element)
		WebUI.scrollToElement(findTestObject(element), waitTime,failureHandling)

		print("x")

	}

	@Keyword
	def getXpathValue (String element,groupName) {
		TestObject tObj = findTestObject(element)
		String propertyValue = tObj.findPropertyValue('xpath')
		String validXpath = propertyValue.replace("xxx",groupName)
		tObj.addProperty("xpath", ConditionType.EQUALS, validXpath)

		return tObj

	}


	@Keyword
	def getPropertyValue (String element,String dynamicValue) {

		String validXpath
		String propertyValue
		JSONObject returnValue = new JSONObject()

		//Get property value
		TestObject tObj = findTestObject(element)
		propertyValue = tObj.findPropertyValue('xpath')
		returnValue.put("propertyValue", propertyValue)

		//Create dynamic Xpath
		validXpath = propertyValue + dynamicValue
		println ("xpathCom : " + validXpath)
		returnValue.put("validXpath",validXpath)

		//Add to propertyValue
		tObj.addProperty("xpath", ConditionType.EQUALS, validXpath)
		println ("tObj : " + tObj)
		returnValue.put("tObj", tObj)

		return returnValue

	}


	@Keyword
	def setMeterDetails (String meterName,boolean optionalFieldflag ) {


		JSONObject metereDtails = new JSONObject()

		//put meter value
		metereDtails.put("meterName", meterName)
		metereDtails.put("optionalFieldflag", optionalFieldflag)

		return metereDtails

	}

}
