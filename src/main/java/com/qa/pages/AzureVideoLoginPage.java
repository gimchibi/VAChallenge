package com.qa.pages;

import com.qa.common.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AzureVideoLoginPage {

    public WebDriver driver;

    // Locators
    private final By UserLoginButton = By.id("viLoginGoogle");
    private final By UserNameInputLocation = By.id("identifierId");
    private final By UserNameNextButtonLocator = By.xpath("//*[@id='identifierNext']/div/button");
    private final By UserPasswordInputLocation = By.name("Passwd");
    private final By UserPasswordNextButtonLocator = By.xpath(" //*[@id='passwordNext']/div/button");


    public AzureVideoLoginPage(WebDriver driver) {
        this.driver = driver;}

    // Methods
    public void UserLoginButton(){
        CommonAction.ClickAction(UserLoginButton);
    }
    public void enterUserEmail(String UserName) {
        CommonAction.TypeAction(UserNameInputLocation,UserName);
    }
    public void UserEmailNextButton(){
        CommonAction.ClickAction(UserNameNextButtonLocator);
    }
    public void enterUserPassword(String UserPassword) {
        CommonAction.TypeAction(UserPasswordInputLocation,UserPassword);
    }
    public void UserPasswordNextButton(){
        CommonAction.ClickAction(UserPasswordNextButtonLocator);
    }

}
