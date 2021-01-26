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
import java.text.SimpleDateFormat

int n = Integer.parseInt(findTestData("testData").getValue(14, 1))
String stagingRespons = "[MK2] Staging Response Time is around :  "
String stagingResponseTime

String overviewPageLoadingTestFlag =  findTestData("testCases").getValue(2, 1)
String refreshAndLoadOverviewPageTestFlag =  findTestData("testCases").getValue(2, 6)
String searchWithGroupTypeTestFlag =  findTestData("testCases").getValue(2, 2)
String dataScreenPageLoadingTestFlag =  findTestData("testCases").getValue(2, 3)
String dataScreenGetDataLoadingTestFlag = findTestData("testCases").getValue(2, 8)
String openApplicationInNewTabTestFlag =  findTestData("testCases").getValue(2, 4)
String navigateToOverviewPageFromOtherPageTestFlag =  findTestData("testCases").getValue(2, 5)
String groupSavingFlag =  findTestData("testCases").getValue(2, 7)

HashMap<String,ExtentTest> testCaseList = new HashMap<String, ExtentTest>()

if(overviewPageLoadingTestFlag == "true"){
	stagingResponseTime= stagingRespons + findTestData("testCases").getValue(3, 1)

	ExtentTest overviewPageLoadingTest = (new support.Report()).getInstance().getReportTest("Verify overview page loading with " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("overviewPageLoadingTest", overviewPageLoadingTest)
}

if(refreshAndLoadOverviewPageTestFlag == "true"){
	stagingResponseTime= stagingRespons + findTestData("testCases").getValue(3, 6)
	
	ExtentTest refreshAndLoadOverviewPageTest = (new support.Report()).getInstance().getReportTest("Verify refresh application and overview page loading with " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("refreshAndLoadOverviewPageTest", refreshAndLoadOverviewPageTest)
}
if(searchWithGroupTypeTestFlag == "true"){
	stagingResponseTime = stagingRespons + findTestData("testCases").getValue(3, 2)
				
	ExtentTest searchWithGroupTypeTest = (new support.Report()).getInstance().getReportTest("Verify overview page search with Group type with " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("searchWithGroupTypeTest", searchWithGroupTypeTest)
}
if(dataScreenPageLoadingTestFlag == "true"){
	stagingResponseTime = stagingRespons + findTestData("testCases").getValue(3, 3)
	
	ExtentTest dataScreenPageLoadingTest = (new support.Report()).getInstance().getReportTest("Verify Data screen page loading for " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("dataScreenPageLoadingTest", dataScreenPageLoadingTest)
}
if(dataScreenGetDataLoadingTestFlag == "true"){
	stagingResponseTime = stagingRespons + findTestData("testCases").getValue(3, 8)
	
	ExtentTest dataScreenGetDataLoadingTest = (new support.Report()).getInstance().getReportTest("Verify Data screen page data loading by clicking on GetData btton for " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("dataScreenGetDataLoadingTest", dataScreenGetDataLoadingTest)
}
if(openApplicationInNewTabTestFlag == 'true'){
	stagingResponseTime = stagingRespons + findTestData("testCases").getValue(3, 4)
	
	ExtentTest openApplicationInNewTabTest = (new support.Report()).getInstance().getReportTest("Verify opening eagle app in new tabs for " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("openApplicationInNewTabTest", openApplicationInNewTabTest)
}

if(navigateToOverviewPageFromOtherPageTestFlag == 'true'){
	stagingResponseTime = stagingRespons + findTestData("testCases").getValue(3, 5)
	
	ExtentTest navigateToOverviewPageFromOtherPageTest = (new support.Report()).getInstance().getReportTest("Verify navigating to overview page from other page " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("navigateToOverviewPageFromOtherPageTest", navigateToOverviewPageFromOtherPageTest)
}

if(groupSavingFlag == 'true'){
	stagingResponseTime = stagingRespons + findTestData("testCases").getValue(3, 7)
	
	ExtentTest groupSavingTest = (new support.Report()).getInstance().getReportTest("Verify group saving for " +n+ " Instance", "<h5 style='color:green;'><b>" +stagingResponseTime+ "</h5></b>")
	testCaseList.put("groupSavingTest", groupSavingTest)
}

(new util.CreateDriver()).createDriver(testCaseList)





