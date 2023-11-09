package homework;

import POM.CartPage;
import POM.HomePage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/
public class TestCase09 {
    @Test
    public void TestCase09(){
        // Web driver
        WebDriver driver = driverFactory.getChromeDriver();

        try{
            /*
             * Verify Discount Coupon works correctly
             * */

            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");

            // 2. Go to Mobile and add IPHONE to cart
            HomePage homepage = new HomePage(driver);
            homepage.clickMobileLink();
            homepage.addIphoneToCart();

            // 3. Enter Coupon Code
            CartPage cartPage = new CartPage(driver);
            // get current grand total
            String actualTotal = cartPage.getGrandTotal();
            System.out.println("Actual grand total: " + actualTotal);
            // 3.1 Apply Coupon
            String coupon = "GURU50";
            cartPage.applyCoupon(coupon);
            // get grand total change
            String expectedTotal = cartPage.getGrandTotal();
            System.out.println("Expected grand total: " + expectedTotal);

            Assert.assertNotEquals(actualTotal, expectedTotal);



        /*  Verify Discount Coupon works correctly

        Test Case Description:

        1. Go to http://live.techpanda.org/

        2. Go to Mobile and add IPHONE to cart

        3. Enter Coupon Code

        4. Verify the discount generated

        TestData:  Coupon Code: GURU50

        Expected result:

        1) Price is discounted by 5%

        */
        }catch (Exception ex){
            ex.printStackTrace();
        }

        driver.quit();
    }
}
