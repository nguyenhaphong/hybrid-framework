package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.OrderPageUI;

public class OrderPageObject extends BasePage {
	WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
