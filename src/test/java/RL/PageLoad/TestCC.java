package RL.PageLoad;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class TestCC  {
	
	WebDriver driver;
  
	@AfterMethod
      public void afterClass() throws InterruptedException {
	  
	  driver.findElement(By.xpath("(//button[@class='nav_link mdl-button mdl-button--icon'])[1]")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("(//button[@class='mdl-button'])[2]")).click();
	  Thread.sleep(3000);
	  driver.quit();
		
  }
 

  @BeforeMethod
  public void beforeClass() throws InterruptedException {
	  
	 // File pathToBinary = new File("C:\\Users\\rle0210\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		//FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		//FirefoxProfile firefoxProfile = new FirefoxProfile();
		//FirefoxDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
		//FirefoxBinary driver;
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("https://cc.rlcatalyst.com");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@id='mdl-textfield-0']")).sendKeys("relevance/relevance");
	  driver.findElement(By.xpath("//input[@id='mdl-textfield-1']")).sendKeys("Relevance@123");
	  driver.findElement(By.xpath("//button[@class='signUpButton marginTop10 mdl-button mdl-button--raised mdl-button--primary']")).click();
	  Thread.sleep(3000);

  }
  
  @Test
  public void TestCommandCenter() throws InterruptedException{
	 

		Fillo fillo = new Fillo();
		try {
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\TestData.xls");
		String strQuery = "Select * from CC_URLs";
		Recordset recordset = connection.executeQuery(strQuery);
	
		Recordset recordset1 = connection.executeQuery(strQuery);
		
		while (recordset.next()) {
			recordset1.next();
		//System.out.println(recordset1.getField("ExpectedPage"));
		//System.out.println(recordset.getField("URL"));
		String url=recordset.getField("URL");
		driver.get(url);
		Thread.sleep(4000);
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		assertTrue(pageTitle.contains(recordset1.getField("ExpectedPage")), "Title mismatch");
		}

		recordset.close();
		connection.close();
		
		
		} catch (FilloException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
  }
  
  }
 

