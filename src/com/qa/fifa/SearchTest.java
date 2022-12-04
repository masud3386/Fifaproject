package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
@Test
	public void validateSearch() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("fifa world cup 2022");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		WebElement firstLink= driver.findElement(By.xpath("//*[@id=\"sports-app\"]/"
				+ "div/div[1]/div/div/div[1]/div/div[2]/div[2]"));
		String actualTest= firstLink.getText();
		
		String exptcted = "FIFA World Cup Qatar 2022™";
		
        Assert.assertTrue( actualTest.equalsIgnoreCase(exptcted) ,"Expected"+exptcted +" but found>>" +actualTest);
;		
		
		
		
	}
	
	
	
	
	
	
	
	
}
