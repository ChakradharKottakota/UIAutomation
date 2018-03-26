package RL.PageLoad;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatalystPageLoad {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println("Test Begins....");
		
		driver.get("http://neo.rlcatalyst.com");
		Thread.sleep(4000);
		System.out.println(driver.getCurrentUrl());
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("superadmin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("superadmin@123");
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		 
		  /*try {
			  driver.executeScript("window.location.href='http://neo.rlcatalyst.com/cat3/#/dashboard/bots/library/audittrail'") ; 
              driver.get("http://neo.rlcatalyst.com/cat3/#/dashboard/bots/library/audittrail");
			  Thread.sleep(5000);
			  System.out.println(driver.getCurrentUrl());
		  
		  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		  
		  driver.get("http://neo.rlcatalyst.com/cat3/#/dashboard/bots/library/audittrail");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  
		  driver.get("http://neo.rlcatalyst.com/private/index.html#ajax/Workflow/workflow.html");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  driver.get("http://neo.rlcatalyst.com/cat3/#/dashboard/workzone");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  
		  driver.get("http://neo.rlcatalyst.com/cat3/#/dashboard/design/AWS/list");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  driver.get("http://neo.rlcatalyst.com/cat3/#/dashboard/design/AWS/new");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  driver.get("http://neo.rlcatalyst.com/private/index.html#ajax/trackSettings.html");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  driver.get("http://neo.rlcatalyst.com/cat3/#/dashboard/CM/analytics/cost/");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  driver.get("http://neo.rlcatalyst.com/private/index.html#ajax/Settings/Dashboard.html");
		  Thread.sleep(5000);
		  System.out.println(driver.getCurrentUrl());
		  //driver.navigate().to("http://neo.rlcatalyst.com/cat3/#/dashboard/bots/library/library");
		 // driver.navigate().to(arg0);
		  Thread.sleep(5000);
		  driver.findElement(By.id("liuserinfo")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.id("signOut")).click();
		  driver.quit();
		  
	}
}

