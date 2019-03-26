package assignment;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.GmailPasswordPage;
import pom.GmailUsernamePage;
import pom.InboxPage;

public class Scenario1UsingPOM extends BaseTest {

	@Test
	public static void gmailLogin() throws Exception {
		
		GmailUsernamePage gun=new GmailUsernamePage(driver);
		gun.setUsername("qateam.abhishek@gmail.com");
		gun.clickNextButton();
		Thread.sleep(3000);
		GmailPasswordPage gpwd=new GmailPasswordPage(driver);
		gpwd.setPassword("#s@kuma$415");
		gpwd.clickNextButton();
		Thread.sleep(5000);
		InboxPage ip=new InboxPage(driver);
		ip.primaryDefault();
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement element = driver.findElement(By.xpath("//div[@id=':2k']"));
		wait.until(ExpectedConditions.attributeContains(element, "aria-selected", "true"));
		List<WebElement> totalEmailsInPrimary = driver.findElements(By.xpath("//div[@role='checkbox']"));
		int email = totalEmailsInPrimary.size();
		System.out.println("Total number of emails in primary tab : "+email);
		driver.close();
		
	}
}
