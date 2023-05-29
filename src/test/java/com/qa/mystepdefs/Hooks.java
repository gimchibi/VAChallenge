package com.qa.mystepdefs;

import com.qa.common.WebDriverFactoryStaticThreadLocal;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        WebDriverFactoryStaticThreadLocal.setDriver();
    }
    @AfterStep
    public void Screenshot(Scenario scenario){
        TakesScreenshot ts = (TakesScreenshot) WebDriverFactoryStaticThreadLocal.getdriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach((screenshot), "image/png", scenario.getName());
    }
    @After
    public void tearDown(){
        WebDriverFactoryStaticThreadLocal.closeBrowser();
    }
}
