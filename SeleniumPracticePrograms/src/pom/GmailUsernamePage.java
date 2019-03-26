package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailUsernamePage {
@FindBy(xpath="//input[@type='email']")
WebElement emailTB;
@FindBy(xpath="//span[text()='Next']")
WebElement nextButton;

public GmailUsernamePage(WebDriver driver) 
{	
	PageFactory.initElements(driver, this);
}

public void setUsername(String un)
{
	emailTB.sendKeys(un);
}

public void clickNextButton()
{
	nextButton.click();
}
}
