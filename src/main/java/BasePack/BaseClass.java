package BasePack;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Utilities.ExtentReportManager;

public class BaseClass {

	public static WebDriver driver;
	public JavascriptExecutor js;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;

	public void invokeBrowser() throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver-111.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			
	}

	public void openURL(String websiteURLKey) {
		driver.get(websiteURLKey);
	}

	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
	}

	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	public void Screenshoot(String fileName) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String location = ".\\Screenshot\\";
		File dest = new File(location + fileName + ".png");
		FileUtils.copyFile(src, dest);
	}

	public void endReport() {
		report.flush();
	}

	public void endBrowser() {
		driver.close();
	}
}
