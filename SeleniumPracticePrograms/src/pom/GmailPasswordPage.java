package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailPasswordPage {
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pwdTB;
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;
	
	public GmailPasswordPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);		
	}
	
	public void setPassword(String pwd) 
	{
	pwdTB.sendKeys(pwd);
	}
	
	public void clickNextButton()
	{
		nextButton.click();
	}

}
