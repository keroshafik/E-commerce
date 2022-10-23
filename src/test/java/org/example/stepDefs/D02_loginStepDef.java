package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.D01_registerStepDef.registeredemial;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    SoftAssert softassert = new SoftAssert();
    @Given("user go to login page")
    public void openLoginPage() {

        login.loginIcon.click();
    }

    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void userLoginWithAnd(String arg0, String email, String password) {

        login.enterEmail.sendKeys(registeredemial);
        login.enterpassword.sendKeys(password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginBtn.click();

    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        softassert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softassert.assertTrue(login.myAccountTab.isDisplayed());
        softassert.assertAll();

    }
    @When("user login unsuccessfully with {string} {string} and {string}")
    public void userLoginUnsuccessfullyWithAnd(String arg0, String arg1, String password) {

        login.enterEmail.sendKeys(arg1+"wnn");
        login.enterpassword.sendKeys(password);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
    }
}
