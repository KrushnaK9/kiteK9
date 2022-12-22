package pomClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.PathConfig;

public class PomD {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  PathConfig.chromePath);
		 
		 
		 WebDriver driver = new ChromeDriver();
		 driver.get(PathConfig.appUrl);
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='text']"));
		 
		 System.out.println(checkbox.size());
		 for(int i=0;i<=checkbox.size()-1;i++) {
				System.out.println(checkbox.get(i).getText());

		 }
}
