package com.automationframework.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static void captureScreenShot(WebDriver driver, String testName) throws IOException {
        // Step 1: Convert WebDriver object to TakesScreenshot interface
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        // Step 2: Call getScreenshotAs method to create image file
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        File dest = new File(System.getProperty("user.dir") + "//src//test//resources//Screenshots//" + testName + ".png");

        // Step 3: Copy image file to destination
        FileUtils.copyFile(src, dest);
    }
}
