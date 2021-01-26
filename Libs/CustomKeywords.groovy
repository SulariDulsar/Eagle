
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.relevantcodes.extentreports.ExtentTest

import org.apache.poi.ss.usermodel.Row

import org.apache.poi.xssf.usermodel.XSSFWorkbook

import org.apache.poi.xssf.usermodel.XSSFSheet

import com.kms.katalon.core.model.FailureHandling

import com.kms.katalon.core.testobject.TestObject

import java.lang.Boolean

import org.openqa.selenium.WebDriver

import java.util.HashMap


def static "util.ResponseTimeCalculation.responseTimeCalculation"(
    	long startTime	
     , 	long endTime	) {
    (new util.ResponseTimeCalculation()).responseTimeCalculation(
        	startTime
         , 	endTime)
}

def static "support.ImplicitWait.delayFor"(
    	int time	) {
    (new support.ImplicitWait()).delayFor(
        	time)
}

def static "appTest.OpenApplicationInNewTab.openApplicationInNewTab"(
    	String url	
     , 	ExtentTest test	
     , 	String name	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.OpenApplicationInNewTab()).openApplicationInNewTab(
        	url
         , 	test
         , 	name
         , 	row
         , 	performaceExcelPath
         , 	workbook
         , 	sheet)
}

def static "appTest.Login.login"(
    	String name	
     , 	ExtentTest test	) {
    (new appTest.Login()).login(
        	name
         , 	test)
}

def static "appTest.SearchGroupOverview.searchOnlyWithGroupName"(
    	String element	
     , 	String name	
     , 	String groupName	
     , 	ExtentTest test	) {
    (new appTest.SearchGroupOverview()).searchOnlyWithGroupName(
        	element
         , 	name
         , 	groupName
         , 	test)
}

def static "support.ExplicitWait.waitForPageLoad"(
    	int time	) {
    (new support.ExplicitWait()).waitForPageLoad(
        	time)
}

def static "support.ExplicitWait.waitForElementVisible"(
    	String element	
     , 	int waitTime	
     , 	FailureHandling failureHandling	) {
    (new support.ExplicitWait()).waitForElementVisible(
        	element
         , 	waitTime
         , 	failureHandling)
}

def static "support.ExplicitWait.waitForElementClickable"(
    	String element	
     , 	int waitTime	
     , 	FailureHandling failureHandling	) {
    (new support.ExplicitWait()).waitForElementClickable(
        	element
         , 	waitTime
         , 	failureHandling)
}

def static "util.GenerateRandomValue.generateRandomValu"() {
    (new util.GenerateRandomValue()).generateRandomValu()
}

def static "util.GenerateRandomValue.generateRandomIntValue"() {
    (new util.GenerateRandomValue()).generateRandomIntValue()
}

def static "appTest.SearchOverviewPage.searchOnlyWithGroupType"(
    	String element	
     , 	String name	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	ExtentTest test	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.SearchOverviewPage()).searchOnlyWithGroupType(
        	element
         , 	name
         , 	row
         , 	performaceExcelPath
         , 	test
         , 	workbook
         , 	sheet)
}

def static "appTest.SearchOverviewPage.searchOnlyWithGroupName"(
    	String element	
     , 	String name	
     , 	String groupName	
     , 	ExtentTest test	) {
    (new appTest.SearchOverviewPage()).searchOnlyWithGroupName(
        	element
         , 	name
         , 	groupName
         , 	test)
}

def static "util.CommonEvents.openBrowser"(
    	String url	) {
    (new util.CommonEvents()).openBrowser(
        	url)
}

def static "util.CommonEvents.verifyElementVisibleCheck"(
    	String element	
     , 	String message	) {
    (new util.CommonEvents()).verifyElementVisibleCheck(
        	element
         , 	message)
}

def static "util.CommonEvents.verifyElementVisible"(
    	String element	) {
    (new util.CommonEvents()).verifyElementVisible(
        	element)
}

def static "util.CommonEvents.verifyElementPresent"(
    	String element	
     , 	int waitTime	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).verifyElementPresent(
        	element
         , 	waitTime
         , 	failureHandling)
}

def static "util.CommonEvents.verifyDynamicElementVisibleCheck"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).verifyDynamicElementVisibleCheck(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.click"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).click(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.doubleClick"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).doubleClick(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.clickDynamicElement"(
    	TestObject testObject	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).clickDynamicElement(
        	testObject
         , 	failureHandling)
}

def static "util.CommonEvents.modifyObjectProperty"(
    	String element	
     , 	String propertyName	
     , 	String matchCondition	
     , 	String modifyValue	
     , 	Boolean isActive	) {
    (new util.CommonEvents()).modifyObjectProperty(
        	element
         , 	propertyName
         , 	matchCondition
         , 	modifyValue
         , 	isActive)
}

def static "util.CommonEvents.setStringvalue"(
    	String element	
     , 	String testData	) {
    (new util.CommonEvents()).setStringvalue(
        	element
         , 	testData)
}

