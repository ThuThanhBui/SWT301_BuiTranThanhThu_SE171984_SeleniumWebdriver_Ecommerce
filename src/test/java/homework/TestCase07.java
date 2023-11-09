package homework;

import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

/*-------------TESTCASE07-------------------------

Verify that you will be able to save previously placed order as a pdf file

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link
*/
public class TestCase07 {
    WebDriver driver = driverFactory.getChromeDriver();

    @Test
    public void TestCase07(){
        try{
            String firstname = "Thu";
            String lastname = "Bui";
            String email = "thanhthu2608@gmail.com";
            String password = "@Thanhthu2608";
            String address = "United States";
            String country = "US";
            String company = "FPT";
            String region = "57";
            String zip = "2000";
            String city = "Texas";
            String telephone = "0123456789";
            String state = "Ya";

            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            //2. Click on My Account link
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();
            //3. Login in application using previously created credential
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

            Thread.sleep(5000);

            //4. Click on 'My Orders'
            driver.findElement(By.linkText("MY ORDERS")).click();
            //5. Click on 'View Order'
            driver.findElement(By.xpath("//a[normalize-space()='View Order']")).click();

            //6. Click on 'Print Order' link
            driver.findElement(By.xpath("//a[@class='link-print']")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\SWT\\BuiTranThanhThu_SE171984\\src\\test\\java\\homework\\TestCase05.png");

            FileUtils.copyFile(scrFile, new File(png));
        }catch(Exception ex){
            ex.printStackTrace();
        }

        driver.quit();
    }
}