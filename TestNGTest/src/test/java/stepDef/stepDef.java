package stepDef;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDef{
	
	WebDriver driver = new ChromeDriver();

@Given("Open broweser with url")
public void open_broweser_with_url() {

	WebDriverManager.chromedriver().setup();
	driver.manage().window().maximize();
	driver.get("https://www.trademe.co.nz/a/");
	
  
}

@When("when go to motors and click on makes")
public void when_go_to_motors() throws Exception{
	WebElement motorTab=driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-dynamic-homepage/tm-homepage-search-header/nav/div[2]/ul/li[3]/a"));
	motorTab.click();
	Thread.sleep(2000);
  
	WebElement dropDown=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-home-page[1]/tm-motors-home-page-header[1]/div[1]/div[1]/tm-motors-search-form[1]/form[1]/tm-motors-used-cars-large[1]/tg-row[1]/tg-col[2]/tg-select-container[1]/div[1]/select[1]"));
	//dropDown.selectByvalue();
	Select dropdownNumber = new Select(dropDown);
	//dropdownNumber.selectByValue("BMW");
	//dropDown.click();
	
	List<WebElement> elementCount = dropdownNumber.getOptions();
	int number=elementCount.size();
	System.out.println("Number of items: " +number);
	Thread.sleep(2000);
}

@Then("Total Number of brand names should appear")
public void total_number_of_brand_names_should_appear(WebDriver driver) {
	
 
  System.out.println("Test Passed ");
	//Thread.sleep(4000);
	
	
		      //  Assert.notNull(number);
	//driver.close();
	//driver.quit();
   
}


}