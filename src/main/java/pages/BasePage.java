package pages;

import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	String testResultsFolder;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public int randomInt()
	{
		int rand = (int)Math.random();
		return rand;
		
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

}
