package com.qa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class CommonDriver {

    public static ChromeDriver driver;

    public static WebDriver getdriver() {
        if (driver == null) {
            String downloadDir = System.getProperty("user.dir") + "\\src\\test\\resources\\DownloadDirectory";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadDir);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

}
