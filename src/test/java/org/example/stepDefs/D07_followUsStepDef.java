package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage followus = new P03_homePage();
    ArrayList<String> tabs;

    @Given("^user opens \"(.*)\" link$")
    public void clickOnFacebookLink(String linktype) {
        switch (linktype) {
            case "facebook":
                followus.clickFacebookLink().click();
                break;
            case "twitter":
                followus.clickTwitterLink().click();
                break;
            case "rss":
                followus.clickRssLink().click();
                break;
            case "youtube":
                followus.clickYoutubeLink().click();
                break;
        }

    }

    @When("user can display new tab")
    public void userCanDisplayNewTab() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

    }
    @And("user can switch between two tabs")
    public void userCanSwitchBetweenTwoTabs() throws InterruptedException {
        Thread.sleep(3000);
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " + Hooks.driver.getCurrentUrl());
        Thread.sleep(2000);
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());
        Thread.sleep(2000);
        Hooks.driver.switchTo().window(tabs.get(1));

    }

    @Then("^\"(.*)\" is opened in new tab")
    public void asserURL(String URL) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), URL);
        Hooks.driver.close();
    }
}
