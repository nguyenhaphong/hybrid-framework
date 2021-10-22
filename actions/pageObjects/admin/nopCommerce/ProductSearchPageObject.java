package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ProductSearchPageObject extends BasePage{
	WebDriver driver;
	
	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSearchButton() {
		// TODO Auto-generated method stub
		
	}

	public ProductDetailPageObject clickToEditButtonByProductName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSuccessMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
