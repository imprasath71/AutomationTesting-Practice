package Locator_Types;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		//searchbox
	
		driver.findElement(By.id("small-searchterms")).sendKeys("Desktop");

	
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();

		//linktext locator
		driver.findElement(By.linkText("Computers")).click();


		//findelements tag 
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total images "+images.size() );

		//find elements tag finding total number of links present in webpage 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links "+links.size() );
		System.out.println("Testcase verified");



		

	}

}
