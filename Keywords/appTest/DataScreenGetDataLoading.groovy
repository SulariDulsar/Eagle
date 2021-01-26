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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.By

public class DataScreenGetDataLoading {
	
	@Keyword
	def dataScreenGetDataLoading(String name,Row row1,Row row2,Row row3,String performaceExcelPath,XSSFWorkbook workbook,XSSFSheet sheet,WebDriver driver,ExtentTest test){
		long responseTimeMonth
		long responseTimeDay
		long responseTimeYear
		File dayImageFile
		File monthImageFile
		File yearImageFile

		(new util.CommonEvents()).click('Object Repository/dataScreen/datePicker', FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait().delayFor(5))

		(new util.CommonEvents()).click('Object Repository/dataScreen/dateSelectionBtn', FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait().delayFor(5))
	
		if(findTestData("testData").getValue(3,1)== "day"){
			int i = 2;
			String periodDay = findTestData("testData").getValue(4,1)
			String [] periodArray= periodDay.split(",")
	

			while(i>=0){
				//WebDriverWait wait = new WebDriverWait(driver,10);
				WebElement dateWidget = driver.findElement(By.className('mat-calendar-content'))
				List<WebElement> rows= dateWidget.findElements(By.tagName("td"));

				for (WebElement cell1: rows){
					if (cell1.getText().equals(periodArray[i])){
						cell1.click()
						i--
						break;
					}
				}
			}
			
			
			
			long startTimeDay = System.currentTimeMillis()
			(new util.CommonEvents()).click('Object Repository/dataScreen/getDataBtn', FailureHandling.CONTINUE_ON_FAILURE)
			
			//Verify data screen data loading
			(new util.CommonEvents()).waitForElementPresent('Object Repository/dataScreen/periodHeader', 120)
			long endTimeDay = System.currentTimeMillis()
			
			dayImageFile = (new support.ScreenShot()).takeScreenShot()
			responseTimeDay = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTimeDay, endTimeDay)

		}
		
