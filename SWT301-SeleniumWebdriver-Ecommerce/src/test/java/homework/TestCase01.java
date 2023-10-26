package homework;

/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/

import driver.driverFactory;
import element.DnDHandle;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import test.HandleDropdown;

import java.io.File;
import java.time.Duration;

public class TestCase01 {
    @Test
    public void testCase1(){

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        try{
            /**
             * Step 1: Goto http://live.techpanda.org/
             */
            //2. Open target page
            driver.get("http://live.techpanda.org/");

            /**
             *  Step 2: Verify Title of the page
             */
            //3. Find page title
            WebElement titlePage = driver.findElement(new By.ByCssSelector("h2:nth-child(1)"));
            //3.1 Verify title of page
            AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", titlePage.getText());

            /**
             *  Step 3: Click on �MOBILE� menu
             */
            //4. Click on MOBILE -> Menu
            WebElement mobileLink = driver.findElement(new By.ByCssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));

            //debug purpose only
            Thread.sleep(2000);

            //4.1 Click MOBILE Link
            mobileLink.click();

            /**
             *  Step 4: In the list of all mobile ,
             *  select SORT BY -> dropdown as name
             */
            //5.Dropdown list
            WebElement dropdownElement = driver.findElement(new By.ByCssSelector("select[title='Sort By']"));
            //5.1 Init Select Option Instance
            Select selectOption = new Select(dropdownElement);
            //5.2 Select options in dropdown list
            selectOption.selectByVisibleText("Name");

            /**
             *  Verify all products are sorted by name
             */
            //6. Verify all produces sorted by name
            WebElement ele1 = driver.findElement(new By.ByCssSelector("h2[class='product-name'] a[title='IPhone']"));
            WebElement ele2 = driver.findElement(new By.ByCssSelector("h2[class='product-name'] a[title='Samsung Galaxy']"));
            WebElement ele3 = driver.findElement(new By.ByCssSelector("a[title='Sony Xperia']"));
            AssertJUnit.assertEquals("IPHONE", ele1.getText());
            AssertJUnit.assertEquals("SAMSUNG GALAXY", ele2.getText());
            AssertJUnit.assertEquals("SONY XPERIA", ele3.getText());

            //debug purpose only
            Thread.sleep(2000);

            // ScreenShot Capture
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String png = ("D:\\selenium-webdriver-java\\src\\test\\java\\homework\\TestCase01.png");
            FileUtils.copyFile(scrFile, new File(png));
        }catch(Exception ex){
            ex.printStackTrace();
        }

        // quit driver session
        driver.quit();
    }
}
