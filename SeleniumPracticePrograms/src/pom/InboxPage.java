package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InboxPage {

	WebDriver driver=null;

@FindBy(xpath="//div[@id=':2k']")
WebElement primary;
@FindBy(xpath="//div[@role='checkbox']")
WebElement mails;

public InboxPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void primaryDefault()
{
	if(primary.isDisplayed())
	{
		System.out.println("Primary tab is being displayed");
	
	}	
}


	
}
