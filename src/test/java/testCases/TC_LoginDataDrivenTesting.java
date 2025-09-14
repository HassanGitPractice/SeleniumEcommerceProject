package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.DataProviders;

public class TC_LoginDataDrivenTesting extends BaseClass {


        @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)
        public void verify_loginDDT(String email, String password)
        {
            HomePage home = new HomePage(driver);
            LoginPage login = new LoginPage(driver);
            home.clickOnLogin();
            logger.info("Clicked on Login button on Home Page successfully");
            login.enterEmail(email);
            //login.enterEmail("testapp123@testing.com");
            logger.info("Entered EmailId");
            login.enterPassword(password);
            //login.enterPassword("Hassan@123");
            logger.info("Entered password");
            login.clickLogin();
            logger.info("Clicked on Submit button successfully");
            String loginVerify = home.verifyLogin();
            Assert.assertEquals(loginVerify,"Logged in as Hassan");  //validation should be done on the test page
            logger.info("Verified that user name is visible on Home page after login");
            home.clickOnLogout();
        }
}
