package TestCases;


import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;

import BasePack.BaseClass;
import AutomatePack.Login;
import AutomatePack.Accounts;
import AutomatePack.Contacts;
import AutomatePack.Opportunities;
import AutomatePack.Task;
import AutomatePack.Event;
import AutomatePack.Opp_Products;
import AutomatePack.Opp_ContactRoles;
import Utilities.ExtentReportManager;

public class TestClass extends BaseClass {


	public ExtentReports report = ExtentReportManager.getReportInstance();
	Login l=new Login();
	Accounts a = new Accounts();
	Contacts c = new Contacts();
	Opportunities O=new Opportunities();
	Task T = new Task();
	Event e = new Event();
	Opp_Products op = new Opp_Products();
	Opp_ContactRoles oc = new Opp_ContactRoles();
	Scanner sc = new Scanner(System.in);
	

	@BeforeTest
	public void invoke() throws InterruptedException {
		logger = report.createTest("Invoking Browser to launch the website");
		String websiteURLKey="https://ctscom-47f-dev-ed.develop.my.salesforce.com/";
		invokeBrowser();
		openURL(websiteURLKey);
		reportPass("Browser is Invoked");
		System.out.println("Browser Launched Successfully.!");
	}

	@Test(priority = 1)
	public void Retrieve() throws InterruptedException, IOException  {
		logger = report.createTest("Log In Page");
		l.login();
	}

	@Test(priority = 2)
	public void Accountinput() throws InterruptedException  , IOException{
		logger = report.createTest("Account Creation");
		a.CreateAccount();
		
	}
	
	@Test(priority = 3)
	public void ContactInput() throws InterruptedException, IOException  {
		logger = report.createTest("Contact Creation");
		c.CreateContact();
		
	}
	
	@Test(priority = 4)
	public void OppInput() throws InterruptedException, IOException  {
		logger = report.createTest("Opportunity Creation");
		O.CreateOpportunities();
		
	}
	
	@Test(priority = 5)
	public void ProductsInput() throws InterruptedException, IOException  {
		logger = report.createTest("Products Creation");
		op.CreateProducts();
		
	}
	
	@Test(priority = 6)
	public void ContactRoleInput() throws InterruptedException, IOException  {
		logger = report.createTest("Contact Roles Creation");
		oc.CreateContactRoles();
		
	}

	@Test(priority = 7)
	public void TaskInput() throws InterruptedException, IOException  {
		logger = report.createTest("Task Creation");
		T.CreateTask();
		
	}
	
	@Test(priority = 8)
	public void EventInput() throws InterruptedException, IOException  {
		logger = report.createTest("Event Creation");
		e.CreateEvent();
		
	}
	
	@Test(priority = 9)
	public void Attach() throws InterruptedException, IOException  {
		logger = report.createTest("Attaching File");
		e.AttachFile();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		logger = report.createTest("Saving Report & Closing Browser");
		reportPass("Report saved and browser was closed successfully");
		l.endReport();
		l.endBrowser();
		
	}

}
