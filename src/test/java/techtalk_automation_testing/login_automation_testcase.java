package techtalk_automation_testing;

import java.util.NoSuchElementException;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_automation_testcase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		//Open URL for the project
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//maximise the window
		driver.manage().window().maximize();
		//To avoid Synchronization problem, we will make the webpage execution to wait for 5 seconds. 
		Thread.sleep(5000);
		//Sending parameters to the website's username and password field.
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		//Clicking Login Button by finding the XPath of the Login Button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		//Navigated to Dashboard
		//verify whether title of the webpage is matching or not. 

		Thread.sleep(5000);

		//Compare whether Title is correct or not
		String actual_title= null;
		try {
			actual_title = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
			
		}
		catch (NoSuchElementException e ) {} 
		String expected_title = "Dashboard";
		if (expected_title.equals(actual_title)){
			System.out.println("Testcase verified and title is same");
		}
		else{
			System.out.println("Testcase failed and Not equal");
		}		
		

		//Verify Navigation of logging out. 

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();

		//Verify whether it is correctly navigated to login page.
		//Thread.sleep(2000);

		String login_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String actual_url = driver.getCurrentUrl();

		if (login_url.equals(actual_url)){
			System.out.println("URL Matched and Correctly Navigated");
		}
		else{
			System.out.println("URL Mismatch and Incorrect Navigation");
		
		}

		Thread.sleep(5000);

		
		// driver.close();

	}

}		



