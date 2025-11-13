package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }

    BasePage comm = new BasePage(driver);

    @FindBy(xpath = "//a[text()=' Products']")
    WebElement productsPage;

    @FindBy(id ="search_product")
    WebElement serchProductFeild;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath= "//div[@class='single-products']")
    List<WebElement> searchProducts;

    public void clickOnProductsPage()
    {
        productsPage.click();
    }

    public void enterProductNameInSearchBox(String product)
    {
        comm.waitForElementTOVisible(serchProductFeild,3000);
        serchProductFeild.sendKeys(product);
    }

    public void clickOnProductSearchButton()
    {
        searchButton.click();
    }

    public void verifySearchProducts()
    {
        for(WebElement product : searchProducts)
        {
            String prod = product.getText().toLowerCase();
            if(prod.contains("shirt"))
            {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }
    }
}
