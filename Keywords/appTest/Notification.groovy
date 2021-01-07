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

import org.json.JSONObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Notification {

	JSONObject returnValue
	int i= 1
	JSONObject returnNotificationCount = new JSONObject()

	@Keyword
	def verifyNotificationCount(){

		int intNotificationCount = 0;
		int returnCurrentNotificationCount = 0;

		//Take notification count before request processed
		String currentNotificationCount = (new util.CommonEvents()).getText('Object Repository/notification/notificationCount', FailureHandling.CONTINUE_ON_FAILURE)
		//int returnCurrentNotificationCount = 0;
		println("count" + currentNotificationCount);

		if(currentNotificationCount != null && !currentNotificationCount.equalsIgnoreCase("") ){
			returnCurrentNotificationCount = Integer.valueOf(currentNotificationCount)
		}

		boolean condition = true
		int count = 0
		String notificationCount = 0

		while (condition){
			notificationCount = (new util.CommonEvents()).getText('Object Repository/notification/notificationCount', FailureHandling.CONTINUE_ON_FAILURE)

			//Convert string count to integer
			//int intNotificationCount = 0;
			if(notificationCount != null && !notificationCount.equalsIgnoreCase("")){
				intNotificationCount = Integer.valueOf(notificationCount)
			}
			println("count" + intNotificationCount);

			//Convert string count to integer
			if(intNotificationCount == (returnCurrentNotificationCount+1)){
				condition = false

			}else{
				(new support.ExplicitWait()).waitForElementVisible('Object Repository/notification/notificationCount', 50, FailureHandling.CONTINUE_ON_FAILURE)
				count++
				if(count == 4){
					break
					KeywordUtil.markError("Notification didn't received")
				}
			}

		}

		println("intNotificationCount" + intNotificationCount)
		println("returnCurrentNotificationCount" + returnCurrentNotificationCount)

		//verify notification count after request processed
		(new util.CommonEvents()).verifyElementText('Object Repository/notification/notificationCount', Integer.toString(returnCurrentNotificationCount +1),'Verify notification count after request proceessed')
		println("text")

		returnNotificationCount.put("intNotificationCount", intNotificationCount)
		returnNotificationCount.put("returnCurrentNotificationCount", returnCurrentNotificationCount)

		println("intNotificationCount" + intNotificationCount)
		println("returnCurrentNotificationCount" + returnCurrentNotificationCount)

		return returnNotificationCount
	}

	@Keyword
	def verifyNotificationContent(String meterName ){

		/*//NotificationList
		 String list = (new util.CommonEvents()).getText('Object Repository/Test1_OR/Notification/NotificationList', FailureHandling.CONTINUE_ON_FAILURE)
		 println("list : " + list)*/

		List<String> notificationList = Lists.newArrayList()
		boolean visibiltyCheknotification = true
		String notificationMessage
		int notificationCount

		//Verify notification text
		(new util.CommonEvents()).click('Object Repository/notification/notificationIcon', FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(5)

		//Take screen shot
		(new support.ScreenShot()).takeScreenShot()
		(new support.ImplicitWait()).delayFor(2)

		//Get PropertyValue , Create dynamic xpath and add to propertyValue
		returnValue = (new util.CommonEvents()).getPropertyValue('Object Repository/notification/notificationList',"["+i+"]")
		visibiltyCheknotification = (new util.CommonEvents()).verifyDynamicElementVisibleCheck(returnValue.get("validXpath"), FailureHandling.OPTIONAL)

		while (visibiltyCheknotification){

			notificationMessage  = (new util.CommonEvents()).getDynamicText(returnValue.get("validXpath"), FailureHandling.OPTIONAL)
			notificationList.add(notificationMessage)

			println ("Notification : " + notificationMessage)

			try{

				returnValue = (new util.CommonEvents()).getPropertyValue('Object Repository/notification/notificationList',"["+i+"]")
				visibiltyCheknotification = (new util.CommonEvents()).verifyDynamicElementVisibleCheck(returnValue.get("validXpath"), FailureHandling.OPTIONAL)
				i++
			}catch(Exception e){
				KeywordUtil.markWarning("Notification not found" + e)
			}


		}

		try{
			if(notificationMessage != null){
				String[] list = notificationMessage.split("\n")
				//(new util.CommonEvents()).verifyEqual(list[0], 'Saving of template '+meterName+' completed successfully',FailureHandling.OPTIONAL)
				//(new util.CommonEvents()).verifyEqualWithoutFailureHandling(list[0], 'Saving of template '+meterName+' completed successfully')
				(new util.CommonEvents()).verifyEqual(list[0], 'Saving of template '+meterName+' completed successfully',FailureHandling.CONTINUE_ON_FAILURE)

				notificationCount = (i-1)
			}

		}catch(com.kms.katalon.core.exception.StepFailedException e1){
			KeywordUtil.markError("Didn't receved notification message" + e1)
			notificationCount = 0
		}catch(Exception e){
			KeywordUtil.markError("Notification message is different from expected" + e)
		}


		return notificationCount


	}

	@Keyword
	def clickLatestNotification(int i){

		//Click on latest notification
		returnValue = (new util.CommonEvents()).getPropertyValue('Object Repository/notification/notificationList',"["+i+"]")

		(new util.CommonEvents()).clickDynamicElement(returnValue.get("validXpath"), FailureHandling.CONTINUE_ON_FAILURE)
		//(new support.ExplicitWait()).waitForElementVisible('Object Repository/EagleObjectRepo/Meter-Create new/MeterLocation/LocationTextBox', 50, FailureHandling.CONTINUE_ON_FAILURE)
		(new support.ImplicitWait()).delayFor(2)

	}
}
