package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	
	public static WebDriver driver=null;
	
	@BeforeMethod
	public void openApplication() {
		// Set the path
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
		
		// Launch the browser
		
		driver=new ChromeDriver();
		
		// Get the URL
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
	}
	

}
