package pageObject;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

// common code we written in this page to achieve the reusability
public class BasePage {
    WebDriver driver;
    //constructor
    BasePage(WebDriver driver)  // creating constructor to initiate the driver.
    {
        this.driver = driver;
        PageFactory.initElements(driver,this); // it will provide driver to all @FindBy to interact with webElements
    }

    //wait for element to be visible or wait for visibilityOfElementLocated()
    public void waitForElementTOVisible(WebElement element, int timeOut)
    {
        WebDriverWait myWait =  new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        myWait.until(ExpectedConditions.visibilityOf(element));  // Note : we can use visibilityOfElementLocated() bec it required By.locator in argument not WebElement
    }

    //Wait for element to be clickable
    public void waitForElementToBeClickable(WebElement element, int timeOut)
    {
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        myWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //We can also add switchToFrame, SwitchToDefaultContent, switchToAlert(), accept and dismiss alert, mouseHover, Context click(), double click();

    public  void switchTOFrame(WebElement frame)
    {
        driver.switchTo().frame(frame);
    }

    //Accept alert
    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    //dismiss alert
    public void dismissAlert()
    {
        driver.switchTo().alert().dismiss();
    }

    //mouse hover
    public void mouseMover(WebElement element)
    {
        Actions mouse = new Actions(driver);
        mouse.moveToElement(element).perform();
    }

    //double click
    public void doubleClick(WebElement element)
    {
        Actions mouse = new Actions(driver);
        mouse.contextClick(element).perform();
    }

    //drag and drop
    public void dragAndDrop(WebElement source, WebElement destination)
    {
        Actions mouse = new Actions(driver);
        mouse.dragAndDrop(source, destination);
    }

    //Select By visible text from drop down
    public void selectFromDropDownByVisibleText(WebElement dropdown, String text)
    {
        Select dropDown = new Select(dropdown);
        dropDown.selectByVisibleText(text);
    }



}
