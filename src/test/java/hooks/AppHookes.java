package hooks;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.BaseTest;

public class AppHookes extends BaseTest {
    @Before
    public static void initDriver() {
        System.out.println("run before every scenario");
    }

    @After
    public static void closeDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            Shutterbug.shootPage(driver).save();

            System.out.println(scenario.getId());
            System.out.println(scenario.getStatus());
            System.out.println(scenario.getName());
            System.out.println(scenario.getSourceTagNames());
            System.out.println(scenario.getUri());
            if (scenario.isFailed()) {
                ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
            }


        }


        System.out.println("run after every scenario");
    }

    private static String getBase64Screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
