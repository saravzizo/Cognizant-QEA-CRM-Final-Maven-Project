package AutomatePack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import BasePack.BaseClass;

public class Task extends BaseClass {
	public void CreateTask() throws InterruptedException
	{
		try
		{
		System.out.println("\n----------- TASK CREATION ------------\n");
		js= (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		
		driver.findElement(By.name("task")).click();
		Thread.sleep(2000);
		reportPass("Clicking new task button");
		Screenshoot("Task");
		
		driver.findElement(By.name("save")).click();;
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(By.className("errorMsg"));
		String err = error.getText();
		reportPass("Error Message Obtained Successfully");
		Thread.sleep(2000);
		
		//pick list
		Select status = new Select(driver.findElement(By.id("tsk12")));
		status.selectByIndex(1);
		Thread.sleep(2000);
		Select prior = new Select(driver.findElement(By.id("tsk13")));
		prior.selectByIndex(1);
		reportPass("Picklist are automated Successfully");
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
		
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		reportPass("Lookup field automated Successfully");
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.name("save")).click();;
		Thread.sleep(2000);
		
		System.out.println("Task Created..!");
		reportPass("Task created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
	}
	
}
