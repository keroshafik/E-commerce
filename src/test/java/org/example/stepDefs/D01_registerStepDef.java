package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D01_registerStepDef {
    P01_register register = new P01_register();
    public static String registeredemial;


        @Given("user go to register page" )
            public void  register_page()
            {
                register.registerBtn.click();
              }


    @When("user select gender type")
    public void userSelectGenderType() {
        register.Gender.click();

    }

    @And("ser enter first name {string} and last name {string}")
    public void serEnterFirstNameAndLastName(String firstName, String lastName) {
        register.firstName.sendKeys(firstName);
        register.LastName.sendKeys(lastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select day = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        day.selectByValue("1");

        Select month = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByValue("10");

        Select year = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("1998");

    }

    @And("user enter email field")
    public void userEnterEmailField() {
        Faker faker = new Faker();
        String email = faker.internet().safeEmailAddress();
        register.enterEmail.sendKeys(email);
        System.out.println(email);
        registeredemial = email;

    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String ConfirmPassword) {
        register.setPassword.sendKeys(password);
        register.ConfPassword.sendKeys(ConfirmPassword);

    }

    @And("user clicks on register button")
    public void userClicksOnRegisterBTN() {
        register.registerButton.sendKeys(Keys.ENTER);
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        Assert.assertEquals("https://demo.nopcommerce.com/registerresult/1?returnUrl=/",Hooks.driver.getCurrentUrl());
    }
}