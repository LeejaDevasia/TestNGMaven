package com.hyr.Tests;

import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.it.Date;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	ExtentTest logger;
	ExtentReports extent;
	
	    WebDriver driver ;
	    @BeforeTest
	    public void setup() {
	    	
	    
	    	String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(timestamp+"Report.html");
	    
	        // create ExtentReports and attach reporter(s)
	         extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // creates a toggle for the given test, adds all log events under it    
	         logger = extent.createTest("TradeMe Test Suite", "Report");
	    }
	    
	    
	     
	    
	    @AfterMethod
	    public void afterMethod(ITestResult result) {
	    	if(result.getStatus()==ITestResult.FAILURE)
	    	{
	    		logger.fail(result.getThrowable().getMessage());
	    	}
	    	else {
	    		logger.pass("passed");
	    	}
	    	extent.flush();
	    	
	    
	    }
	  //  @AfterTest
	  //  public void tearDown() {
	    //	driver.close();
	    //	driver.quit();
	    	
	   // }
	    
	    //////////////////////////////////
	
	
	
	@Test
	public void NumberofCarsinMakeDropDown() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.trademe.co.nz/a/");
		WebElement motorTab=driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-dynamic-homepage/tm-homepage-search-header/nav/div[2]/ul/li[3]/a"));
		motorTab.click();
		Thread.sleep(4000);
		
		WebElement dropDown=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-home-page[1]/tm-motors-home-page-header[1]/div[1]/div[1]/tm-motors-search-form[1]/form[1]/tm-motors-used-cars-large[1]/tg-row[1]/tg-col[2]/tg-select-container[1]/div[1]/select[1]"));
		Select dropdownNumber = new Select(dropDown);
		List<WebElement> elementCount = dropdownNumber.getOptions();
		System.out.println("Number of items: " + elementCount.size());
		Thread.sleep(4000);
				
	 Thread.sleep(2000);
	
	}
	
	public void NumberofCarswithBrandName(WebDriver driver) throws Exception {
		WebElement dropDown=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-home-page[1]/tm-motors-home-page-header[1]/div[1]/div[1]/tm-motors-search-form[1]/form[1]/tm-motors-used-cars-large[1]/tg-row[1]/tg-col[2]/tg-select-container[1]/div[1]/select[1]"));
		Select dropdownNumber = new Select(dropDown);
		dropdownNumber.selectByValue("Ferrari");
		WebElement SearchButton=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-home-page[1]/tm-motors-home-page-header[1]/div[1]/div[1]/tm-motors-search-form[1]/form[1]/tm-motors-used-cars-large[1]/tg-row[3]/tg-col[3]/button[1]"));
		SearchButton.click();
		Thread.sleep(2000);
		WebElement ShowingNumber=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-search-results[1]/div[1]/div[1]/div[1]/div[1]/tm-search-header-result-count[1]/h3[1]"));
		String NumberofCars="Number Cars: " + ShowingNumber.getText();
		Thread.sleep(4000);
		System.out.println(NumberofCars);
		
	}
	
	
}
