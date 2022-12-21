package fundModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.BrowserSetup;
import pomClass.HomePage;
import pomClass.LoginPage;
import utilityClass.UtilClass;

public class VerifyUserCanAddFund {
    static WebDriver driver;
           LoginPage lp;
           HomePage hp;
           ExtentHtmlReporter htmlreporter ;
           ExtentReports reports;
           ExtentTest extenttest;
   
	@BeforeClass 
	public void beforeClass() {
		driver = BrowserSetup.getBrowser();
		htmlreporter= BrowserSetup.getextenthtmlreporter();
		reports= BrowserSetup.getextentreports();
		extenttest= BrowserSetup.getextenttest("VerifyUserCanAddFund");
	}
	
	@BeforeMethod
    public void beforeMethod() {
	   lp = new LoginPage(driver);	
	   hp = new HomePage(driver);
	   
	}
	
	
	@Test(priority=1)
    public void VerifyUserCanLogin() throws IOException, InterruptedException {
		lp.loginFunctinality();
		Thread.sleep(10000);
		Assert.assertEquals(lp.verifiedWithValidCredential(), "tester1","Login Unsuccessfully");
	
	}
	
	@Test(priority=2)
	
	public void VerifyUserCanAddFunds() throws IOException, InterruptedException {
		hp.clickOnFund();
		hp.clickOnAddFundButton();
		hp.ShiftOnPopup();
		hp.enterAmounts();
		Assert.assertEquals(hp.verfication(),"₹ 10", "not succsess");
	}
	
	
	@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			if(result.getStatus()==ITestResult.SUCCESS) {
				String path =UtilClass.getScreenshot(driver, result.getName());
				extenttest.log(Status.PASS, "test: "+ result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				
			}else if (result.getStatus()==ITestResult.FAILURE) {
				extenttest.log(Status.FAIL, "test: "+ result.getName());
			}else if (result.getStatus()==ITestResult.SKIP) {
				extenttest.log(Status.SKIP, "test: "+ result.getName());
			}
		}
	
	
	
	@AfterClass
    public void afterClass() {
		reports.flush();
	}
	
	
	
}
