package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {

    WebDriver driver;

    By addToCartBtn = By.xpath("//span[contains(text(),'Add to Cart')]");

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }
}
