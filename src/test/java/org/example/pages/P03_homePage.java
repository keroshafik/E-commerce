package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_homePage {
    public static void selectCurrency(String selection, By ElementId) {
        Select DDselection = new Select(Hooks.driver.findElement(ElementId));
        DDselection.selectByVisibleText(selection);
    }

    public List<WebElement> getEuroValues() {

        return Hooks.driver.findElements(By.className("price"));
    }

    public WebElement getSearchFiledElement() {

        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public WebElement clickSearchBtn() {

        return Hooks.driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }
    public List<WebElement> assertSearchValues() {

        return Hooks.driver.findElements(By.className("product-title"));
    }
    public WebElement clickOnProductSR() {

        return Hooks.driver.findElement(By.className("product-title"));
    }

    public WebElement assertSerialProduct() {

        return Hooks.driver.findElement(By.className("sku"));
    }
    public List<WebElement> getMainCategories() {

        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
    public WebElement getPageTile() {

        return Hooks.driver.findElement(By.className("page-title"));
    }
    public WebElement clickSliderElement() {

        return Hooks.driver.findElement(By.id("nivo-slider"));
    }

    public void implicitWait() {

        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    public void implicitWaitUntill(String elementpath, String elementattribute, String attributevalue) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBe(By.xpath(elementpath), elementattribute, attributevalue));
    }
    public WebElement clickFacebookLink() {

        return Hooks.driver.findElement(By.className("facebook"));
    }


    public WebElement clickTwitterLink() {

        return Hooks.driver.findElement(By.className("twitter"));
    }

    public WebElement clickYoutubeLink() {

        return Hooks.driver.findElement(By.className("youtube"));
    }

    public WebElement clickRssLink() {

        return Hooks.driver.findElement(By.className("rss"));
    }
    public WebElement clickWishlistBtn() {

        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement getWishlistProduct() {

        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/h2/a"));
    }

    public WebElement getBarNotification() {

        return Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div"));
    }

    public WebElement clickWishListLink() {

        return Hooks.driver.findElement(By.className("wishlist-label"));
    }

    public WebElement getQtyValue() {

        return Hooks.driver.findElement(By.className("qty-input"));
    }


}
