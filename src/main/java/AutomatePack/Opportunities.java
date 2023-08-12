package AutomatePack;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BasePack.BaseClass;

public class Opportunities extends BaseClass {

	public void CreateOpportunities() throws InterruptedException 
	{
		try
		{
		System.out.println("\n-------- OPPORTUNITY CREATION --------\n");
		Scanner s = new Scanner(System.in);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		driver.findElement(By.name("newOpp")).click();
		Thread.sleep(2000);
		reportPass("Creating new Opportunities");

		driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
		

		WebElement error = driver.findElement(By.className("errorMsg"));
		String err = error.getText();
		Thread.sleep(2000);
		
		System.out.println("Enter the Opportunity Name:");
		String OppName = s.nextLine();
		while (true) {
			if (OppName.isBlank()) {
				System.out.println(err);
				OppName = s.nextLine();
			} else {
				WebElement Opp = driver.findElement(By.id("opp3"));
				Opp.sendKeys(OppName);
				Thread.sleep(2000);

				break;
			}
		}
		reportPass("Getting Opportunity Name");
		Screenshoot("Opportunity");
		//Selecting date
		driver.findElement(By.id("opp9")).click();
		Thread.sleep(2000);

		Select month = new Select(driver.findElement(By.id("calMonthPicker")));
		month.selectByVisibleText("July");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"calRow2\"]/td[3]")).click();
		Thread.sleep(2000);
		reportPass("Getting Date from List");

		//Selecting Stage
		Select stg = new Select(driver.findElement(By.id("opp11")));
		stg.selectByVisibleText("Closed Won");
		Thread.sleep(2000);
		reportPass("Selecting Stage from List");
		
		driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
		reportPass("Save button clicked");
		
		System.out.println("opportunity Created..!");
		reportPass("Opportunity created Successfully");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
}
