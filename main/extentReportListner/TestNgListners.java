/*
* @description This is the TestNg class
* We use this class to take screenshots on failures 
*/
package extentReportListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.TestBase;

public class TestNgListners extends TestBase implements ITestListener {
	ExtentReports exReport = ExtentReportNgAventStack.getReportObject();
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		String screenShotName = result.getMethod().getMethodName();
		Reporter.log(screenShotName + " : Test Case Started ");
		extentTest = exReport.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String screenShotName = result.getMethod().getMethodName();
		Reporter.log(screenShotName + " : Test Case End Successfully  ");
		extentTest.log(Status.PASS, "Test Passed");
		System.out.println("My test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if (!result.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/target/surefire-reports";
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
						+ formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(scrFile, destFile);
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
						+ "' height='100' width='100'/> </a>");
				extentTest.fail(result.getThrowable());
				// extentTest.addScreenCaptureFromPath("<a href='"+ destFile.getAbsolutePath() +
				// "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/>
				// </a>");
				extentTest.addScreenCaptureFromPath("<img src='" + destFile.getAbsolutePath() + "'/> </a>");

				System.out.println("Test case is Fail");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		exReport.flush();
	}

}
