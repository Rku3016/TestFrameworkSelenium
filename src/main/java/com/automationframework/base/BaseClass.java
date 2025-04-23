package com.automationframework.base;

import com.automationframework.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.automationframework.utilities.ScreenshotUtil;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    String url = readConfig.getKey("baseUrl");
    String browser = readConfig.getKey("browser");
    public String username = readConfig.getKey("username");
    public String password = readConfig.getKey("password");


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logger logger;

    public BaseClass() throws IOException {
    }

    @BeforeSuite
    public void setup() {

        // Set up WebDriver based on the browser passed from TestNG XML or Jenkins
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            default:
                driver.set(null);
                break;
        }

        // Ensure driver is not null
        assert driver.get() != null;

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger = LogManager.getLogger("TestAutomationFramework");
        driver.get().get(url);
        logger.info("URL opened: " + url);
    }

    @AfterSuite
    public void tearDown() {
        // Quit WebDriver after test completion
        if (driver.get() != null) {
            driver.get().quit();
        }
    }

    @BeforeMethod
    public void printInfo(ITestResult result) {
        logger.info("********Testcase : " + result.getMethod().getMethodName() + " started");
    }

    // Method to get WebDriver for current thread
    public WebDriver getDriver() {
        return driver.get();
    }
}

