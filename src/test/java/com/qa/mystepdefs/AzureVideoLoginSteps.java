package com.qa.mystepdefs;

import com.qa.common.CommonDriver;
import com.qa.Utils.TestProperites;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.pages.AzureVideoLoginPage;

import java.io.IOException;
import java.time.Duration;

public class AzureVideoLoginSteps {

    private AzureVideoLoginPage AzureVideoLoginPage;
    private WebDriver driver;

    @AfterStep
    public void Screenshot(Scenario scenario){
        TakesScreenshot ts = (TakesScreenshot) CommonDriver.getdriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach((screenshot), "image/png", scenario.getName());
    }
    @After
    public void tearDown(){
        CommonDriver.getdriver().quit();
    }

    @Given("I am on the VA Login page")
    public void i_am_on_the_VA_login_page() throws IOException {
        CommonDriver.getdriver().get(TestProperites.loginprop().getProperty("VAURL"));
        CommonDriver.getdriver().manage().window().maximize();
        CommonDriver.getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        AzureVideoLoginPage = new AzureVideoLoginPage(CommonDriver.getdriver());
    }
    @And("I have entered a valid username and password of VA login page")
    public void i_have_entered_a_valid_username_and_password_BGP() throws IOException, InterruptedException {
        AzureVideoLoginPage.UserLoginButton();
        AzureVideoLoginPage.enterUserEmail(TestProperites.loginprop().getProperty("enterEmail"));
        AzureVideoLoginPage.UserEmailNextButton();
        AzureVideoLoginPage.enterUserPassword(TestProperites.loginprop().getProperty("enterEmailPassword"));
        AzureVideoLoginPage.UserPasswordNextButton();
    }
}