		if(findTestData("testData").getValue(3,2)== "month"){
			
			String groupName = findTestData("testData").getValue(2,2)
			
			//Click on overview tab
			(new util.CommonEvents()).click('Object Repository/overviewPages/readingAndApprova/overViewTab', FailureHandling.CONTINUE_ON_FAILURE)
			
			//Search with group name
			(new appTest.SearchOverviewPage()).searchOnlyWithGroupName( 'Object Repository/overviewPages/readingAndApprova/groupName', name, groupName, test)
			
			//Click on name hyperLink
			
			//modify hyper link testObject according to the group name
			TestObject testObjectHyperLink = (new util.CommonEvents()).modifyObjectProperty('Object Repository/overviewPages/readingAndApprova/nameHyperLink','text', 'equals', groupName, false)
	
			(new util.CommonEvents()).clickDynamicElement(testObjectHyperLink, FailureHandling.CONTINUE_ON_FAILURE)
			(new support.ImplicitWait()).delayFor(2)
			
			(new util.CommonEvents()).click('Object Repository/dataScreen/datePicker', FailureHandling.CONTINUE_ON_FAILURE)
			(new support.ImplicitWait().delayFor(5))
	
			
			int i = 1;
			String periodMonth = findTestData("testData").getValue(4,2)
			String [] periodArray= periodMonth.split(",")
				
			while(i>=0){
							
				WebElement dateWidget = driver.findElement(By.className('mat-calendar-content'))
				List<WebElement> rows= dateWidget.findElements(By.tagName("td"));
			
				for (WebElement cell1: rows){
					if (cell1.getText().equals(periodArray[i])){
							cell1.click()
							i--
							break;
					}
				}
			}
			
			long startTimeMonth = System.currentTimeMillis()
			(new util.CommonEvents()).click('Object Repository/dataScreen/getDataBtn', FailureHandling.CONTINUE_ON_FAILURE)
			
			//Verify data screen data loading
			(new util.CommonEvents()).waitForElementPresent('Object Repository/dataScreen/periodHeader', 120)
			long endTimeMonth = System.currentTimeMillis()
			
			monthImageFile = (new support.ScreenShot()).takeScreenShot()
			responseTimeMonth = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTimeMonth, endTimeMonth)
			
		}

		if(findTestData("testData").getValue(3,3)== "year"){
			
			String groupName = findTestData("testData").getValue(2,3)
			
			//Click on overview tab
			(new util.CommonEvents()).click('Object Repository/overviewPages/readingAndApprova/overViewTab', FailureHandling.CONTINUE_ON_FAILURE)
			
			//Search with group name
			(new appTest.SearchOverviewPage()).searchOnlyWithGroupName( 'Object Repository/overviewPages/readingAndApprova/groupName', name, groupName, test)
			
			//Click on name hyperLink
			
			//modify hyper link testObject according to the group name
			TestObject testObjectHyperLink = (new util.CommonEvents()).modifyObjectProperty('Object Repository/overviewPages/readingAndApprova/nameHyperLink','text', 'equals', groupName, false)
	
			(new util.CommonEvents()).clickDynamicElement(testObjectHyperLink, FailureHandling.CONTINUE_ON_FAILURE)
			(new support.ImplicitWait()).delayFor(2)
			
			(new util.CommonEvents()).click('Object Repository/dataScreen/datePicker', FailureHandling.CONTINUE_ON_FAILURE)
			(new support.ImplicitWait().delayFor(5))
	
			String periodYear = findTestData("testData").getValue(4,3)
			
			WebElement dateWidget = driver.findElement(By.className('mat-calendar-content'))
			List<WebElement> rows= dateWidget.findElements(By.tagName("td"));
			
				for (WebElement cell2: rows){
					if (cell2.getText().equals(periodYear)){
							cell2.click()
							break;
					}
				}
	
			
			long startTimeYear = System.currentTimeMillis()
			(new util.CommonEvents()).click('Object Repository/dataScreen/getDataBtn', FailureHandling.CONTINUE_ON_FAILURE)
			
			//Verify data screen data loading
			(new util.CommonEvents()).waitForElementPresent('Object Repository/dataScreen/periodHeader', 120)
			long endTimeYear = System.currentTimeMillis()
			
			yearImageFile = (new support.ScreenShot()).takeScreenShot()
			responseTimeYear = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTimeYear, endTimeYear)
			
		}
		

		//Write to excel
		if(name == "Instance-1"){
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTimeDay,row1,workbook,sheet)
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTimeMonth,row2,workbook,sheet)
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTimeYear,row3,workbook,sheet)

		}

		//Add screen shot to report
		int waitTime = (new util.GenerateRandomValue()).generateRandomIntValue()
		(new support.ImplicitWait()).delayFor(waitTime)

		
		String imageAfterDataScreenDataLoadDay = (new support.ScreenShot()).addScreenShotToReportUsingBase64(dayImageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Data screen page data loging for period = Day: " + "<h7 style='color:green;'><b> " +responseTimeDay+ " ms </h7></b>", imageAfterDataScreenDataLoadDay, test)

		String imageAfterDataScreenDataLoadMonth = (new support.ScreenShot()).addScreenShotToReportUsingBase64(monthImageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Data screen page data loging for period = Moth: " + "<h7 style='color:green;'><b> " +responseTimeMonth+ " ms </h7></b>", imageAfterDataScreenDataLoadMonth, test)

		String imageAfterDataScreenDataLoadYear = (new support.ScreenShot()).addScreenShotToReportUsingBase64(yearImageFile, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Data screen page data loging for period = Year: " + "<h7 style='color:green;'><b> " +responseTimeYear+ " ms </h7></b>", imageAfterDataScreenDataLoadYear, test)

		//Click on overview tab
		(new util.CommonEvents()).click('Object Repository/overviewPages/readingAndApprova/overViewTab', FailureHandling.CONTINUE_ON_FAILURE)

		//Clear search
		(new util.CommonEvents()).clearText('Object Repository/overviewPages/readingAndApprova/groupName', FailureHandling.CONTINUE_ON_FAILURE)


	}


}
