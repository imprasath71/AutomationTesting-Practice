package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class conditionalmethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();

		//verify logo 
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Status of logo displaying is "+logo.isDisplayed());

		//verify searchbox 
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Status of search box is "+searchbox.isDisplayed());
		System.out.println("Status of search box is "+searchbox.isEnabled());

		//verify selection 

		WebElement radio_male = driver.findElement(By.xpath("//input[@id='gender-male']"));

		WebElement radio_female= driver.findElement(By.xpath("//input[@id='gender-female']"));


		//before selection 
		System.out.println("Status of button selected "+radio_female.isSelected());
		System.out.println("Status of button selected "+radio_male.isSelected());

		//after selection 
		radio_male.click();
		radio_female.click();
		System.out.println("Status of button selected "+radio_female.isSelected());
		System.out.println("Status of button selected "+radio_male.isSelected());

		
















	}

}
