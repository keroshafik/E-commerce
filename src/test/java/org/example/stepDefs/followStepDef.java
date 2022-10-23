package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePages;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class followStepDef {
    P03_homePages follow = new P03_homePages();
    ArrayList<String> tabs;

    @Given("^userOpens \"(.*)\" link$")
    public void clickOnFacebookLink(String link) {
        switch (link) {
            case "linkedIN":
                follow.clickFacebookLink().click();
                break;
            case "google":
                follow.clickTwitterLink().click();
                break;
            case "wekepedia":
                follow.clickRssLink().click();
                break;
            case "youtube":
                follow.clickYoutubeLink().click();
                break;
        }

    }

    @When("user can displays new tab")
    public void userDisplayNewTab() {
        WebDriverWait waits = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

    }
    @And("user can switch between two taps")
    public void userCanSwitchBetweenTwoTabs() throws InterruptedException {
        Thread.sleep(4000);
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1 :  " + Hooks.driver.getCurrentUrl());
        Thread.sleep(4000);
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0 :  " + Hooks.driver.getCurrentUrl());
        Thread.sleep(2500);
        Hooks.driver.switchTo().window(tabs.get(1));

    }

    @Then("^\"(.*)\" is opened in new tab")
    public void asserURL(String URL) throws InterruptedException {
        Thread.sleep(6000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), URL);
        Hooks.driver.close();
    }
}
