package utilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {
WebDriver driver;
	public static String getConfigData(String key) throws IOException {
		FileInputStream file = new FileInputStream("properties\\configuration.properties");
				
		Properties p = new Properties ();
		p.load(file);
		return p.getProperty(key);
		
	}

	public static String GetDataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("src/test/resources\\dataFetch\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh =wb.getSheet("Sheet1");
		String value = sh.getRow(0).getCell(0).getStringCellValue();
		return value;
		
	}
	public static void MouseHoverAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public static void waitForElement(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String getScreenshot (WebDriver driver, String methodName) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String path = "screenShot\\" + methodName + ".png";
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
		}
	
	
	
}
