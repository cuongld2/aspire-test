package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class ManuFactoringOrderTest extends BasePage {

    private String generateProductName(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    @Test
    public void createNewOrder() throws InterruptedException {
        String randomProductName = generateProductName();
        LoginPage login = new LoginPage(driver);
        login.typeUsername("user@aspireapp.com");
        login.typePassword("@sp1r3app");
        login.clickSignIn();
        Assert.assertTrue(login.verifyNewPage());

        HomePage homePage = new HomePage(driver);
        homePage.clickInventoryButton();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.navigateProductPage();

        ProductPage productPage = new ProductPage(driver);
        productPage.createNewProduct(randomProductName);

        topMenuPage.navigateManufacturingPage();

        ManufacturingPage manufacturingPage = new ManufacturingPage(driver);
        driver.get("https://aspireapp.odoo.com/web#menu_id=150");
        manufacturingPage.createNewOrder(randomProductName);
        Assert.assertEquals(manufacturingPage.verifyOrderDetail(randomProductName), randomProductName, "Verify productName matched");
    }
}
