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

public class TestCatalyst  {
	
	WebDriver driver;
	
	
  @AfterMethod
  public void afterClass() throws InterruptedException {
	  
	  driver.findElement(By.id("liuserinfo")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("signOut")).click();
	  Thread.sleep(3000);
	  driver.quit();
		
  }
 

  @BeforeMethod
  public void beforeClass() throws InterruptedException {
	  
	 
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("http://neo.rlcatalyst.com");
	  Thread.sleep(5000);
	  System.out.println(driver.getCurrentUrl());
	  
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("superadmin");
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("superadmin@123");
	  driver.findElement(By.id("loginBtn")).click();
	  
	  Thread.sleep(8000);
	  System.out.println(driver.getCurrentUrl());

  }
  
  @Test(priority =1)
  public void TestCatalystPageLoad() throws InterruptedException{
	  
	    
	  Fillo fillo = new Fillo();

	  try {
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\TestData.xls");
		String strQuery = "Select * from Catalyst";
		Recordset recordset = connection.executeQuery(strQuery);
	    Recordset recordset1 = connection.executeQuery(strQuery);
		
		while (recordset.next()) {
		recordset1.next();
		//System.out.println(recordset1.getField("ExpectedPage"));
		//System.out.println(recordset.getField("URL"));
		String url=recordset.getField("URL");
		driver.get(url);
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
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
 

