package pomClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.UtilClass;

public class HomePage extends UtilClass {
  WebDriver driver;
  
	@FindBy (xpath ="//span[text()='Funds']")
	private WebElement fundButton;
	
	
	@FindBy (xpath ="//button[@type='button']")
	private WebElement addFundButton;
	
	@FindBy (xpath ="//input[@id='addfunds_amount']")
	private WebElement enterAmount;
	
	@FindBy (xpath ="//button[@id='addfunds_submit']")
	private WebElement continueButton;
	
	@FindBy (xpath ="//strong[text()='₹ 10']")
	private WebElement verificationAmount;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver =driver;
		
		
	}
	public void clickOnFund() {
		fundButton.click();
		
	}
	public void clickOnAddFundButton() {
		addFundButton.click();
	}
	public void ShiftOnPopup() {
		Set<String> AllAdresses = driver.getWindowHandles();
		List<String> ALLAddres= new ArrayList<>(AllAdresses);
	     driver.switchTo().window(ALLAddres.get(1));
	     
	}
	public void enterAmounts() throws IOException, InterruptedException {
		Thread.sleep(3000);
		enterAmount.sendKeys(UtilClass.getConfigData("Amount"));
		continueButton.click();
		Thread.sleep(2000);
		
		
	}
	public String verfication () {
		return verificationAmount.getText();
	}
	
	
	
	
}
