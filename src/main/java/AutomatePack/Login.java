package AutomatePack;

import java.io.IOException;
import java.util.Scanner;
import org.openqa.selenium.By;

import BasePack.BaseClass;

public class Login extends BaseClass {

	public void login() throws InterruptedException, IOException
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		String User = "saravanan@cts.com";
		String Pass = "Stacy@472002";
		driver.findElement(By.id("username")).sendKeys(User);
		driver.findElement(By.id("password")).sendKeys(Pass);
		Screenshoot("Login");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		System.out.println("\nLogin Successfull");
		reportPass("Logged In Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Login Failed!\nError:" + e);
		
		}
	}
}
