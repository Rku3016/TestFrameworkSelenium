package com.automationframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class productPage {
    WebDriver ldriver;
    public productPage(WebDriver rdriver){
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(xpath = "//*[@class='title' and text()='Products']")
    WebElement productPageTitle;


    public String verifyTitle(){
        String actualTitle = productPageTitle.getText();
        return actualTitle;

    }
}
