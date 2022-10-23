package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {

    P03_homePage search = new P03_homePage();

    SoftAssert softassert = new SoftAssert();


    @Given("^user enter search \"([^\"]*)\" and get search result$")
    public void enetrSearchkeyword(String keyword) throws InterruptedException {
        search.getSearchFiledElement().sendKeys(keyword);
        search. clickSearchBtn().click();
        Thread.sleep(2000);
    }

    @When("user get search result on valid page")
    public void userGetSearchResultOnValidPage() {
        softassert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        softassert.assertAll();

    }
    @Then("^user find each result contains the search word by keyword \"([^\"]*)\"$")
    public void validateSearchResultValues(String searchWord) {
        List<WebElement> searchkeyword = search.assertSearchValues();
        for (WebElement element : searchkeyword) {
            softassert.assertTrue(element.getText().toLowerCase().contains(searchWord));
            softassert.assertAll();
            System.out.println(element.getText());
        }

    }
    @When("user click on the product in search result")
    public void  clickOnProductSR() {
        search.clickOnProductSR().click();
    }

    @Then("^user find each result contains the search word by sku \"([^\"]*)\"$")
    public void userFindEachResultContainsTheSearchWordBySku(String skuWord) {
        System.out.println("Serial Full value: " + search.assertSerialProduct().getText());
        String Skuvalue = search.assertSerialProduct().getText();
        String[] Skuvalueplited = Skuvalue.split(": ");
        System.out.println("Sku Value: " + Skuvalueplited[1].trim());
        Assert.assertTrue(search.assertSerialProduct().getText().contains(skuWord));
        Assert.assertEquals(Skuvalueplited[1].trim(), skuWord);

    }



}
