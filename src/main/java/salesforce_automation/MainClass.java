package salesforce_automation;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//implementation of all 5 methods
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String parent=driver.getWindowHandle();
		Thread.sleep(2000);
		System.out.println(driver.getTitle() + parent);
		
		driver.findElement(By.xpath("//a[text()='LinkedIn']")).click();
		Thread.sleep(10000);
		Set <String> parent1=driver.getWindowHandles();
		Iterator<String> it = parent1.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		String webPageTitle = driver.getTitle();
		System.out.println("child window handle title ** " + webPageTitle);
	}
}
 /* while (it.hasNext()){
			String childWindow = it.next();
		//	if (!parent.equalsIgnoreCase(childWindow)){
				driver.switchTo().window(childWindow);
				String webPageTitle = driver.getTitle();
				System.out.println("child window handle title ** " + webPageTitle);
			}

		System.out.println(driver.getTitle() + parent1);
	}
}
// public class MainClass {

//	public static void main(String[] args) {
	//	TestAccount firstAcc = new TestAccount();
	//	TestAccount secondAcc = new TestAccount();
	//	TestAccount thirdAcc = new TestAccount();

//	}
/*	public class MainClass {    
		  public static void main(String[] args) {    
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   LocalDateTime dateUpdate = now.minusDays(30); 
		   System.out.println(dtf.format(dateUpdate));  
		  }    
	*/
		