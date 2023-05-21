package com.qa.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

    // calling the method
    public static void DrawBorder(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) CommonDriver.getdriver();
        js.executeScript("arguments[0].style.border='3px solid green'", element);
    }
    public static void DrawBarLength(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) CommonDriver.getdriver();
        js.executeScript("arguments[0].style.left= '98.00%'", element);
    }
    public static void DrawBarWidth(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) CommonDriver.getdriver();
        js.executeScript("arguments[0].style.width= '98.00%'", element);
    }
}
