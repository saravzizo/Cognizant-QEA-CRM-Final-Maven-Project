package AutomatePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;
import BasePack.BaseClass;

public class Accounts extends BaseClass{

	public void CreateAccount() throws InterruptedException
	{
		try
		{
		System.out.println("\n---------- ACCOUNT CREATION ----------\n");
		
		Scanner s = new Scanner(System.in);
		driver.findElement(By.id("Account_Tab")).click();
		Thread.sleep(2000);
		reportPass("Accounts tab opened");
		
		driver.findElement(By.id("tryLexDialogX")).click();
		Thread.sleep(2000);
		reportPass("Popup handled");
		Screenshoot("Account");
		driver.findElement(By.name("new")).click();
		Thread.sleep(2000);
		reportPass("Clicking new button");
		
		WebElement save = driver.findElement(By.name("save"));
		save.click();
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(By.className("errorMsg"));
		String err = error.getText();
		reportPass("Error Message Obtained Successfully");
		Thread.sleep(2000);
		
		System.out.println("Enter Account name:");
		String name = s.nextLine();
		reportPass("Getting Account name from User");
		Thread.sleep(2000);
		
		while(true)
		{
			if(name.isBlank())
			{		
				System.out.println(err);
				name=s.nextLine();
			}
			else
			{
				WebElement Accname = driver.findElement(By.id("acc2"));
				Accname.sendKeys(name);
				WebElement save1 = driver.findElement(By.name("save"));
				save1.click();
				Thread.sleep(2000);
				break;
			}
			}
		System.out.println("Account Created..!");
		reportPass("Account created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
	}
}
