package com.automationframework.testcases;

import com.automationframework.pageobject.loginPage;
import com.automationframework.pageobject.productPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginPage extends BaseClass{

    public TC_LoginPage() throws IOException {
    }

    @Test
    public void verifyLogin() throws InterruptedException, IOException {
        logger.info("***************TestCase Verify Login starts*****************");
        loginPage lp = new loginPage(driver);
        Thread.sleep(3000);
        lp.inputUsernameandPass(username,password);
        lp.clickOnSignIn();
        productPage pp = new productPage(driver);
        System.out.println(System.getProperty("user.dir"));
        if(pp.verifyTitle().equals("Products"))
        {
            logger.info("VerifyProductPage - Passed");
            Assert.assertTrue(true);
        }

		else
        {
            logger.info("VerifySignOut - Failed");
            captureScreenShot(driver,"verifyLogin");
            Assert.fail();
        }
    }

    @Test
    public void skipTest() {
        logger.info("***************TestCase - skipTest starts*****************");
        throw new SkipException("Skipping this test deliberately");
    }
}
