package LoginTest;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTestbyAutomation {

	public static void main(String[] args) throws InterruptedException {
		//Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		//Open URL 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize(); // used to view browser in full screen. 
		//This thread is used to ignore Synchronization issue
		Thread.sleep(5000);
		//Provide username 
	//	WebElement txtusername =  driver.findElement(By.name("username"));
		//passing value into the username field.
	//	txtusername.sendKeys("Admin");
		
		//alias way 
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		//login button locating using XPath 
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		/*
		 Validation One mathod
		//verify validation of title. 
		String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		if (act_title.equals(exp_title)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		} */ 
		//Another method for validation of title after successful login
		Thread.sleep(5000);
		String act_title= null;
		try {
			act_title = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
			
		}
		catch (NoSuchElementException e ) {} 
		String exp_title = "Dashboard";
		
		if (act_title.equalsIgnoreCase(exp_title)) {
			System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase failed");
			
		}
		
		//if you use driver close socket exception will occur. 
		driver.quit();
		

	}

}
