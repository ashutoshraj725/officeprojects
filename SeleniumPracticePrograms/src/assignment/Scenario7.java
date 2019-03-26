package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Scenario7 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com");
		WebElement jewl = driver.findElement(By.xpath("//a[text()='All Jewellery ']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(jewl).perform();
		driver.findElement(By.xpath("//a[text()='All Jewellery ']/ancestor::ul/descendant::span[@class='prcs-d'][contains(text(),'Kadas')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='The Ranveer Kada for Him']")).click();
		driver.findElement(By.xpath("//input[@id='buy-now']")).click();
		WebElement actualErrMsg = driver.findElement(By.xpath("//div[text()='* This field is required']"));
		if(actualErrMsg.isDisplayed()) {
			System.out.println("Errer message displayed !");
		}
		String actualErrMsgText = actualErrMsg.getText();
		System.out.println("Errer message: "+actualErrMsgText);
		String expectedErrMsgText="* This field is required";
		Assert.assertEquals(actualErrMsgText, expectedErrMsgText);
		System.out.println("Assertion Passed");
		driver.close();		
	}
}
