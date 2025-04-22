package com.automationframework.testcases;

import com.automationframework.pageobject.loginPage;
import com.automationframework.pageobject.productPage;
import com.automationframework.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginPage_datadriven extends BaseClass{

    public TC_LoginPage_datadriven() throws IOException {
    }

    @Test(dataProvider = "LoginDataProvider")
    public void verifyLogin(String username, String password) throws InterruptedException, IOException {
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
            lp.clickOnLogout();
        }

		else
        {
            logger.info("VerifySignOut - Failed");
            captureScreenShot(driver,"verifyLogin");
            Assert.fail();
        }

    }

    @DataProvider(name="LoginDataProvider")
    public String[][] LoginDataProvider(){
        String fileName = System.getProperty("user.dir")+"\\TestData\\testautomationdata.xlsx";
        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
        String data[][]=new String[ttlRows-1][ttlColumns];
        for(int i=1;i<ttlRows;i++)//rows =1,2
        {
            for(int j=0;j<ttlColumns;j++)//col=0, 1,2
            {

                data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
            }

        }
        return data;
    }

}
