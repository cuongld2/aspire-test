package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class ManufacturingPage {

    WebDriver driver;
    WebDriverWait wait;


    By createButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > button.btn.btn-primary.o_list_button_add");

    By manufacturingOrderText = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_top > div.o_cp_top_left > ol > li > span");
    By productNameInput = By.cssSelector("li[class=\"ui-menu-item\"] > a");
    By searchByProductName = By.cssSelector("ul[id=\"ui-id-1\"]>li>a[class=\"dropdown-item ui-menu-item-wrapper\"]");
    By confirmButton = By.cssSelector("body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.o_form_statusbar > div.o_statusbar_buttons > button:nth-child(5)");
    By markAsDoneButton = By.cssSelector("body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.o_form_statusbar > div.o_statusbar_buttons > button:nth-child(4)");
    By okButton = By.cssSelector("footer[class=\"modal-footer\"] > button");
    By applyButton = By.cssSelector("footer[class=\"modal-footer\"] > div > footer > button");
    By saveButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > div.o_form_buttons_edit > button.btn.btn-primary.o_form_button_save");
    By createButtonIn = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div.o_cp_buttons > div > div.o_form_buttons_view > button.btn.btn-secondary.o_form_button_create");
    By discardButtonIn = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > div.o_form_buttons_edit > button.btn.btn-secondary.o_form_button_cancel");
    By searchField = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_top > div.o_cp_top_right > div > div > div > input");
    By removeSearchField = By.cssSelector("i[aria-label=\"Remove\"]");
    By selectProductButton = By.cssSelector("ul[class=\"dropdown-menu o_searchview_autocomplete show\"] > li:nth-child(2)");
    By productNameCheck = By.cssSelector("body > div.o_action_manager > div > div.o_content > div > div.table-responsive > table > tbody > tr:nth-child(1) > td:nth-child(5)");
    By homeMenu = By.cssSelector("body > header > nav > a");
    By manufacturingButton = By.cssSelector("#result_app_2");
    By nextButton = By.cssSelector("body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.clearfix.position-relative.o_form_sheet > div.oe_title > h1 > span");
    public ManufacturingPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 50);
    }

    public void createNewOrder(String randomProductName) throws InterruptedException {

//        wait.until(ExpectedConditions.elementToBeClickable(createButton));
//
//        new Actions(driver).moveToElement(driver.findElement(createButton)).click().perform();

        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > button.btn.btn-primary.o_list_button_add\").click();");// else throw...

        Thread.sleep(5000);
//        wait.until(ExpectedConditions.elementToBeClickable(createButton));
//        driver.findElement(createButton).click();
//        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        js.executeScript("document.querySelector(\"body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.clearfix.position-relative.o_form_sheet > div.o_group > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2) > div > div.o_field_many2one_selection > div > input\").click();");// else throw...
        Thread.sleep(5000);
        js.executeScript("document.querySelector(\"body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.clearfix.position-relative.o_form_sheet > div.o_group > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2) > div > div.o_field_many2one_selection > div > input\").value = arguments[0];",randomProductName);// else throw...
        Thread.sleep(5000);
        js.executeScript("var keyboardEvent = new KeyboardEvent('keydown');\n" +
                "   delete keyboardEvent.which;\n" +
                "   keyboardEvent.which = 13;\n" +
                "document.querySelector(\"body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.clearfix.position-relative.o_form_sheet > div.o_group > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2) > div > div.o_field_many2one_selection > div > input\").dispatchEvent(keyboardEvent);");// else throw...
        Thread.sleep(5000);
        driver.findElement(productNameInput).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        driver.findElement(confirmButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(markAsDoneButton));
        driver.findElement(markAsDoneButton).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        driver.findElement(okButton).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver.findElement(applyButton).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(createButtonIn));
        driver.findElement(createButtonIn).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(discardButtonIn));
        driver.findElement(discardButtonIn).click();

    };

    public String verifyOrderDetail(String randomProductName) throws InterruptedException {

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(removeSearchField));
        driver.findElement(removeSearchField).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(randomProductName);

        wait.until(ExpectedConditions.elementToBeClickable(selectProductButton));
        driver.findElement(selectProductButton).click();


        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(productNameCheck));
        return driver.findElement(productNameCheck).getText();
    }


}
