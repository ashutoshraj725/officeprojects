package assignment;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario10 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		driver.get("https://www.bluestone.com");
		Thread.sleep(7000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		/*WebElement close = driver.findElement(By.xpath("//a[@class='wzrkClose']"));
		js.executeScript("arguments[0].click()", close);*/
		js.executeScript("document.getElementsByClassName('wzrkClose')[0].click()");
		
	}

}
