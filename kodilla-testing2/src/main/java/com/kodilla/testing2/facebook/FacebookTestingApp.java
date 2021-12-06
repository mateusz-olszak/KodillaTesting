package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static final String COOKIES_ACCEPT = "//button[text()='Allow All Cookies']";
    public static final String CREATE_NEW_ACCOUNT = "//a[text()='Create New Account']";

    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL_ADDRESS = "reg_email__";
    public static final String EMAIL_ADDRESS_CONF = "reg_email_confirmation__";
    public static final String PASSWORD = "reg_passwd__";
    public static final String DAY_OF_BIRTH = "//span[contains(@class, \"_5k_4\")]/span/select[1]";
    public static final String MONTH_OF_BIRTH = "//span[contains(@class, \"_5k_4\")]/span/select[2]";
    public static final String YEAR_OF_BIRTH = "//span[contains(@class, \"_5k_4\")]/span/select[3]";
    public static final String GENDER = "//span[contains(@class, \"_5k_3\")]/span[2]/input";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(COOKIES_ACCEPT)).click();

        driver.findElement(By.xpath(COOKIES_ACCEPT)).click();

        WebElement createAccount = driver.findElement(By.xpath(CREATE_NEW_ACCOUNT));
        createAccount.click();

        TimeUnit.SECONDS.sleep(1);
        fillOutForm(driver);

    }

    private static void fillOutForm(WebDriver driver) {
        driver.findElement(By.name(FIRSTNAME)).sendKeys("Mateusz");
        driver.findElement(By.name(LASTNAME)).sendKeys("Olszak");
        driver.findElement(By.name(EMAIL_ADDRESS)).sendKeys("test@gmail.com");
        driver.findElement(By.name(EMAIL_ADDRESS_CONF)).sendKeys("test@gmail.com");
        driver.findElement(By.name(PASSWORD)).sendKeys("password");

        WebElement selectComboDay = driver.findElement(By.xpath(DAY_OF_BIRTH));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(20);

        WebElement selectComboMonth = driver.findElement(By.xpath(MONTH_OF_BIRTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(10);

        WebElement selectComboYear = driver.findElement(By.xpath(YEAR_OF_BIRTH));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByIndex(20);

        WebElement gender = driver.findElement(By.xpath(GENDER));
        gender.click();
    }
}
