package webdrivermethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webdrivermethodsexample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// get title of webpage
		System.out.println("Title of webpage is " + driver.getTitle());
		//get current URL of the browser instance 
		System.out.println("URL of the webpage is "+ driver.getCurrentUrl());
		//get window handle 
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //to open another browser tab

		Set<String>  handles = driver.getWindowHandles();
		//only through looping we can capture ids

		for (String i:handles){
			System.out.println(i);
		}


	}

}
