package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;

    By countryInput = By.id("country");
    By regionInput = By.id("region_id");
    By zipInput = By.id("postcode");
    By estimateLink = By.xpath("//span[contains(text(),'Estimate')]");
    By shippingCost = By.xpath(".//label[@for='s_method_flatrate_flatrate']");
    By updateTotalButton = By.xpath("//button[@title='Update Total']");
    By proceedToCheckoutButton = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterZip(String zip) {
        WebElement zipElement = driver.findElement(zipInput);
        zipElement.clear();
        zipElement.sendKeys(zip);
    }
    public void selectCountry(String country) {
        WebElement countryDropdown = driver.findElement(countryInput);
        Select countryOption = new Select(countryDropdown);
        countryOption.selectByValue(country);
    }

    public void selectRegion(String region) {
        WebElement regionDropdown = driver.findElement(regionInput);
        Select regionOption = new Select(regionDropdown);
        regionOption.selectByValue(region);
    }

    public void clickEstimate() {
        driver.findElement(estimateLink).click();
    }

    public void selectShippingCost() {
        WebElement shippingRadioButton = driver.findElement(shippingCost);
        shippingRadioButton.click();
    }

    public void clickUpdateTotal() {
        driver.findElement(updateTotalButton).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
    }
}
