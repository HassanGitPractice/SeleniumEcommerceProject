package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }  //constructor

    BasePage common = new BasePage(driver);// creating object of Base class to access its methods.
    @FindBy(linkText = "Signup / Login")
    WebElement logIn;

    @FindBy(linkText = " Products") WebElement products;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loginVerify;

    @FindBy(xpath = "//div[@class='logo pull-left']//img") WebElement logoHomePage;

    @FindBy(xpath = "//a[text()=' Logout']") WebElement logOut;

    public void clickOnLogin()
    {
        logIn.click();
    }

    public void clickOnProduct()
    {
        products.click();
    }

    public String verifyLogin()   // validation shold done on test class so returning text
    {
       String text =  loginVerify.getText();
       return  text;
    }

    public boolean logoAvailableOnHomePage()
    {
            common.waitForElementTOVisible(logoHomePage, 10);
            return (logoHomePage.isDisplayed());
    }

    public void clickOnLogout()
    {
        if(logOut.isDisplayed())
        {
            logOut.click();
        }
//        common.waitForElementTOVisible(logOut,10);
//        logOut.click();

    }

}
