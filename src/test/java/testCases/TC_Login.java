package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.time.Duration;

public class TC_Login extends BaseClass {

    @Test(groups = "Sanity")
    void loginToApplication()
    {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        home.clickOnLogin();
        logger.info("Clicked on Login button on Home Page");
        login.enterEmail(p.getProperty("email"));
        //login.enterEmail("testapp123@testing.com");
        logger.info("Entered EmailId Successfully");
        login.enterPassword(p.getProperty("password"));
        //login.enterPassword("Hassan@123");
        logger.info("Entered EmailId Successfully");
        login.clickLogin();
        logger.info("Clicked on Submit button");
        String loginVerify = home.verifyLogin();
        Assert.assertEquals(loginVerify,"Logged in as Hassan");  //validation should be done on the test page
        logger.info("Verified that user name is visible on Home page after login");
    }
}
