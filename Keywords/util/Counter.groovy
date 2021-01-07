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

public class Counter {
	int threadCount = 1
	private static Counter self

	private Counter(){
	}

	public static Counter getInstance() {
		if (self == null) {
			self = new Counter()
		}
		return self
	}

	public int getThreadCounter(){
		return threadCount
	}


	public void increaseThreadCounter(){
		threadCount++
		System.out.println("threadCount " +threadCount)
	}

	/*@Keyword
	 def getThreadCounter(){
	 return this.threadCount
	 }
	 @Keyword
	 def IncreaseThreadCounter(){
	 this.threadCount++
	 print("this.threadCount " + this.threadCount)
	 }
	 */
}
