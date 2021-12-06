package com.kodilla.testing2.google.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {

    public static final String CHROME = "CHROME_DRIVER";

    public static WebDriver getDriver(final String driver) {
        if (driver.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver","/Users/mateuszolszak/Documents/Development/Kodilla/chromedriver");
            return new ChromeDriver();
        } else {
            return null;
        }
    }
}
