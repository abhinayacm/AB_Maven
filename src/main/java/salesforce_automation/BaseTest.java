package salesforce_automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pages.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	WebDriver driver;
	String testResultsFolder;
	
	@BeforeClass
	public void setupClass()
	{
		createResultsSubFolder();
	}
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		login();
	}
	
	public void login()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	}
	
	public void takeScreenshot()
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormatScr = new SimpleDateFormat("yyyymmddHHmmss");
		Date dateScr = new Date();
		String datefmtScr= dateFormatScr.format(dateScr);
		String screenShotPath = testResultsFolder + "\\Screenshot_" + datefmtScr;
		File DestFile=new File(screenShotPath);
		//Copy file at destination
		try {
			FileUtils.copyFile(file, DestFile);
		}
		catch (IOException e) {
			
		}
		catch (Exception e) {
			
		}
	}
	
	public void createResultsSubFolder()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
		Date date = new Date();
		String date1= dateFormat.format(date);
		testResultsFolder = "Results\\result_" + date1;
		new File(testResultsFolder).mkdirs();
		
	}
	
	
	
	@AfterTest
	public void exit()
	{
		driver.close();
	}
	

}
