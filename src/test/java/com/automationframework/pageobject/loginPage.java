package com.automationframework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver ldriver;
    public loginPage(WebDriver rdriver){
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;


    public void inputUsernameandPass(String user, String pass){
        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
    }
    public void clickOnSignIn(){

        loginBtn.click();
    }

    public void clickOnLogout(){

        menu.click();
        logout.click();
    }
}
