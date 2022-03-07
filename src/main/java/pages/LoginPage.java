package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	By usernameField = By.cssSelector("#login");
	By passwordField = By.cssSelector("#password");
	By signInButton = By.cssSelector("#wrapwrap > main > div > div > div > form > div.clearfix.oe_login_buttons.text-center.mb-1.pt-3 > button");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 10);
	}
	
	public void typeUsername(String username) { //pass a parameter so we don't hardcode values in the object class.
		wait.until(ExpectedConditions.elementToBeClickable(usernameField));
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void typePassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		driver.findElement(signInButton).click();
	}

	public boolean verifyNewPage() {
		wait.until(ExpectedConditions.urlContains("aspireapp.odoo.com"));
		return driver.getTitle().contains("Odoo");
	}

}
