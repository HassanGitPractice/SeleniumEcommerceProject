package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC_Home extends  BaseClass{

    @Test(groups = "Regression")
    void verifyLogoOnHomePage()
    {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        home.clickOnLogin();
        login.enterEmail(p.getProperty("email"));
        login.enterPassword(p.getProperty("password"));
        login.clickLogin();
        //HomePage home = new HomePage(driver);
        logger.info("Home page launch successfully");

        boolean logo = home.logoAvailableOnHomePage();
        //Assert.assertEquals(logo, true, "Login Fails"); OR //validation on test case page, if logo = false then "Login Fails" message will display.
        Assert.assertTrue(logo);
        logger.info("Logo is displayed on Home Page");
        home.clickOnLogout();
        logger.info("Clicked on logOut button on Home Page");
    }


}
