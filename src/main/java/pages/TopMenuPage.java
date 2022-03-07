package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {

    WebDriver driver;
    WebDriverWait wait;

    By productsButton = By.cssSelector("body > header > nav > div.o_menu_sections > div:nth-child(3) > button");
    By productDropDown = By.cssSelector("body > header > nav > div.o_menu_sections > div.o-dropdown.dropdown.o-dropdown--no-caret.show > div > a:nth-child(1)");

    By manufacturingButton = By.cssSelector("#result_app_2 > div.o_app_icon");
    public TopMenuPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void navigateProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsButton));
        driver.findElement(productsButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(productDropDown));
        driver.findElement(productDropDown).click();
    }

    public void navigateManufacturingPage(){

        wait.until(ExpectedConditions.elementToBeClickable(manufacturingButton));
        driver.findElement(manufacturingButton).click();

    }
}
