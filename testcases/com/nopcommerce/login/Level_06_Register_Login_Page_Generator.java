package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_06_Register_Login_Page_Generator extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	
		emailAddress = getRandomEmail();
		password = "123456";
		
		//Mở URL chuyển qua trang home page
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void Login_01_Register_To_System() {
		// Verify Home Page Slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		// Click to Register Link => Register Page
		registerPage = homePage.clickToRegisterLink();
		
		// Click to gerder male radio
		registerPage.clickToGenderMaleRadioButton(); 
		
		// Input to Fristname textbox
		registerPage.inputToFirstNameTextbox("Phong");
		
		// Input to Lastname textbox
		registerPage.inputToLastNameTextbox("Nguyen");
		
		// Input to Email textbox
		registerPage.inputToEmailTextbox(emailAddress);
		
		// Input to Password textbox
		registerPage.inputToPasswordTextbox(password);
		
		// Input to Confirm password textbox
		registerPage.inputToConfirmPasswordTextbox(password);
		
		// Click to register button
		registerPage.clickToRegisterButton();
		
		// Verify success massage hiển thị
		Assert.assertTrue(registerPage.isSuccessMassageDisplayed());
		
		// Click to logout link => Home page
		homePage = registerPage.clickToLogoutLink();
		
		// Verify Home Page Silder displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		// Click to Login link
		loginPage = homePage.clickToLoginLink();
		
		// Input to Email Textbox
		loginPage.inputToEmailTextbox(emailAddress);
		
		// Input to Password Textbox
		loginPage.inputToPasswordTextbox(password);
		
		// Click to Login Button => Home page
		homePage = loginPage.clickToLoginButton();
		
		// Verify Home Page Logo display
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
		
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		rand.nextInt(99999);
		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
