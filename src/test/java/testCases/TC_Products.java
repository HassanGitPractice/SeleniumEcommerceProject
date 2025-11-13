package testCases;

import org.testng.annotations.Test;
import pageObject.ProductsPage;


public class TC_Products extends BaseClass {

    @Test
    public void verifySearchProductFunctionality()
    {
        ProductsPage product = new ProductsPage(driver);
        product.clickOnProductsPage();
        logger.info("Clicked on Products link");
        product.enterProductNameInSearchBox(p.getProperty("product"));
        logger.info("Entered product name in product search box");
        product.clickOnProductSearchButton();
        logger.info("Clicked on product search button");
        product.verifySearchProducts();
        logger.info("All searched result verified");
        System.out.println("Merge conflict demo-1");
    }
}
