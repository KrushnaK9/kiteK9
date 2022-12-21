package listenerClass;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.BrowserSetup;

public class Listener implements ITestListener{

	ExtentTest extenttest;
	
	public void ontestStart(ITestResult result) {
		extenttest= BrowserSetup.getalreadyexistingtest();
		extenttest.log(Status.INFO, "test:TestStarted" + result.getName());
	}
	public void ontestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, "test:TestStarted" + result.getName());
	}
    public void ontestFailure(ITestResult result) {
    	extenttest.log(Status.FAIL, "test:TestStarted" + result.getName());
	}
    public void ontestSkip(ITestResult result) {
    	extenttest.log(Status.SKIP, "test:TestStarted" + result.getName());
}

	
}
