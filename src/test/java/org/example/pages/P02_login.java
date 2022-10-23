package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {

    public P02_login() {

        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(className ="ico-login")
    public WebElement loginIcon;

    @FindBy (id = "Email")
    public WebElement enterEmail;


    @FindBy (id = "Password")
    public WebElement enterpassword;

    @FindBy(xpath = "//Button[@class=\"button-1 login-button\"]")
    public WebElement loginBtn;

    @FindBy (className = "ico-account")
    public WebElement myAccountTab;

    @FindBy (className = "message-error")
    public WebElement unSuccessMsg;

    public void loginSteps(String email, String password) {
        enterEmail.sendKeys(email);
        enterpassword.sendKeys(password);
    }

}
