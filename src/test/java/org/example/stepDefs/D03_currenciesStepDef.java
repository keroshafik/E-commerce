package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_homePage currency = new P03_homePage();


    @Given("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrency(){
        P03_homePage.selectCurrency("Euro", By.id("customerCurrency"));

    }

    @Then("Find all Elements with Euro currency")
    public void findAllElementsWithEuroCurrency() {
        List<WebElement> euroValues = currency.getEuroValues();
        for (WebElement eurovalue : euroValues) {
            Assert.assertTrue(eurovalue.getText().contains("€"));
            System.out.println(eurovalue.getText());
        }

    }
}
