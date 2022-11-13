package com.project.pom;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Esta clase hace referencia al TestCase CP_login01, utiliza los métodos de la clase LoginPage
 * @author: Wendy Olín
 * @version: 11/11/2022/A
 */

public class Register_Test {
	private WebDriver driver;
	RegisterPage registerPage;
	
	By closeButtonLocator = By.className("dy-lb-close");
	By popupPageLocator	= By.xpath("//img[@src='https://images.falabella.com/v3/assets/blt7c5c2f2f888a7cc3/blt13e895a56f8460c1/62ec3b10d3b8a57004566a52/CMR_-_10K_(MOBILE).png']");
	

	@Before
	public void setUp() throws Exception {
		registerPage = new RegisterPage(driver);
		driver=registerPage.chromeDriverConnection();
		registerPage.visit("https://www.falabella.com/falabella-cl");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		if(registerPage.isDisplayed(popupPageLocator)) {
			registerPage.click(closeButtonLocator);
		}
		else {
			System.out.println("Popup was not found");
		}
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		registerPage.RegisterUser();
		assertTrue(registerPage.isRegisterPageDisplayed());
	}

}
