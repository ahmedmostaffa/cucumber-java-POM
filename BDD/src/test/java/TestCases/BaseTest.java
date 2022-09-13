package TestCases;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;



public class BaseTest extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	//static String login_url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	//public static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.saucedemo.com/");

	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

}
	/*public static String capture(WebDriver base_page_driver, String screenshotName) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) base_page_driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir")+"/ErrorScreenShots/"+ screenshotName+ ".png";
			File destination = new File(dest);
			FileHandler.copy(source, destination);
			return dest;
		}
		

		  public static WebDriver getDriver()
		  
		  
		  {
			  return drivers.get();
		  }
		  
			public static String getDriverName()
			{
				Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
				return cap.getBrowserName().toLowerCase();
			}

}
*/