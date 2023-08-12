package AutomatePack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.*;
import BasePack.BaseClass;

public class Opp_Products extends BaseClass{

	public void CreateProducts() throws InterruptedException
	{
		try
		{
		System.out.println("\n---------- PRODUCT CREATION ----------\n");
		System.out.println("!!Creating Products!!");
		Scanner s = new Scanner(System.in);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		
		driver.findElement(By.name("addProd")).click();
		Thread.sleep(2000);
		reportPass("Clicking new product button");
		
		driver.findElement(By.id("search")).sendKeys("GenWatt");
		Thread.sleep(2000);
		
		driver.findElement(By.id("save_filter_PricebookEntry")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("01u2w000007AZOk")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("01u2w000007AZOd")).click();
		Thread.sleep(2000);
		reportPass("Selecting products");
		
		driver.findElement(By.name("edit")).click();
		Thread.sleep(2000);
		
		String quantity1 = null,quantity2 = null;
		
		WebElement q1 = driver.findElement(By.id("Quantity01u2w000007AZOk"));
		System.out.println("Enter Quantity of Product - 1:");
		quantity1=s.nextLine();
		q1.sendKeys(quantity1);
		Thread.sleep(2000);
		
		WebElement q2 = driver.findElement(By.id("Quantity01u2w000007AZOd"));
		System.out.println("Enter Quantity of Product - 2:");
		quantity2=s.nextLine();
		q2.sendKeys(quantity2);
		Thread.sleep(2000);
		reportPass("Getting quantity from User");
		Screenshoot("Products");
		
		driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
		
		
		System.out.println("Products Created..!");
		reportPass("Products created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
			
	}
}
