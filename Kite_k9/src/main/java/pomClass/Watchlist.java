package pomClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClass.UtilClass;

public class Watchlist extends UtilClass {
 WebDriver driver;
 
	@FindBy (xpath = "//input[@icon='search']")
	private WebElement searchBar;
	
	@FindBy (xpath = "//button[@class='button-green']")
	private WebElement AddStockButton;
	
	@FindBy (xpath = "//li[@class='search-result-item selected']")
	private WebElement StockHover;
	
	
	
	public Watchlist(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
		
		
	}
	public void EnterStockNameInSearchBar() throws EncryptedDocumentException, IOException {
		searchBar.sendKeys(UtilClass.GetDataFromExcel());
		
	}
	
	public void AddStockToWatchlist() {
		UtilClass.MouseHoverAction(driver, StockHover);
	}
	
	public void ClickOnAddStockButton() {
		AddStockButton.click();
	}
	
}

