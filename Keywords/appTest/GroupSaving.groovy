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
import org.apache.poi.xssf.usermodel.XSSFSheet;

import internal.GlobalVariable

import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.LogStatus
import com.relevantcodes.extentreports.ExtentTest
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook

public class GroupSaving {

	@Keyword
	def savingExistingDetailChanges(String element,String newValue,ExtentTest test,String name,String BeforeSearch,String imageAfterSearch,long responseTimeToSearchWithGroupName,Row row,String performaceExcelPath,XSSFWorkbook workbook,XSSFSheet sheet){

		//Verify Group page loading
		(new util.CommonEvents()).waitForElementPresent('Object Repository/group/headingEditGroup',100)

		//Update GroupDetail
		(new util.CommonEvents()).setStringvalue(element, newValue)

		long startTimeGroupSave = System.currentTimeMillis()

		//Click on save
		(new util.CommonEvents()).click('Object Repository/group/saveGroupBtn', FailureHandling.CONTINUE_ON_FAILURE)

		//Verify Group saving success
		(new util.CommonEvents()).waitForElementPresent('Object Repository/group/groupSavingConfirmationMsg',100)

		long endTimeGroupSaving = System.currentTimeMillis()

		File imageFileGroupSaving = (new support.ScreenShot()).takeScreenShot()


		long responseTimeGroupSaving = (new util.ResponseTimeCalculation()).responseTimeCalculation(startTimeGroupSave, endTimeGroupSaving)


		//Write to excel
		if(name == "Instance-1"){
			(new util.WriteExcel()).writeColumnToExcel(performaceExcelPath,responseTimeGroupSaving,row,workbook,sheet)

		}

		//Add screen shot to report
		int waitTime = (new util.GenerateRandomValue()).generateRandomIntValue()
		(new support.ImplicitWait()).delayFor(waitTime)

		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> Group Overview page search with Group Name", BeforeSearch, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Group Overview Page search with Group Name: " + "<h7 style='color:green;'><b> " +responseTimeToSearchWithGroupName+ " ms </h7></b>", imageAfterSearch, test)


		String imageGroupSaving =(new support.ScreenShot()).addScreenShotToReportUsingBase64(imageFileGroupSaving, test)
		(new support.Report()).getInstance().getResultStatus(LogStatus.INFO, "<h6><b> "+name+" </h6></b> ResponseTime for Group Saving: " + "<h7 style='color:green;'><b> " +responseTimeGroupSaving+" ms </h7></b>", imageGroupSaving, test)


	}
}
