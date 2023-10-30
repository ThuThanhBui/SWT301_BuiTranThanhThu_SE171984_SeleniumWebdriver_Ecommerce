package homework;

import POM.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestCase05 {
    @Test
    public void Testcase05(){
        String firstName = "Thu";
        String lastName = "Bui";
        String email = "thanhthu2608200333@gmail.com";
        String password = "thanhthu123";
        String confirmPassword = password;

        WebDriver driver = driverFactory.getChromeDriver();
        try{

            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);

            registerPage.clickMyAccountLink();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.clickCreateAccountLink();


            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            registerPage.enterFirtstName(firstName);
            registerPage.enterLastName(lastName);
            registerPage.enterEmail(email);
            registerPage.enterPassword(password);
            registerPage.enterConfirmPassword(confirmPassword);
            registerPage.clickRegisterButton();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // Step 4: Verify Registration is done. Expected account registration done.
            WebElement successMessage = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']"));
            Assert.assertEquals(successMessage.getText(),"Thank you for registering with Main Website Store.");

            // Step 5: Go to TV menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
            tvMenu.click();

            // Step 6: Add product in your wish list - use product - LG LCD
            WebElement lgLcdAddToWishlist = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]"));
            lgLcdAddToWishlist.click();

            // Step 7: Click SHARE WISHLIST
            WebElement shareWishlistLink = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareWishlistLink.click();

            // Step 8: In next page enter Email and a message and click SHARE WISHLIST
            WebElement emailInputWishlist = driver.findElement(By.id("email_address"));
            emailInputWishlist.sendKeys("test@example.com");
            WebElement messageInput = driver.findElement(By.id("message"));
            messageInput.sendKeys("Check out my wishlist!");
            WebElement shareWishlistButton = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
            shareWishlistButton.click();

            // Step 9: Check wishlist is shared. Expected wishlist shared successfully.
            WebElement wishlistSharedMessage = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            Assert.assertEquals(wishlistSharedMessage.getText(),"Your Wishlist has been shared.");

            // ScreenShot Capture
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("E:\\SWT\\swt_selenium\\SWT301-SeleniumWebdriver-Ecommerce\\src\\test\\java\\homework\\TestCase05.png");
            FileUtils.copyFile(scrFile, new File(png));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}