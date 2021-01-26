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
import com.relevantcodes.extentreports.LogStatus
import internal.GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import javax.swing.text.html.HTMLEditorKit;
import org.apache.poi.ss.usermodel.Row;
import util.Model

public class RunAsync {

	ExtentTest test

	@Keyword
	def start(String name,WebDriver driver,HashMap<String,ExtentTest> testCaseList){

		String performaceExcelPath= findTestData("report").getValue(6, 1)
		//List<Row> rowDetails = (new util.WriteExcel()).getNumOfRowInSheet(performaceExcelPath)
		Model m1 = (new util.WriteExcel()).getNumOfRowInSheet(performaceExcelPath)

		(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,0,m1.getRowDetails().get(0),m1.getWorkbook(),m1.getSheet())



		Thread.start{

			String groupName = findTestData("testData").getValue(2, 1)
			String overviewPageLoadingTest = findTestData("testCases").getValue(1, 1)
			String overviewPageLoadingTestFlag =  findTestData("testCases").getValue(2, 1)

			println("testOverviewPage" + overviewPageLoadingTest)
			println("testOverviewPageFlag" + overviewPageLoadingTestFlag)
			println("groupName " + groupName)

			if(overviewPageLoadingTestFlag == "true"){
				test = testCaseList.get("overviewPageLoadingTest")
				String imageLoginPage = (new util.OpenBrowser()).openBrowser(name,driver,test)
				(new support.ImplicitWait()).delayFor(10)

				(new appTest.ReadingAndApprovalPageLoading()).readingAndApprovalPageLoading(name,imageLoginPage,m1.getRowDetails().get(1),performaceExcelPath,test,m1.getWorkbook(),m1.getSheet())
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
				println("test " + test)

				(new appTest.VerifyResponseTimeForRefreshpageLoading()).verifyResponseTimeForRefreshpageLoading('Object Repository/overviewPages/readingAndApprova/tableRow', name,m1.getRowDetails().get(2),performaceExcelPath,test,m1.getWorkbook(),m1.getSheet())

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
				(new appTest.SearchOverviewPage()).searchOnlyWithGroupType('Object Repository/overviewPages/readingAndApprova/matrixFormNormal',name,m1.getRowDetails().get(3),performaceExcelPath,test,m1.getWorkbook(),m1.getSheet())

				(new support.Report()).getInstance().endReportTest(test)
			}


			String dataScreenPageLoadingTest = findTestData("testCases").getValue(1,3)
			String dataScreenPageLoadingTestFlag =  findTestData("testCases").getValue(2, 3)

			println("DataScreenPageLoadingTestFlag" + dataScreenPageLoadingTestFlag)
			println("DataScreenPageLoadingTest" + dataScreenPageLoadingTest)


			if(dataScreenPageLoadingTestFlag == "true"){
				test = testCaseList.get("dataScreenPageLoadingTest")

				//search with  group name
				Model m = (new appTest.SearchOverviewPage()).searchOnlyWithGroupName( 'Object Repository/overviewPages/readingAndApprova/groupName', name, groupName, test)
				String imageBeforeSearch= m.getImage1()
				String imageAfterSearch= m.getImage2()
				long  responseTimeToSearchWithGroupName = m.getResponseTime()

				//verify data screen page loading
				(new appTest.DataScreenPageLoaging()).dataScreenPageLoaging('Object Repository/overviewPages/readingAndApprova/nameHyperLink', 'text', 'equals', groupName, false,test,name,imageBeforeSearch,imageAfterSearch,responseTimeToSearchWithGroupName,m1.getRowDetails().get(4),performaceExcelPath,m1.getWorkbook(),m1.getSheet())


				(new support.Report()).getInstance().endReportTest(test)
			}

			String dataScreenGetDataLoadingTest = findTestData("testCases").getValue(1,8)
			String dataScreenGetDataLoadingTestFlag =  findTestData("testCases").getValue(2, 8)

			println("dataScreenGetDataLoadingTestFlag" + dataScreenGetDataLoadingTestFlag)
			println("dataScreenGetDataLoadingTest" + dataScreenGetDataLoadingTest)

			if(dataScreenGetDataLoadingTestFlag == "true"){
				test = testCaseList.get("dataScreenGetDataLoadingTest")

				//verify data screen page loading
				(new appTest.DataScreenGetDataLoading()).dataScreenGetDataLoading(name,m1.getRowDetails().get(5),m1.getRowDetails().get(6),m1.getRowDetails().get(7),performaceExcelPath,m1.getWorkbook(),m1.getSheet(),driver,test)


				(new support.Report()).getInstance().endReportTest(test)
			}

			String openApplicationInNewTabTest = findTestData("testCases").getValue(1,4)
			String openApplicationInNewTabTestFlag =  findTestData("testCases").getValue(2, 4)

			if(openApplicationInNewTabTestFlag == "true"){
				test = testCaseList.get("openApplicationInNewTabTest")

				//verify response time for opening application in new tab
				(new appTest.OpenApplicationInNewTab()).openApplicationInNewTab(findTestData("testData").getValue(1,1),test,name,m1.getRowDetails().get(8),performaceExcelPath,m1.getWorkbook(),m1.getSheet())

				(new support.Report()).getInstance().endReportTest(test)
			}

			String navigateToOverviewPageFromOtherPageTest = findTestData("testCases").getValue(1,5)
			String navigateToOverviewPageFromOtherPageTestFlag =  findTestData("testCases").getValue(2, 5)

			if(navigateToOverviewPageFromOtherPageTestFlag == "true"){
				test = testCaseList.get("navigateToOverviewPageFromOtherPageTest")

				//verify response time for loading overview page from meter overview page
				(new appTest.NavigateToOverviewPageFromOtherPage()).navigateToOverviewPageFromOtherPage(name,test,m1.getRowDetails().get(9),performaceExcelPath,m1.getWorkbook(),m1.getSheet())

				(new support.Report()).getInstance().endReportTest(test)
			}

			String groupSavingTest = findTestData("testCases").getValue(1,7)
			String groupSavingFlag =  findTestData("testCases").getValue(2, 7)

			if(groupSavingFlag == "true"){
				test = testCaseList.get("groupSavingTest")

				//Click on Group Tab
				(new util.CommonEvents()).click('Object Repository/masterData/groupTab', FailureHandling.CONTINUE_ON_FAILURE)

				Model m = (new appTest.SearchGroupOverview()).searchOnlyWithGroupName( 'Object Repository/overviewPages/groupOverview/overviewNameTxt', name, groupName, test)
				String imageBeforeSearch= m.getImage1()
				String imageAfterSearch= m.getImage2()
				long  responseTimeToSearchWithGroupName = m.getResponseTime()

				//Click on name hyperLink
				(new util.CommonEvents()).clickHyperLink('Object Repository/overviewPages/groupOverview/nameHyperLink','text','equals',groupName,false)

				//verify response time for group saving
				(new appTest.GroupSaving()).savingExistingDetailChanges('Object Repository/group/groupDescription',"Description Changed",test,name, imageBeforeSearch,imageAfterSearch,responseTimeToSearchWithGroupName,m1.getRowDetails().get(10),performaceExcelPath,m1.getWorkbook(),m1.getSheet())

				(new support.Report()).getInstance().endReportTest(test)
			}

			(new appTest.LogOut()).logOut(test,name)

			(new support.ImplicitWait()).delayFor(5)
			(new util.Counter()).getInstance().increaseThreadCounter()
		}
	}
}