def static "util.CommonEvents.verifyElementText"(
    	String element	
     , 	String elementTxt	
     , 	String message	) {
    (new util.CommonEvents()).verifyElementText(
        	element
         , 	elementTxt
         , 	message)
}

def static "util.CommonEvents.clearText"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).clearText(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.verifyEqual"(
    	String actual	
     , 	String expected	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).verifyEqual(
        	actual
         , 	expected
         , 	failureHandling)
}

def static "util.CommonEvents.verifyEqualWithoutFailureHandling"(
    	String actual	
     , 	String expected	) {
    (new util.CommonEvents()).verifyEqualWithoutFailureHandling(
        	actual
         , 	expected)
}

def static "util.CommonEvents.getText"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).getText(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.getAttribute"(
    	String element	
     , 	String value	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).getAttribute(
        	element
         , 	value
         , 	failureHandling)
}

def static "util.CommonEvents.verifyElementChecked"(
    	String element	
     , 	int waitTime	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).verifyElementChecked(
        	element
         , 	waitTime
         , 	failureHandling)
}

def static "util.CommonEvents.waitForElementPresent"(
    	String element	
     , 	int waitTime	) {
    (new util.CommonEvents()).waitForElementPresent(
        	element
         , 	waitTime)
}

def static "util.CommonEvents.waitForDynamicElementPresent"(
    	TestObject testObject	
     , 	int waitTime	) {
    (new util.CommonEvents()).waitForDynamicElementPresent(
        	testObject
         , 	waitTime)
}

def static "util.CommonEvents.waitForElementNotPresent"(
    	String element	
     , 	int waitTime	) {
    (new util.CommonEvents()).waitForElementNotPresent(
        	element
         , 	waitTime)
}

def static "util.CommonEvents.selecetCheckBox"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).selecetCheckBox(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.UnSelecetCheckBox"(
    	String element	
     , 	int waitTime	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).UnSelecetCheckBox(
        	element
         , 	waitTime
         , 	failureHandling)
}

def static "util.CommonEvents.refreshCurrentWebPage"() {
    (new util.CommonEvents()).refreshCurrentWebPage()
}

def static "util.CommonEvents.getDynamicText"(
    	String element	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).getDynamicText(
        	element
         , 	failureHandling)
}

def static "util.CommonEvents.selectElementfromList"(
    	String xpath	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).selectElementfromList(
        	xpath
         , 	failureHandling)
}

def static "util.CommonEvents.scrollToElement"(
    	String element	
     , 	int waitTime	
     , 	FailureHandling failureHandling	) {
    (new util.CommonEvents()).scrollToElement(
        	element
         , 	waitTime
         , 	failureHandling)
}

def static "util.CommonEvents.getXpathValue"(
    	String element	
     , 	Object groupName	) {
    (new util.CommonEvents()).getXpathValue(
        	element
         , 	groupName)
}

def static "util.CommonEvents.getPropertyValue"(
    	String element	
     , 	String dynamicValue	) {
    (new util.CommonEvents()).getPropertyValue(
        	element
         , 	dynamicValue)
}

def static "util.CommonEvents.setMeterDetails"(
    	String meterName	
     , 	boolean optionalFieldflag	) {
    (new util.CommonEvents()).setMeterDetails(
        	meterName
         , 	optionalFieldflag)
}

def static "util.CommonEvents.clickHyperLink"(
    	String element	
     , 	String propertyName	
     , 	String matchCondition	
     , 	String groupName	
     , 	Boolean isActive	) {
    (new util.CommonEvents()).clickHyperLink(
        	element
         , 	propertyName
         , 	matchCondition
         , 	groupName
         , 	isActive)
}

def static "appTest.DataScreenGetDataLoading.dataScreenGetDataLoading"(
    	String name	
     , 	Row row1	
     , 	Row row2	
     , 	Row row3	
     , 	String performaceExcelPath	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	
     , 	WebDriver driver	
     , 	ExtentTest test	) {
    (new appTest.DataScreenGetDataLoading()).dataScreenGetDataLoading(
        	name
         , 	row1
         , 	row2
         , 	row3
         , 	performaceExcelPath
         , 	workbook
         , 	sheet
         , 	driver
         , 	test)
}

def static "appTest.UserRoleChange.userRoleChange"(
    	String userRoleElemnt	) {
    (new appTest.UserRoleChange()).userRoleChange(
        	userRoleElemnt)
}

def static "appTest.ReadingAndApprovalPageLoading.readingAndApprovalPageLoading"(
    	String name	
     , 	String imageLoginPage	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	ExtentTest test	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.ReadingAndApprovalPageLoading()).readingAndApprovalPageLoading(
        	name
         , 	imageLoginPage
         , 	row
         , 	performaceExcelPath
         , 	test
         , 	workbook
         , 	sheet)
}

def static "appTest.Notification.verifyNotificationCount"() {
    (new appTest.Notification()).verifyNotificationCount()
}

def static "appTest.Notification.verifyNotificationContent"(
    	String meterName	) {
    (new appTest.Notification()).verifyNotificationContent(
        	meterName)
}

