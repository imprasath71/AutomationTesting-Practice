package testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
 
  @BeforeMethod
  public void login() {
    System.out.println("Login....");
	  
  }
  @Test(priority = 1)
  public void search() {

    System.out.println("Search....");
  }

  @Test(priority = 2)
  public void advancedsearch() {
    System.out.println("Advanced search....");
  }

  @AfterMethod
  public void logout() {
    System.out.println("Logout.....");
  }

  @BeforeClass
  
  public void beforeclass() {
  }

  @AfterClass
  public void afterclass() {
  }

  

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
