package office;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CraftsVilla {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.craftsvilla.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions ac=new Actions(driver);			
		String mainMenuXp="//nav[@id='mega-menu']/descendant::ul/li/a/span[@class='first_arrow icon']/parent::a";
		List<WebElement> mainMenu = driver.findElements(By.xpath(mainMenuXp));
		for(int i=0; i<mainMenu.size(); i++)
		{
			Thread.sleep(2000);
			ac.moveToElement(mainMenu.get(i)).perform();
			Thread.sleep(2000);
			String menuText = mainMenu.get(i).getText();
			System.out.println(menuText);
			//String raplace="\"+ menuText +\"\";
			
			String headMenuXp="//nav[@id='mega-menu']/descendant::li/following-sibling::li/a[text()='SAREES']/following-sibling::div/div/following-sibling::div/ul/li[not(div[@class='image_box'])]";
			List<WebElement> headMenu = driver.findElements(By.xpath(headMenuXp));
			
			for(int j=0; j<headMenu.size() ;j++)
			{
				Thread.sleep(1000);
				String headText = headMenu.get(j).getText();
				System.out.println(headText);
			}
		}
	}

}
