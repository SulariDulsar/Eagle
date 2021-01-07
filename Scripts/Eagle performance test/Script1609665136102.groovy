import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.katalon.plugin.keyword.extentReport.Extent as Ext
import com.relevantcodes.extentreports.ExtentReports as ExtentReports
import com.relevantcodes.extentreports.ExtentTest as ExtentTest

int n = Integer.parseInt(findTestData("testData").getValue(14, 1))

String overviewPageLoadingTestFlag =  findTestData("testCases").getValue(2, 1)
String refreshAndLoadOverviewPageTestFlag =  findTestData("testCases").getValue(2, 6)
String searchWithGroupTypeTestFlag =  findTestData("testCases").getValue(2, 2)
String dataScreenPageLoadingTestFlag =  findTestData("testCases").getValue(2, 3)
String openApplicationInNewTabTestFlag =  findTestData("testCases").getValue(2, 4)
String navigateToOverviewPageFromOtherPageTestFlag =  findTestData("testCases").getValue(2, 5)

HashMap<String,ExtentTest> testCaseList = new HashMap<String, ExtentTest>()

if(overviewPageLoadingTestFlag == "true"){
	ExtentTest overviewPageLoadingTest = (new support.Report()).getInstance().getReportTest("Overview page loading", "Verify overview page loading with" +n+ " number of users")
	testCaseList.put("overviewPageLoadingTest", overviewPageLoadingTest)
}

if(refreshAndLoadOverviewPageTestFlag == "true"){
	ExtentTest refreshAndLoadOverviewPageTest = (new support.Report()).getInstance().getReportTest("Refresh and load Overview page", "Verify refresh application and overview page loading with" +n+ " number of users")
	testCaseList.put("refreshAndLoadOverviewPageTest", refreshAndLoadOverviewPageTest)
}


if(searchWithGroupTypeTestFlag == "true"){
	ExtentTest searchWithGroupTypeTest = (new support.Report()).getInstance().getReportTest("Verify overview page search", "Verify overview page search with Group type with" +n+ " number of users")
	testCaseList.put("searchWithGroupTypeTest", searchWithGroupTypeTest)
}
if(dataScreenPageLoadingTestFlag == "true"){
	ExtentTest dataScreenPageLoadingTest = (new support.Report()).getInstance().getReportTest("Verify Data screen page loading", "Verify Data screen page loading for " +n+ " number of users")
	testCaseList.put("dataScreenPageLoadingTest", dataScreenPageLoadingTest)
}

if(openApplicationInNewTabTestFlag == 'true'){
	ExtentTest openApplicationInNewTabTest = (new support.Report()).getInstance().getReportTest("Verify opening eagle app in new tab", "Verify Dopening eagle app in new tabs for " +n+ " number of users")
	testCaseList.put("openApplicationInNewTabTest", openApplicationInNewTabTest)
}

if(navigateToOverviewPageFromOtherPageTestFlag == 'true'){
	ExtentTest navigateToOverviewPageFromOtherPageTest = (new support.Report()).getInstance().getReportTest("Verify navigating to overview page from other page", "Verify navigating to overview page from other page " +n+ " number of users")
	testCaseList.put("navigateToOverviewPageFromOtherPageTest", navigateToOverviewPageFromOtherPageTest)
}

(new util.CreateDriver()).createDriver(testCaseList)





