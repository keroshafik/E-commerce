package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_homePages CURRENCYTYPE = new P03_homePages();


    @Given("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrency(){
        P03_homePages.selectCurrency("Eurooo", By.id("customerCurrency"));

    }

    @Then("Find all Elements with Euro currency")
    public void findAllElementsWithEuroCurrency() {
        List<WebElement> euroValues = CURRENCYTYPE.getEuroValues();
        for (WebElement eurovalue : euroValues) {
            Assert.assertTrue(eurovalue.getText().contains("€"));
            System.out.println(eurovalue.getText());
        }

    }
}
