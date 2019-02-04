package WebAutomotion;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultiBrowser {

	public static WebDriver driver;

  @Parameters(name = "browser")
  @BeforeClass
  // Passing Browser parameter from TestNG xml
  public static void beforeTest(String browser) {

  // If the browser is Firefox, then do this
  if(browser.equalsIgnoreCase("firefox")) {

	  driver = new FirefoxDriver();

  // If browser is IE, then do this	  

  }else if (browser.equalsIgnoreCase("ie")) { 

	  // Here I am setting up the path for my IEDriver
	  System.setProperty("webdriver.ie.driver", "C:/IEDriverServer.exe");

	  driver = new InternetExplorerDriver();

  } 

  // Doesn't the browser type, lauch the Website

  driver.get("http://www.store.demoqa.com"); 

  }

	// Once Before method is completed, Test method will start

	@Test
	public void login() throws InterruptedException {

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		driver.findElement(By.id("log")).sendKeys("testuser_1");

		driver.findElement(By.id("pwd")).sendKeys("Test@123");

		driver.findElement(By.id("login")).click();

	}

	@AfterClass
	public void afterTest() {

		driver.quit();

	}

}