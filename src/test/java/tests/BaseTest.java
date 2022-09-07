package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.time.Duration.*;


public class BaseTest  {
	public static WebDriver driver;



	@BeforeClass
	public void SetUp( ) throws InterruptedException {
		String browser="chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//ChromeOptions options = new ChromeOptions();
			System.out.println("Run Tests in"+ " "+ browser +" "+"at" +" "+ "Thread"+" " +Thread.currentThread().getId());

			driver= new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//FirefoxOptions options=new FirefoxOptions();
			System.out.println("Run Tests in"+ " "+ browser +" "+"at" +" "+ "Thread"+" " +Thread.currentThread().getId());
			driver= new FirefoxDriver();
		}
    	// load login page
		driver.manage().window().maximize();
    	driver.get("https://www.saucedemo.com/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	
	@AfterClass
    public void tearDown(){
    	driver.quit();
    	
    }
	

	


}
