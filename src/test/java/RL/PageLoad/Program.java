package RL.PageLoad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class Program {
	
  @Test
  public void Headless(){
		// Declaring and initializing the HtmlUnitWebDriver
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();

		// open google.com webpage
		unitDriver.get("http://google.com");

		System.out.println("Title of the page is -> " + unitDriver.getTitle());

		// find the search edit box on the google page
		WebElement searchBox = unitDriver.findElement(By.name("q"));

		// type in Selenium
		searchBox.sendKeys("Selenium");

		// find the search button
		WebElement button = unitDriver.findElement(By.name("gbqfba"));

		// Click the button
		button.click();

		System.out.println("Title of the page is -> " + unitDriver.getTitle());

	}


}