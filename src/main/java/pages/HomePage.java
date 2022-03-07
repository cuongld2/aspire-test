package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	By inventoryButton = By.cssSelector("#result_app_1");

	By manufacturingButton= By.cssSelector("#result_app_2");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}


	public void clickInventoryButton() {
		wait.until(ExpectedConditions.elementToBeClickable(inventoryButton));
		driver.findElement(inventoryButton).click();
	}
	
}
