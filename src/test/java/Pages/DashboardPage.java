package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
public class DashboardPage extends BasePage{
	
	
	By QuickLaunch_element=By.cssSelector("div.quickLaunge>a>span");
	By TimeSheet_link=By.xpath("(//*[@class='quickLaunge']/a)[3]");
	By Vacancies_link=By.linkText("Vacancies");
	By Candidates_link=By.id("menu_recruitment_viewRecruitmentModule");
	By Vacancies_header=By.cssSelector("a.toggle.tiptip");
	By page_header=By.cssSelector(".head>h1");
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> getQuickLaunch() {
		List<WebElement> QuickLaunchList = driver.findElements(QuickLaunch_element);
		return QuickLaunchList;		
	}
	public String getPageHeader() {
		String header_title= driver.findElement(page_header).getText();
		return header_title;
	}
	public void  ClickOnTimeSheet() {
		driver.findElement(TimeSheet_link).click();
	}

	public void ClickOnCandidatesTab() {
		driver.findElement(Candidates_link).click();
	}

	public void ClickOnVacanciesTab() {
		Actions action=new Actions(driver);
		WebElement RecTab= driver.findElement(Candidates_link);
		action.moveToElement(RecTab).perform();
		driver.findElement(Vacancies_link).click();
		
		/*
		 * js.executeScript("$0.style.display='block';");
		 * driver.findElement(Vacancies_link).click();
		 */
	}
	
	
	public boolean VerifyVacanciesHeader() {
		return driver.findElement(Vacancies_header).isDisplayed();
	}

}
