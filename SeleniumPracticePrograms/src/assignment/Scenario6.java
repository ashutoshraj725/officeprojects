package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class Scenario6 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com");
		WebElement rings = driver.findElement(By.xpath("//a[text()='Rings ']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(rings).perform();
		driver.findElement(By.xpath("//a[text()='Rings ']/parent::li/descendant::a[text()='Diamond']")).click();
		List<WebElement> defaultPriceList = driver.findElements(By.xpath("//span[@class='b-price-left']"));
		List<String> defPrice=new ArrayList<>();
		/*JavascriptExecutor js=(JavascriptExecutor) driver;
		for(int i=1; i<=6239; i++)
		{
		js.executeScript("window.scrollBy(0, "+i+")");
		Thread.sleep(200);
		}*/
		Iterator<WebElement> itr1=defaultPriceList.iterator();
		while(itr1.hasNext())
		{
			Thread.sleep(200);
			String defaultPrice = itr1.next().getText();
			defPrice.add(defaultPrice);			
		}
		System.out.println("Default price lsit : "+defPrice);
		WebElement select = driver.findElement(By.xpath("//span[text()=' Popular ']"));
		ac.moveToElement(select).perform();
		driver.findElement(By.xpath("//a[text()='Price Low to High ']")).click();
		List<WebElement> sortedPrice = driver.findElements(By.xpath("//span[@class='b-price-left']"));
		List<String> sortPrice=new ArrayList<>();
		//JavascriptExecutor js1=(JavascriptExecutor) driver;
		/*for(int i=1; i<=6239; i++)
		{
		js1.executeScript("window.scrollBy(0, "+i+")");
		Thread.sleep(200);
		}*/
		Iterator<WebElement> itr2=sortedPrice.iterator();
		while(itr2.hasNext())
		{
			Thread.sleep(200);
			String price = itr2.next().getText();
			sortPrice.add(price);
		}
		System.out.println("Sorted Price List : "+sortPrice);
		
		Set<String> str=new TreeSet<>(sortPrice);		
		System.out.println("Forceful sorted Price : "+str);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(sortPrice,str );
		sa.assertAll();
		driver.close();		
	}
}
