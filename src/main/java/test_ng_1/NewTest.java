package test_ng_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	WebDriver driver;
  @Test(priority=1)
  public void openApp() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver(); 
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10 ));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  
  }
  @Test(priority=2)
  public void loginApp() {
	  driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	  
  }
  @Test(priority=3)
  public void closeApp() {
	  driver.quit();
  }
  
}