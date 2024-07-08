package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import salesforce_automation.BaseTest;
import utils.Utils;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	By accountSelection = By.xpath("//a[@title='Accounts']/span");
	By newBtn = By.xpath("//div[@title='New']");
	By accountName = By.xpath("//input[@name='Name']");
	By saveBtn = By.xpath("//button[@name='SaveEdit']");
	By detailsView = By.xpath("//a[@data-label='Details']");
	
	public void createAccount()
	{
		WebElement accountSelectionLink = driver.findElement(accountSelection);
		Utils.waitTill(60);
		wait.until(ExpectedConditions.elementToBeClickable(accountSelectionLink));
		accountSelectionLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(newBtn));
		WebElement newBtnClick = driver.findElement(newBtn);
		newBtnClick.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountName));
		WebElement accountNme = driver.findElement(accountName);
		String accName = "Account" + randomInt();
		accountNme.sendKeys(accName);
		WebElement saveBtnClick = driver.findElement(saveBtn);
		saveBtnClick.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(detailsView));
		
	}
	
}
