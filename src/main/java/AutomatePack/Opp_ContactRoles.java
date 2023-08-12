package AutomatePack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import BasePack.BaseClass;

public class Opp_ContactRoles extends BaseClass{

	Contacts CC = new Contacts();
	
	public void CreateContactRoles() throws InterruptedException
	{
		try
		{
		System.out.println("\n------- CONTACT ROLE CREATION -------\n");
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		
		driver.findElement(By.name("newRole")).click();
		Thread.sleep(2000);
		reportPass("Clicking new Contact Role button");
		
		driver.findElement(By.id("primary0")).click();
		Thread.sleep(2000);
		
//		driver.findElement(By.id("contact0")).sendKeys(CC.ContactName());
//		Thread.sleep(2000);
		
		Select role = new Select(driver.findElement(By.id("role0")));
		role.selectByVisibleText("Decision Maker");
		reportPass("Picklist are automated Successfully");
		Screenshoot("Contact Role");
		driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
		
		
		System.out.println("Contact Roles Created..!");
		reportPass("Contact Role created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
}
