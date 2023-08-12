package AutomatePack;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BasePack.BaseClass;

public class Contacts extends BaseClass {
	
	static String fname;
	static String lname;
	public String ContactName()
	{
		return fname+" "+lname;
	}
	
	public void CreateContact() throws InterruptedException
	{
		try
		{
		System.out.println("\n---------- CONTACT CREATION ----------\n");
		Scanner s = new Scanner(System.in);
		js= (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		driver.findElement(By.name("newContact")).click();
		Thread.sleep(2000);
		reportPass("Creating new Contact");
		
		System.out.println("Enter Firstname to create Contact:");
		fname = s.nextLine();
		reportPass("Getting Firstname from User");
		driver.findElement(By.id("name_firstcon2")).sendKeys(fname);
		
		driver.findElement(By.name("save")).click();;
		Thread.sleep(2000);
		Screenshoot("Contact");
		WebElement error = driver.findElement(By.className("errorMsg"));
		String err = error.getText();
		reportPass("Error Message Obtained Successfully");
		
		System.out.println("Enter Lastname to create Contact:");
		lname = s.nextLine();
		reportPass("Getting Lastname from User");
		
		while(true)
		{
			if(lname.isBlank())
			{		
				System.out.println(err);
				lname=s.nextLine();
			}
			else
			{
				WebElement Accname = driver.findElement(By.id("name_lastcon2"));
				Accname.sendKeys(lname);
				WebElement save1 = driver.findElement(By.name("save"));
				save1.click();
				Thread.sleep(2000);
				break;
			}
			}
		
		System.out.println("Contact Created..!");
		reportPass("Contact created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
	}

}
