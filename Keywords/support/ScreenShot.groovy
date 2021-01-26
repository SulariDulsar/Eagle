package support

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
import com.relevantcodes.extentreports.LogStatus
import com.relevantcodes.extentreports.ExtentTest
import internal.GlobalVariable
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import ru.yandex.qatools.ashot.Screenshot
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import javax.imageio.ImageIO as ImageIO
import org.apache.commons.io.FileUtils
import java.text.SimpleDateFormat

public class ScreenShot {

	File imageFile
	String imageName
	String imagePath

	@Keyword
	def takeScreenShot() {

		String folderPathReport = (new support.Report()).getInstance().getFolderPath()
		imageName = "screenshot"+ (new util.GenerateRandomValue()).generateRandomValu()
		imagePath = WebUI.takeScreenshot(folderPathReport  + imageName + '.png')

		imageFile = new File(imagePath)


		return imageFile
	}


	@Keyword
	def takeFullScreenShot() {

		WebDriver driver = DriverFactory.getWebDriver()

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver)

		String folderPathReport = (new support.Report()).getInstance().getFolderPath()

		String imageName = "screenshot"+ (new util.GenerateRandomValue()).generateRandomValu()
		String imagePath = folderPathReport + imageName + '.png'
		File imageFile = new File(imagePath)
		ImageIO.write(screenshot.getImage(), "PNG",imageFile )

		println("imagePath full screen "+imagePath)



		return imageFile
	}


	@Keyword
	def addScreenCapture(String imagePath,ExtentTest test) {

		String image = test.addScreenCapture(imagePath)

		return image
	}


	//Add screen shot to report new
	public String addScreenShotToReportUsingBase64(File imageFile,ExtentTest test) throws Exception {

		String encodedBase64 = null;

		try {
			FileInputStream fileInputStreamReader = new FileInputStream(imageFile);
			byte[] bytes = new byte[(int)imageFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.getEncoder().encode(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String imageString = test.addBase64ScreenShot("data:image/png;base64,"+encodedBase64);
		return imageString ;

	}
}
