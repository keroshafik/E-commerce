package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    P03_homePage wishlist = new P03_homePage();
    SoftAssert softAssert = new SoftAssert();

    @Given("user click on wishlist button")
    public void clickOnWishlistBTn() {
        softAssert.assertEquals(wishlist.getWishlistProduct().getText(), "HTC One M8 Android L 5.0 Lollipop");
        wishlist.clickWishlistBtn().click();
        softAssert.assertAll();
    }

    @Then("user can get successfully message")
    public void userCanGetSuccessfullyMessage() {
        wishlist.implicitWaitUntill("//*[@id=\"bar-notification\"]/div", "style", "display: block;");
        softAssert.assertTrue(wishlist.getBarNotification().isDisplayed());
        String background = Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div")).getCssValue("background-color");
        System.out.println(background);
        String convertedbackgroundcolor = Color.fromString(background).asHex();
        softAssert.assertEquals(convertedbackgroundcolor, "#4bb07a");
        System.out.println(convertedbackgroundcolor);
        softAssert.assertAll();
    }
    @And("user open wishlist page")
    public void userOpenWishlistPage() throws InterruptedException {
        Thread.sleep(5000);
        wishlist.clickWishListLink().click();

    }

    @Then("user can check the product Qty")
    public void userCanCheckTheProductQty() throws InterruptedException {
        Thread.sleep(2000);
        String QtyValue = wishlist.getQtyValue().getAttribute("value");
        System.out.println(QtyValue);
        softAssert.assertNotEquals(QtyValue, "0");
        softAssert.assertAll();

    }
}
