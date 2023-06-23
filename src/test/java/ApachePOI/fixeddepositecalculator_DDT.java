package ApachePOI;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.ss.formula.functions.Rate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fixeddepositecalculator_DDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		String file = System.getProperty("user.dir")+"\\testdata\\Automated_TC.xlsx";
		int rows = ExcelUtilclass.getRowCount(file, "sheet1");
		for(int i = 1;i<=rows;i++){
			String Principle = ExcelUtilclass.getCellData(file, "Sheet1", i, 0);
			String Rate_Of_Interest = ExcelUtilclass.getCellData(file, "Sheet1", i, 1);
			String Period_1 = ExcelUtilclass.getCellData(file, "Sheet1", i, 2);
			String Period_2 = ExcelUtilclass.getCellData(file,"Sheet1" , i, 3);
			String Frequency = ExcelUtilclass.getCellData(file,"Sheet1" , i, 4);
			String Exp_Maturity_value = ExcelUtilclass.getCellData(file,"Sheet1" , i, 5);

			driver.findElement(By.id("principal")).sendKeys(Principle);
			driver.findElement(By.id("interest")).sendKeys(Rate_Of_Interest);
			driver.findElement(By.id("tenure")).sendKeys(Period_1);
			Select period_dropdown = new Select(driver.findElement(By.id("tenurePeriod")));
			period_dropdown.selectByVisibleText(Period_2);

			Select freq_dropdown = new Select(driver.findElement(By.id("frequency")));
			freq_dropdown.selectByVisibleText(Frequency);

			JavascriptExecutor js = (JavascriptExecutor)driver;
			//WebElement calculate = driver.By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']").click();
			WebElement calculate = driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
			js.executeScript("arguments[0].click();", calculate);

			//Getting Maturity value by writing Own XPath.
			String Actual_Maturity_Value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(Actual_Maturity_Value)==Double.parseDouble(Exp_Maturity_value)){
				System.out.println("Testcase passed");
				ExcelUtilclass.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtilclass.fillGreenColor(file, "Sheet1", i, 7 );

			}
			else{
				System.out.println("Testcase failed");
				ExcelUtilclass.setCellData(file, "Sheet1", i, 7, "Failed");
				ExcelUtilclass.fillRedColor(file, "Sheet1", i, 7);
			}
			Thread.sleep(5000);


			WebElement clear_button = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clear_button);



		}

	
	
	
	
	}

}
