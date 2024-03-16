/*
* @description This is the extent report listner class 
* We can customize the report by using this class 
*/

package extentReportListner;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNgAventStack{
	static ExtentReports extentReporter;
	public  static ExtentReports getReportObject()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String reportName=timeStamp+"reportAventStack.html";
		//String path=System.getProperty("user.dir")+"\\reports\\reportAventStack.html";
		String path=System.getProperty("user.dir")+"\\reports\\"+reportName;
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Test Result Assignment");
		extentSparkReporter.config().setDocumentTitle("Test Result");
		extentReporter=new ExtentReports();
		extentReporter.attachReporter(extentSparkReporter);
		extentReporter.setSystemInfo("Tester", "Dummy User");
		return extentReporter;
	}

}
