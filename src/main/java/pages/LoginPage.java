package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	
	By userName = By.xpath("//input[@id='username']"); 
	By pwdLogin = By.xpath("//input[@id='password']"); 
	By loginBtn = By.xpath("//input[@id='Login']");
	By salesApp = By.xpath("//span[@title='Sales']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login()
	{
		WebElement userNameTBox = driver.findElement(userName);
		userNameTBox.sendKeys("abinaya937-e1p2@force.com");
		WebElement pwdLoginTbox = driver.findElement(pwdLogin);
		pwdLoginTbox.sendKeys("");
		WebElement loginButton = driver.findElement(loginBtn);
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(salesApp));
	}

}
