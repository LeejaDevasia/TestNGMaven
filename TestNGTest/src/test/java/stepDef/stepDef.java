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
  
	
}

@Then("Total Number of brand names should appear")
public void total_number_of_brand_names_should_appear() throws Exception {
	WebElement dropDown=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-home-page[1]/tm-motors-home-page-header[1]/div[1]/div[1]/tm-motors-search-form[1]/form[1]/tm-motors-used-cars-large[1]/tg-row[1]/tg-col[2]/tg-select-container[1]/div[1]/select[1]"));
	Select dropdownNumber = new Select(dropDown);
	List<WebElement> elementCount = dropdownNumber.getOptions();
	int number=elementCount.size();
	System.out.println("Total number of brand is: " +number);
	Thread.sleep(2000);
}


@When("Click on {string}")
public void click_on(String string) throws Exception {
	WebElement dropDown=driver.findElement(By.xpath("/html[1]/body[1]/tm-root[1]/div[1]/main[1]/div[1]/tm-motors-home-page[1]/tm-motors-home-page-header[1]/div[1]/div[1]/tm-motors-search-form[1]/form[1]/tm-motors-used-cars-large[1]/tg-row[1]/tg-col[2]/tg-select-container[1]/div[1]/select[1]"));
	Select dropdownNumber = new Select(dropDown);
	dropdownNumber.selectByValue(string);
	WebElement Searchbutton=driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-motors-home-page/tm-motors-home-page-header/div/div/tm-motors-search-form/form/tm-motors-used-cars-large/tg-row[3]/tg-col[3]/button"));
	Searchbutton.click();
	Thread.sleep(1000);
	
}
@Then("Total Number of cars with {string} should appear")
public void total_number_of_cars_with_should_appear(String string) throws Exception {
	WebElement NumberOfResult=driver.findElement(By.xpath("/html/body/tm-root/div[1]/main/div/tm-motors-search-results/div/div/div[1]/div/tm-search-header-result-count/h3"));
	System.out.println("Number of cars with " +string+" is " +NumberOfResult.getText());
	Thread.sleep(2000);
}





}