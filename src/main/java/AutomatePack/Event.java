package AutomatePack;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BasePack.BaseClass;

public class Event extends BaseClass {
	public void CreateEvent() throws InterruptedException
	{
		try
		{
		System.out.println("\n----------- EVENT CREATION -----------\n");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		
		driver.findElement(By.name("event")).click();
		Thread.sleep(2000);
		reportPass("Clicking new event button");
		Screenshoot("Event");
		
		driver.findElement(By.name("save")).click();;
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(By.className("errorMsg"));
		String err = error.getText();
		reportPass("Error Message Obtained Successfully");
		Thread.sleep(2000);
		
		//lookup
		driver.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a")).click();
		Thread.sleep(2000);
		
		Set<String> s = driver.getWindowHandles();
		Iterator <String>i = s.iterator();
		String parent = i.next();
		String child = i.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[4]/a")).click();
		Thread.sleep(2000);
		reportPass("Lookup field automated Successfully");
		
		driver.switchTo().window(parent);
		
		//selecting start date
		driver.findElement(By.id("StartDateTime")).click();
		driver.findElement(By.xpath("//*[@id=\"calRow2\"]/td[7]")).click();
		Thread.sleep(2000);
		
		//selecting end date
		driver.findElement(By.id("EndDateTime")).click();
		driver.findElement(By.xpath("//*[@id=\"calRow2\"]/td[7]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("save")).click();;
		Thread.sleep(2000);
			
		System.out.println("Event Created..!");
		reportPass("Event created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	public void AttachFile() throws InterruptedException
	{
		try
		{
			System.out.println("\n----------- ATTACHING FILE -----------\n");
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(2000);
			
			driver.findElement(By.name("attachFile")).click();
			Thread.sleep(2000);
			reportPass("Clicking attach file button");
			Screenshoot("AttachFile");
			
			driver.findElement(By.id("file")).sendKeys("C:\\SFDC\\SFDC\\Report\\SFDC Case study.docx");
			Thread.sleep(2000);
			
			driver.findElement(By.id("Attach")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.name("cancel")).click();
			Thread.sleep(2000);
			
			reportPass("Event created Successfully");
			System.out.println("File Attached Successfully..!");
			Screenshoot("file");
			System.out.println("\n--------------------------------------\n");
			
			
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	
	
}