def static "appTest.Notification.clickLatestNotification"(
    	int i	) {
    (new appTest.Notification()).clickLatestNotification(
        	i)
}

def static "util.OpenBrowser.openBrowser"(
    	String name	
     , 	WebDriver driver	
     , 	ExtentTest test	) {
    (new util.OpenBrowser()).openBrowser(
        	name
         , 	driver
         , 	test)
}

def static "support.ScreenShot.takeScreenShot"() {
    (new support.ScreenShot()).takeScreenShot()
}

def static "support.ScreenShot.takeFullScreenShot"() {
    (new support.ScreenShot()).takeFullScreenShot()
}

def static "support.ScreenShot.addScreenCapture"(
    	String imagePath	
     , 	ExtentTest test	) {
    (new support.ScreenShot()).addScreenCapture(
        	imagePath
         , 	test)
}

def static "support.MaximizeWindow.maximizeWindow"() {
    (new support.MaximizeWindow()).maximizeWindow()
}

def static "util.CreateDriver.createDriver"(
    	java.util.HashMap<String, ExtentTest> testCaseList	) {
    (new util.CreateDriver()).createDriver(
        	testCaseList)
}

def static "util.Model.addGlobalVariable"(
    	String name	
     , 	Object value	) {
    (new util.Model()).addGlobalVariable(
        	name
         , 	value)
}

def static "appTest.NavigateToOverviewPageFromOtherPage.navigateToOverviewPageFromOtherPage"(
    	String name	
     , 	ExtentTest test	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.NavigateToOverviewPageFromOtherPage()).navigateToOverviewPageFromOtherPage(
        	name
         , 	test
         , 	row
         , 	performaceExcelPath
         , 	workbook
         , 	sheet)
}

def static "appTest.DataScreenPageLoaging.dataScreenPageLoaging"(
    	String element	
     , 	String propertyName	
     , 	String matchCondition	
     , 	String groupName	
     , 	Boolean isActive	
     , 	ExtentTest test	
     , 	String name	
     , 	String BeforeSearch	
     , 	String imageAfterSearch	
     , 	long responseTimeToSearchWithGroupName	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.DataScreenPageLoaging()).dataScreenPageLoaging(
        	element
         , 	propertyName
         , 	matchCondition
         , 	groupName
         , 	isActive
         , 	test
         , 	name
         , 	BeforeSearch
         , 	imageAfterSearch
         , 	responseTimeToSearchWithGroupName
         , 	row
         , 	performaceExcelPath
         , 	workbook
         , 	sheet)
}

def static "util.WriteExcel.writeRowToExcel"(
    	long time	) {
    (new util.WriteExcel()).writeRowToExcel(
        	time)
}

def static "util.WriteExcel.writeColumnToExcel"(
    	String filePath	
     , 	long responseTime	
     , 	Row row	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new util.WriteExcel()).writeColumnToExcel(
        	filePath
         , 	responseTime
         , 	row
         , 	workbook
         , 	sheet)
}

def static "util.WriteExcel.getNumOfRowInSheet"(
    	String filePath	) {
    (new util.WriteExcel()).getNumOfRowInSheet(
        	filePath)
}

def static "appTest.GroupSaving.savingExistingDetailChanges"(
    	String element	
     , 	String newValue	
     , 	ExtentTest test	
     , 	String name	
     , 	String BeforeSearch	
     , 	String imageAfterSearch	
     , 	long responseTimeToSearchWithGroupName	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.GroupSaving()).savingExistingDetailChanges(
        	element
         , 	newValue
         , 	test
         , 	name
         , 	BeforeSearch
         , 	imageAfterSearch
         , 	responseTimeToSearchWithGroupName
         , 	row
         , 	performaceExcelPath
         , 	workbook
         , 	sheet)
}

def static "util.RunAsync.start"(
    	String name	
     , 	WebDriver driver	
     , 	java.util.HashMap<String, ExtentTest> testCaseList	) {
    (new util.RunAsync()).start(
        	name
         , 	driver
         , 	testCaseList)
}

def static "appTest.MasterDataTabClick.masterData"(
    	String name	
     , 	ExtentTest test	) {
    (new appTest.MasterDataTabClick()).masterData(
        	name
         , 	test)
}

def static "appTest.VerifyResponseTimeForRefreshpageLoading.verifyResponseTimeForRefreshpageLoading"(
    	String element	
     , 	String name	
     , 	Row row	
     , 	String performaceExcelPath	
     , 	ExtentTest test	
     , 	XSSFWorkbook workbook	
     , 	XSSFSheet sheet	) {
    (new appTest.VerifyResponseTimeForRefreshpageLoading()).verifyResponseTimeForRefreshpageLoading(
        	element
         , 	name
         , 	row
         , 	performaceExcelPath
         , 	test
         , 	workbook
         , 	sheet)
}

def static "appTest.LogOut.logOut"(
    	ExtentTest test	
     , 	String name	) {
    (new appTest.LogOut()).logOut(
        	test
         , 	name)
}
