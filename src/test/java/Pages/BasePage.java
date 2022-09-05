package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 
 public class BasePage 
 {
 	WebDriver driver;
 
 	
 	public BasePage(WebDriver driver) {
 		this.driver=(WebDriver) driver;
 	}
 	
 	
 	public void load_page(String URL) {
 		driver.get(URL);
 	}
 	
 	public void implicit_wait(int time_amount) {
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time_amount));
 	}
 	
 	public void explicit_wait(int max_time,By locator) {
 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(max_time));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 	}
 	
 	public String getPageTilte() {
 		return driver.getTitle(); 
 	}
 	
 	public void scrolltoBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page till the bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
 	}
 	
 	public void scrolltoElement(WebElement element){	 
        JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page till the webElement is found or visible
        js.executeScript("arguments[0].scrollIntoView()",element);
 	}
 	public void TakeScreenShot() throws IOException {
 		try {
 			Date date=new Date();  
 		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
 		    String str = formatter.format(date).replace(" ", "-").replace(":", "-");
 			File screenshot_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 			FileUtils.copyFile(screenshot_file , new File("C:\\Users\\ammabrouk\\eclipse-workspace\\mvn_selenium_flight\\ScreenShots\\"+str+".png"));
 			
 		}catch(IOException IO_exc) {
 			IO_exc.getMessage();
 		}
 	}
 	
 	
    public static void main( String[] args )
    {
         System.out.println( "BasePage" );
    }
 }
