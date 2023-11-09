package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderManagementPage {

    WebDriver driver;

    public  OrderManagementPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private String From = "11/03/2023";
    private String To = "11/09/2023";
    private String Id = "100021252 ";
    By OrderIdInput = By.xpath("//input[@id='sales_order_grid_filter_real_order_id']");
    By FromInput = By.name("created_at[from]");
    By ToInput = By.name("created_at[to]");
    By SearchButton = By.xpath("//span[contains(text(),'Search')]");
    public void enterFromInput()
    {
        driver.findElement(FromInput).sendKeys(From);
    }
    public void enterToInput(){
        driver.findElement(ToInput).sendKeys(To);
    }
    public  void enterOrderID()
    {
        driver.findElement(OrderIdInput).sendKeys(Id);
    }

    public void clickSearch(){driver.findElement(SearchButton).click();}

}