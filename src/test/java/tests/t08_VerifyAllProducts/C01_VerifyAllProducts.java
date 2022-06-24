package tests.t08_VerifyAllProducts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AEPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_VerifyAllProducts {
AEPage aePage = new AEPage();

    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationUrl"));

//        3. Verify that home page is visible successfully
        String URL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(URL,ConfigReader.getProperty("automationUrl"));

//        4. Click on 'Products' button
        aePage.ProductsButton.click();

//        5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(aePage.AllProductsText.isDisplayed());
//        6. The products list is visible

//        7. Click on 'View Product' of first product
        aePage.FirstViewProduct.click();
//        8. User is landed to product detail page
//        9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        String pname= "Blue Top";
        Assert.assertEquals(aePage.pname1.getText(),pname);
        String category="Category: Women > Tops";
        Assert.assertEquals(aePage.category1.getText(),category);
        String price= "Rs. 500";
        Assert.assertEquals(aePage.price1.getText(),price);
        String availability = " In Stock";
        String[] arrOfStr = aePage.availability1.getText().split(":");
        Assert.assertEquals(arrOfStr[1],availability);
        String condition = " New";
        String[] arrOfcond =aePage.condition1.getText().split(":");
        Assert.assertEquals(arrOfcond[1],condition);
        String brand = " Polo";
        String[] arrOfbrand =aePage.brand1.getText().split(":");
        Assert.assertEquals(arrOfbrand[1],brand);
Driver.closeDriver();
    }
}
