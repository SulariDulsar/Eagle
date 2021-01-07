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
import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import internal.GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver as WebDriver

public class RunAsync {

	ExtentTest test

	@Keyword
	def start(String name,WebDriver driver,HashMap<String,ExtentTest> testCaseList){

		Thread.start{

			String groupName = findTestData("testData").getValue(2, 1)
			String overviewPageLoadingTest = findTestData("testCases").getValue(1, 1)
			String overviewPageLoadingTestFlag =  findTestData("testCases").getValue(2, 1)

			println("testOverviewPage" + overviewPageLoadingTest)
			println("testOverviewPageFlag" + overviewPageLoadingTestFlag)
			println("groupName " + groupName)

			if(overviewPageLoadingTestFlag == "true"){
				test = testCaseList.get("overviewPageLoadingTest")
				(new util.OpenBrowser()).openBrowser(driver,test)
				(new support.ImplicitWait()).delayFor(10)

				(new appTest.ReadingAndApprovalPageLoading()).readingAndApprovalPageLoading(name,test)
				(new support.ImplicitWait()).delayFor(5)

				(new support.Report()).getInstance().endReportTest(test)
			}

			String refreshAndLoadOverviewPageTest = findTestData("testCases").getValue(1, 6)
			String refreshAndLoadOverviewPageTestFlag =  findTestData("testCases").getValue(2, 6)

			println("refreshAndLoadOverviewPageTestFlag" + refreshAndLoadOverviewPageTestFlag)
			println("refreshAndLoadOverviewPageTest" + refreshAndLoadOverviewPageTest)

			if(refreshAndLoadOverviewPageTestFlag == "true"){
				test = testCaseList.get("refreshAndLoadOverviewPageTest")
				println("overview page load " + refreshAndLoadOverviewPageTest)

				(new appTest.VerifyResponseTimeForRefreshpageLoading()).verifyResponseTimeForRefreshpageLoading('Object Repository/overviewPages/readingAndApprova/tableRow', name, test)
				(new support.Report()).getInstance().endReportTest(test)
			}


			String searchWithGroupTypeTest = findTestData("testCases").getValue(1, 2)
			String searchWithGroupTypeTestFlag =  findTestData("testCases").getValue(2, 2)

			println("searchWithGroupTypeTestFlag" + searchWithGroupTypeTestFlag)
			println("searchWithGroupTypeTest" + searchWithGroupTypeTest)

			if(searchWithGroupTypeTestFlag == "true"){
				test = testCaseList.get("searchWithGroupTypeTest")
				println("testSearch inside " + searchWithGroupTypeTest)
				//search with  group type
				(new appTest.SearchOverviewPage()).searchOnlyWithGroupType('Object Repository/overviewPages/readingAndApprova/matrixFormNormal',name,test)

				(new support.Report()).getInstance().endReportTest(test)
			}


			String dataScreenPageLoadingTest = findTestData("testCases").getValue(1,3)
			String dataScreenPageLoadingTestFlag =  findTestData("testCases").getValue(2, 3)

			println("DataScreenPageLoadingTestFlag" + dataScreenPageLoadingTestFlag)
			println("DataScreenPageLoadingTest" + dataScreenPageLoadingTest)


			if(dataScreenPageLoadingTestFlag == "true"){
				test = testCaseList.get("dataScreenPageLoadingTest")

				//search with  group name
				(new appTest.SearchOverviewPage()).searchOnlyWithGroupName( 'Object Repository/overviewPages/readingAndApprova/groupName', name, groupName, test)

				//verify data screen page loading
				(new appTest.DataScreenPageLoaging()).dataScreenPageLoaging('Object Repository/overviewPages/readingAndApprova/nameHyperLink', 'text', 'equals', groupName, false,test,name)

				(new support.Report()).getInstance().endReportTest(test)
			}

			String openApplicationInNewTabTest = findTestData("testCases").getValue(1,4)
			String openApplicationInNewTabTestFlag =  findTestData("testCases").getValue(2, 4)

			if(openApplicationInNewTabTestFlag == "true"){
				test = testCaseList.get("openApplicationInNewTabTest")

				//verify response time for opening application in new tab
				(new appTest.OpenApplicationInNewTab()).openApplicationInNewTab(findTestData("testData").getValue(1,1),test,name)

				(new support.Report()).getInstance().endReportTest(test)
			}

			String navigateToOverviewPageFromOtherPageTest = findTestData("testCases").getValue(1,5)
			String navigateToOverviewPageFromOtherPageTestFlag =  findTestData("testCases").getValue(2, 5)

			if(navigateToOverviewPageFromOtherPageTestFlag == "true"){
				test = testCaseList.get("navigateToOverviewPageFromOtherPageTest")

				//verify response time for loading overview page from meter overview page
				(new appTest.NavigateToOverviewPageFromOtherPage()).navigateToOverviewPageFromOtherPage(name, test)

				(new support.Report()).getInstance().endReportTest(test)
			}

			(new appTest.LogOut()).logOut(test,name)

			(new support.ImplicitWait()).delayFor(5)
			(new util.Counter()).getInstance().increaseThreadCounter()
		}
	}
}
