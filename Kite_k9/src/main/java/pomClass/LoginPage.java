package pomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.UtilClass;

public class LoginPage extends UtilClass {
	WebDriver driver;
	
	@FindBy (xpath ="//input[@id='userid']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath ="//button[@type='submit']")
	private WebElement submit;
	
	@FindBy (xpath ="//span[text()='Piyush']")
	private WebElement name;
	
	
	public LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public void loginFunctinality() throws IOException {
		username.sendKeys(UtilClass.getConfigData("id"));
		password.sendKeys(UtilClass.getConfigData("password"));
		submit.click();
		
	}
	
	public String verifiedWithValidCredential () {
	String customerName	= name.getText();
		return customerName;
	}
	
}
