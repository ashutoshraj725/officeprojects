package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Scenario8 {

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
		WebElement kazaSize = driver.findElement(By.xpath("//select[@id='ringselect']"));
		Select s=new Select(kazaSize);
		s.selectByIndex(5);
		WebElement expected = s.getFirstSelectedOption();
		String expectedSize = expected.getText();
		System.out.println(expectedSize);
		System.out.println("The assertion should fail because of the difference in one SPACE in select box and in actual value");
		driver.findElement(By.id("buy-now")).click();
		String actualSize = driver.findElement(By.xpath("//div[text()='2-10(2 10/16\")']")).getText();
		System.out.println(actualSize);
		Assert.assertEquals(actualSize, expectedSize);
		System.out.println("Assertion Passed");
		driver.close();
	}

}
