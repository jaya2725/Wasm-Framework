package vtiger.Practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersPractice implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"=> test script execution started",true);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"=> is passed",true);
		
	}

	public void onTestFailure(ITestResult result) {
		String msg = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"=> is failed because=> "+msg,true);
	
	}

	public void onTestSkipped(ITestResult result) {
		String msg = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"=> is skipped because=> "+msg,true);
	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
