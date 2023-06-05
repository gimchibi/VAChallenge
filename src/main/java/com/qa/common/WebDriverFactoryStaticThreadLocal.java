package com.qa.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class WebDriverFactoryStaticThreadLocal {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\resources\\DownloadDirectory";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadDir);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver.set(new ChromeDriver(options));
    }

    public static WebDriver getdriver()
    {
        return driver.get();
    }

    public static void closeBrowser()
    {
        driver.get().close();
        driver.remove();
    }
}
