package com.qa.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonAction extends JavaScriptExecutor {

    public WebDriver driver;

    public CommonAction() {

    }

    public static void ClickAction(By by){
       try {
        WebDriverWait wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
        DrawBorder(Element);
        Element.click();
       } catch (InvalidElementStateException e){
           WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
           DrawBorder(Element);
           Element.click();
       }
    }
    public static void TypeAction(By by, String TypeMessage){
        try {
        WebDriverWait wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
        Element.sendKeys(TypeMessage);
        DrawBorder(Element);
        } catch (InvalidElementStateException e){
            WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
            Element.sendKeys(TypeMessage);
            DrawBorder(Element);
        }
    }

    public static String ReturnText(By by) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
        String Text = Element.getText();
        DrawBorder(Element);
        return Text;
    }
    public static String ReturnValue(By by){
        WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
        WebDriverWait wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(Element,"value"));
        String ValueText = Element.getAttribute("value");
        DrawBorder(Element);
        return ValueText;
    }
    public static String ReturnAttribute(By by,String Attribute){
        WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
        WebDriverWait wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(Element,Attribute));
        String ValueText = Element.getAttribute(Attribute);
        DrawBorder(Element);
        return ValueText;
    }

    public static String waitforNotification(By by){
        WebElement Element = WebDriverFactoryStaticThreadLocal.getdriver().findElement(by);
        WebDriverWait wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getdriver(), Duration.ofSeconds(500));
        wait.until(ExpectedConditions.textToBePresentInElement(Element,"2"));
        String ValueNonEmpty = Element.getText();
        DrawBorder(Element);
        return ValueNonEmpty;
    }
}
