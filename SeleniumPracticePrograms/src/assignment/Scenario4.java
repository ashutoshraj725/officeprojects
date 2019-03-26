package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class Scenario4 extends BaseClassChrome {
	
	public static void searchProduct(String product, String catagory)
	{		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://www.ebay.in");		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(product);
		WebElement cat = driver.findElement(By.xpath("//select[@name='_sacat']"));
		Select st=new Select(cat);
		st.selectByVisibleText(catagory);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public static String getResults()
	{
		String results = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Total number of results : "+results);
		return results;
	}
	
	public static String getBookName(int productIndex) {
		List<WebElement> bookList = driver.findElements(By.xpath("//div[@class='s-item__wrapper clearfix']"));
		List<String> books=new ArrayList<>();
		Iterator<WebElement> itr=bookList.iterator();
		while(itr.hasNext())
		{
			String bookItem = itr.next().getText();
			books.add(bookItem);
		}
		String yourBookName = books.get(productIndex);
		System.out.println("Book you are looking for : "+yourBookName);
		return yourBookName;
	}
	
	public static void main(String[] args) {
		searchProduct("Wings of Fire", "Books");
		getResults();
		getBookName(1);
	}
}
