package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Login']") WebElement login;


    public void enterEmail(String emailId)
    {
        email.sendKeys(emailId);
    }

    public  void enterPassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void clickLogin()
    {
        login.click();
    }



}
