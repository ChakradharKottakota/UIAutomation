package RL.PageLoad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class CMPPageLoad {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Test Begins....");
		
		try{
		
		driver.get("https://market.rlcatalyst.com/auth/signin");
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		
		
		
		driver.get("https://market.rlcatalyst.com/contract");
	    Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/endcustomer");
	    Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/endcustomerspendlimit");
	    Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/orders");
	    Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/partnerentity");
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/partnerentitycredit");
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/reports");
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://market.rlcatalyst.com/user");
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
    }
}
