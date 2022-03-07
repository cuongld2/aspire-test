package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;


    public ProductPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 30);
    }

    By createNewProductButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > button");

    By searchButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_top > div > div > button");
    By createButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > div.o_form_buttons_view > button.btn.btn-secondary.o_form_button_create");
    By discardButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > div.o_form_buttons_edit > button.btn.btn-secondary.o_form_button_cancel");
    By inputProductName = By.cssSelector("#o_field_input_11");
    By saveButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > div.o_form_buttons_edit > button.btn.btn-primary.o_form_button_save");
    By searchInput = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_top > div > div > div > input");

    By actionButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > div.o_form_buttons_edit > button.btn.btn-primary.o_form_button_save");
    By productSearch = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_top > div > div > div > ul >li");
    By updateQuantityButton = By.cssSelector("body > div.o_action_manager > div > div.o_content > div > div.o_form_sheet_bg > div.o_form_statusbar > div > button:nth-child(2)");

    By createQuantityButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > button.btn.btn-primary.o_list_button_add");

    By countedQuantity = By.cssSelector("body > div.o_action_manager > div > div.o_content > div > div.table-responsive > table > tbody > tr.o_data_row.o_selected_row > td.o_data_cell.o_field_cell.o_list_number.o_counted_quantity_widget_cell > input");
    By saveQuantityButton = By.cssSelector("body > div.o_action_manager > div > div.o_control_panel > div.o_cp_bottom > div.o_cp_bottom_left > div > div > button.btn.btn-primary.o_list_button_save");
    By homeMenu = By.cssSelector("body > header > nav > a");
    public void createNewProduct(String randomProductName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createNewProductButton));
        driver.findElement(createNewProductButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputProductName));
        driver.findElement(inputProductName).clear();
        driver.findElement(inputProductName).sendKeys(randomProductName);

        wait.until(ExpectedConditions.elementToBeClickable(actionButton));
        driver.findElement(actionButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(updateQuantityButton));
        driver.findElement(updateQuantityButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(createQuantityButton));
        driver.findElement(createQuantityButton).click();


        wait.until(ExpectedConditions.elementToBeClickable(countedQuantity));
        driver.findElement(countedQuantity).clear();
        driver.findElement(countedQuantity).sendKeys("10.00");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(saveQuantityButton));
        driver.findElement(saveQuantityButton).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(homeMenu));
        driver.findElement(homeMenu).click();
        Thread.sleep(2000);

    }


}
