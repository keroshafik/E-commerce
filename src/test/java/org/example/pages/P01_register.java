package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {

    public P01_register() {
        PageFactory.initElements(Hooks.driver,this);

    }
    @FindBy(className = "ico-register")
    public WebElement registerBtn;

    @FindBy(id = "gender-male")
    public WebElement Gender;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement LastName;

    @FindBy(id="Password")
    public WebElement setPassword;

    @FindBy(id="ConfirmPassword")
    public WebElement ConfPassword;
    @FindBy(id="register-button")
    public WebElement registerButton;

    @FindBy(id="Email")
    public WebElement enterEmail;


}
