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

import internal.GlobalVariable
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart
import java.util.*


public class SendEmail {
	private static SendEmail self
	private String userName
	private String mailPass

	private SendEmail() {
		userName = findTestData("report").getValue(3,1)
		mailPass = findTestData("report").getValue(4,1)
	}

	public static SendEmail getInstance() {
		if (self == null) {
			self = new SendEmail();
		}

		return self;
	}


	public void sendEmailWithAttachments() {
		try {
			// sets SMTP server properties
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.user", userName);
			properties.put("mail.password", mailPass);

			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
						public PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(userName, mailPass);
						}
					};

			Session session = Session.getInstance(properties, auth);

			// creates a new e-mail message
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(userName));
			String[] emails = findTestData("report").getValue(5,1).split(",");
			List<String> emailList = Arrays.asList(emails);

			InternetAddress[] toAddresses = new InternetAddress[emailList.size()];
			for (int i = 0; i < emailList.size(); i++) {
				System.out.println("Recipient[" + i + "]  " +emailList.get(i));
				toAddresses[i] = new InternetAddress(emailList.get(i));
			}

			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject("Eagle Performance Test Result");
			msg.setSentDate(new Date());

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h3 style='color:green;'> Please refer the attachment </h3>", "text/html");
			String encodedFilename = URLEncoder.encode(Report.getInstance().getReportPath(), "UTF-8").replace("+", "%20");
			messageBodyPart.setContent("<a href=" + encodedFilename + "> click</a>","text/html");
			println("encodedFilename > " +encodedFilename)


			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// adds attachments
			MimeBodyPart attachPart = new MimeBodyPart();

			try {
				//attachPart.attachFile(Report.getInstance().getReportPath());
				//Attached performance report excel
				attachPart.attachFile(findTestData("report").getValue(6,1));

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			multipart.addBodyPart(attachPart);

			// sets the multi-part as e-mail's content
			msg.setContent(multipart);

			// sends the e-mail
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void sendOutLookEmailWithAttachments() {

		String userNameOutLook = findTestData("report").getValue(3,2)
		String mailPassOutLook = findTestData("report").getValue(4,2)
		try {
			// sets SMTP server properties
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp-mail.outlook.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.user", userNameOutLook);
			properties.put("mail.password", mailPassOutLook);

			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
						public PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(userNameOutLook, mailPassOutLook);
						}
					};

			Session session = Session.getInstance(properties, auth);

			// creates a new e-mail message
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(userNameOutLook));
			String[] emails = findTestData("report").getValue(5,2).split(",");
			List<String> emailList = Arrays.asList(emails);

			InternetAddress[] toAddresses = new InternetAddress[emailList.size()];
			for (int i = 0; i < emailList.size(); i++) {
				System.out.println("Recipient[" + i + "]  " +emailList.get(i));
				toAddresses[i] = new InternetAddress(emailList.get(i));
			}

			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject("Eagle Performance Test Result");
			msg.setSentDate(new Date());

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			//messageBodyPart.setContent("<h3 style='color:green;'> Please refer the attachment </h3>", "text/html");
			//messageBodyPart.setContent("<a href=" + Report.getInstance().getReportPath()+ "> Please Click on link to view report</a>","text/html");
			String encodedFilename = URLEncoder.encode(Report.getInstance().getReportPath(), "UTF-8");
			messageBodyPart.setContent("<h5> <b> File Path = </b>" + Report.getInstance().getReportPath() + "</h5> <br> " + "<a Content-Type='text/html; charset=utf-8' href=" + Report.getInstance().getReportPath().replaceAll(" ","%20") + "> Please Click on link to view report</a>","text/html; charset=UTF-8");
			println("encodedFilename > " +encodedFilename)

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);



			try {
				// adds attachments
				 MimeBodyPart attachPart = new MimeBodyPart();
				 //attachPart.attachFile(Report.getInstance().getReportPath());
				 
				//Attached performance report excel
				attachPart.attachFile(findTestData("report").getValue(6,1));
				
				multipart.addBodyPart(attachPart);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			// sets the multi-part as e-mail's content
			msg.setContent(multipart);

			// sends the e-mail
			Transport.send(msg);
			println("mail sent")

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


