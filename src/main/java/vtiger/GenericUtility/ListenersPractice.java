package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersPractice implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"=> test script execution started",true);
		test=report.createTest(methodname);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"=> is passed",true);
		test.log(Status.PASS,methodname+"=====> passed");
		
	}

	public void onTestFailure(ITestResult result) {
		JavaUtility jUtil=new JavaUtility();
		DriverUtility dUtil=new DriverUtility();
		//String msg = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"=> is failed because=> "+msg,true);
		test.log(Status.FAIL, methodname +"=====>failed");
		
		// this is will capture screenshot with date
		String ScreenShotName=methodname+"-"+jUtil.getSystemDateInFormat();
		//this will capture the screenshot and provide the screenshot and save it in file
		try
		{
			String path=dUtil.takesScreenShot(BaseClass.sdriver, ScreenShotName);
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
	
	}

	public void onTestSkipped(ITestResult result) {
		//String msg = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"=> is skipped because=> "+msg,true);
		test.log(Status.SKIP, methodname+"=====>Failed");
	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		// start of suite execution
		//configure the extent reports
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\extentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5 Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger execution Report");
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-Platform", "windows");
		report.setSystemInfo("Base-URL","http://localhost:8888");
		report.setSystemInfo("Reporter Name", "jaya");
		
}

	public void onFinish(ITestContext context) {
		// end of the suite
		report.flush();
		
		
	}

}
