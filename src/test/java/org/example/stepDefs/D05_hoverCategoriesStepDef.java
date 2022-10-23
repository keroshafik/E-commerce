package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    P03_homePage hovercatefory = new P03_homePage();
    SoftAssert softassert = new SoftAssert();
    Actions actions = new Actions(Hooks.driver);
    public static int selectedCategory;
    int selectedSubCategory;
    List<WebElement> subCategoryLinks;
    List<WebElement> maincategories;
    String locator;
    String selectedSubCategoryText;
    String selectedMainCategoryText;

    @Given("user hover on one of the main categories")
    public void hoverMainCategories() throws InterruptedException {
        maincategories =hovercatefory.getMainCategories();
        int count = maincategories.size();
        int min = 0;
        int max = count-1;
        selectedCategory = (int)Math.floor((Math.random()* max -min +1)+min);
        actions.moveToElement(maincategories.get(selectedCategory)).perform();
        selectedMainCategoryText = maincategories.get(selectedCategory).getText();
        System.out.println("Main category is selected:   " + selectedMainCategoryText);
        Thread.sleep(2000);


    }
    @When("user can view sub category if exist")
    public void userSelectSubCategory() {
        selectedCategory = selectedCategory + 1;
        locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
        Hooks.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @Then("user can select sub category or open main category")
    public void userSlectSubOrMaincategory() throws InterruptedException {
        if (selectedCategory > 0 && selectedCategory <= 3) {
            int count = subCategoryLinks.size();
            int min = 0;
            int max = count - 1;
            selectedSubCategory = (int) Math.floor(Math.random() * ( max - min + 1 ) + min);
            actions.moveToElement(subCategoryLinks.get(selectedSubCategory)).perform();
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            System.out.println("Sub category is selected:   " + selectedSubCategoryText);
            Thread.sleep(1000);
            subCategoryLinks.get(selectedSubCategory).click();
            softassert.assertEquals(hovercatefory.getPageTile().getText().toLowerCase().trim(), selectedSubCategoryText.toLowerCase().trim());
            softassert.assertAll();

        }else {
            maincategories.get(selectedCategory - 1).click();
            softassert.assertEquals(hovercatefory.getPageTile().getText().toLowerCase().trim(), selectedMainCategoryText.toLowerCase().trim());
            softassert.assertAll();
        }

        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
