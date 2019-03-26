package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class Scenario3 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		Actions action = new Actions(driver);
		WebElement srcBlock1 = driver.findElement(By.id("draggable"));
		WebElement destBlock3 = driver.findElement(By.cssSelector("div[id='droppable']"));
		action.dragAndDrop(srcBlock1, destBlock3).perform();
		String actualText = destBlock3.getText();
		String expectedText="Dropped!";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Text assertion is passed");
		String cssValue = destBlock3.getCssValue("color");
		String actualClr = Color.fromString(cssValue).asHex();
		String expectedClr="#777620";		
		Assert.assertEquals(actualClr, expectedClr);		
		System.out.println("Color assertion is passed");
		driver.close();
		
	}

}
