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

import internal.GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.edge.EdgeDriver as EdgeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import com.katalon.plugin.keyword.extentReport.Extent as Ext
import com.relevantcodes.extentreports.ExtentReports as ExtentReports
import com.relevantcodes.extentreports.ExtentTest as ExtentTest

public class CreateDriver {

	@Keyword
	def createDriver(HashMap<String,ExtentTest> testCaseList ){
		int n = Integer.parseInt(findTestData("testData").getValue(14,1))
		print("n" +n)

		if(findTestData("testData").getValue(13,1) == "chrome"){

			for(int i=1;i<n;i++){
				String name = "Test"+i
				WebDriver driver  = new ChromeDriver()
				(new util.RunAsync()).start(name, driver,testCaseList)
			}


			//(new util.OpenBrowser()).openBrowser(findTestData("testData").getValue(1,1))
		}

		else if(findTestData("testData").getValue(13,1) == "edge"){

			System.setProperty('webdriver.edge.driver','C:\\workspace\\Eagle\\msedgedriver.exe')

			for(int i=1;i<=n;i++){
				String name = "Instance-"+i
				WebDriver driver  = new EdgeDriver()
				(new util.RunAsync()).start(name, driver,testCaseList)
			}

			int x = (new util.Counter()).getInstance().getThreadCount()
			print("name : " +x)

			while((new util.Counter()).getInstance().getThreadCount() <= n){

				int y = (new util.Counter()).getInstance().getThreadCount()
				print("getCOunt : " +y)

				(new support.ImplicitWait().delayFor(5))
			}
		}
	}
}
