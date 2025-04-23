package com.automationframework.testcases;

import com.automationframework.base.BaseClass;
import com.automationframework.pages.loginPage;
import com.automationframework.pages.productPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.automationframework.utilities.ScreenshotUtil.captureScreenShot;

public class TC_LoginPage extends BaseClass {

    public TC_LoginPage() throws IOException {
    }

    @Test
    public void verifyLogin() throws InterruptedException, IOException {
        //logger.info("***************TestCase Verify Login starts*****************");
        loginPage lp = new loginPage(getDriver()); // Use getDriver() for thread-safe driver
        Thread.sleep(1500);
        lp.inputUsernameandPass(username, password);
        lp.clickOnSignIn();
        productPage pp = new productPage(getDriver()); // Use getDriver() for thread-safe driver
        System.out.println(System.getProperty("user.dir"));
        if (pp.verifyTitle().equals("Products")) {
            logger.info("VerifyProductPage - Passed");
            Assert.assertTrue(true);
            captureScreenShot(getDriver(), "verifyLogin");
            lp.clickOnLogout();
        } else {
            logger.info("VerifySignOut - Failed");
            captureScreenShot(getDriver(), "verifyLogin"); // Use getDriver() for thread-safe driver
            Assert.fail();
        }
    }

    @Test
    public void skipTest() {
      //  logger.info("***************TestCase - skipTest starts*****************");
        throw new SkipException("Skipping this test deliberately");
    }

    @Test
    public void failTest() {
       // logger.info("***************TestCase - failTest starts*****************");
        Assert.fail();
    }
}
