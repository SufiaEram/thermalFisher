package ThermoFisherAssignment.stepFiles;


import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public  class thermoFisherAssignment {

	WebDriver driver;

	@Before 
	public void Setup() throws Throwable {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();		
	}

	@After
	public void tearDown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver =null;
	}

	@Given("User Need to navigate to webpage")
	public void navigateToWebPage() throws Throwable {

		this.driver.get("https://www.thermofisher.com/");
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(1);
		//int size = this.driver.findElements(By.tagName("iframe")).size();
		//System.out.println(size);
		Thread.sleep(1000);
		this.driver.findElement(By.xpath("/html/body/div[8]/div[1]/div/div[3]/a[1]")).click();

	}

	@When("access quick order page") 
	public void accessOrderPage() throws Throwable  {
		Thread.sleep(1000);
		this.driver.findElement(By.className("user-utility-link")).click();
	}

	@Then("Verify {int} rows and {int} colums") 
	public  void numberRowsAndColumn(Integer int1, Integer int2) {
		
		java.util.List<WebElement> row = this.driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[1]/form/div[1]/div[4]/div/table/tbody"));
        System.out.println("Number of rows: "+row.size());
		java.util.List<WebElement> column = this.driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[1]/form/div[1]/div[4]/div/table/tbody[1]/tr/td"));
        int a = column.size()-1;  //to cut the delete row 
		System.out.println("Number of column: "+a);
		System.out.println("Number of column considering Delete row :" + column.size());
        
	}

	@And("return the columns headers") 
	public void columnHeader() {
	   System.out.println("Header are as below :");
	   java.util.List<WebElement> header = this.driver.findElements(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[1]/form/div[1]/div[4]/div/table/thead/tr/td"));
	   for(int i =0;i<header.size();i++) {
		   String headerText = header.get(i).getText();
		   System.out.println(headerText);
	   }
		
	}

}
