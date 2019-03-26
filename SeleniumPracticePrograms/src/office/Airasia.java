package office;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Airasia {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.airasia.com");
		//Robot r=new Robot();
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("home-origin-autocomplete-heatmap")).sendKeys("Bengaluru");
		Thread.sleep(3000);
		driver.findElement(By.id("home-origin-autocomplete-heatmap")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("home-destination-autocomplete-heatmap")).sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElement(By.id("home-destination-autocomplete-heatmap")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='trip-oneway']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("home-depart-date-heatmap")).clear();
		driver.findElement(By.id("home-depart-date-heatmap")).sendKeys("25/05/2019");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),' Confirm ')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),' Search ')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),' Continue ')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='airasia-premium-flex-bundle-div-show-bundle-details-heatmap']/descendant::div[text()='Select']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@id,'button-inner-button-booking') and contains(text(),'Continue')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-row='10']/descendant::span[text()='F']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),' Done ')]")).click();
		
	}

}
