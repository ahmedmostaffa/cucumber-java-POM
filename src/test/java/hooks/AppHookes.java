package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHookes {
    @Before
    public static  void initDriver(){
        System.out.println("run before every scenario");
    }
    @After
    public static  void closeDriver(Scenario scenario){


        System.out.println("run after every scenario");
    }
}
