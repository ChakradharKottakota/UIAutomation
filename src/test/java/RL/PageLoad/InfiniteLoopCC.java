package RL.PageLoad;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class InfiniteLoopCC {
	
	WebDriver driver;
  
	/*@AfterMethod
      public void afterClass() throws InterruptedException {
	  
	  driver.findElement(By.xpath("(//button[@class='nav_link mdl-button mdl-button--icon'])[1]")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("(//button[@class='mdl-button'])[2]")).click();
	  Thread.sleep(3000);
	  driver.quit();
		
  }
*/ 

  @BeforeMethod
  public void beforeClass() throws InterruptedException {
	  
	 
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("https://cc.rlcatalyst.com");
	  Thread.sleep(10000);
	  System.out.println(driver.getCurrentUrl());
	  driver.findElement(By.xpath("//input[@id='mdl-textfield-0']")).sendKeys("relevance/relevance");
	  driver.findElement(By.xpath("//input[@id='mdl-textfield-1']")).sendKeys("Relevance@123");
	  driver.findElement(By.xpath("//button[@class='signUpButton marginTop10 mdl-button mdl-button--raised mdl-button--primary']")).click();
	  Thread.sleep(3000);

  }
  
  @Test(priority =1)
  public void TestCommandCenter() throws InterruptedException{
	    System.out.println("Started Test Case");

		Fillo fillo = new Fillo();
		try {
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\TestData.xls");
		String strQuery = "Select * from CC_URLs";
		Recordset recordset = connection.executeQuery(strQuery);
	
		Recordset recordset1 = connection.executeQuery(strQuery);
		
		System.out.println("Available Testcases " + recordset.getCount());

		while (true) {
			if(recordset.next() == false){
				recordset.moveFirst();
			}
				
			   recordset1.next();
		
		String url=recordset.getField("URL");
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		assertTrue(pageTitle.contains(recordset1.getField("ExpectedPage")), "Title mismatch");
		
		}

		
		
		
		} catch (FilloException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
    }
  
  }
 




