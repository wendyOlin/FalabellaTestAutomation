package com.project.pom;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

/**
 * Esta clase utiliza los métodos de la clase LoginPage, para ingresar al sistema dejando campos correo y contraseña vacios
 * @author: Wendy Olín
 * @version: 11/11/2022/A
 */

public class CP_Login03_Test {

	private WebDriver driver;
	LoginPage loginPage;
	
	By closeButtonLocator = By.className("dy-lb-close");
	By popupPageLocator	= By.xpath("//img[@src='https://images.falabella.com/v3/assets/blt7c5c2f2f888a7cc3/blt13e895a56f8460c1/62ec3b10d3b8a57004566a52/CMR_-_10K_(MOBILE).png']");
	By msgEmptyEmailLocator = By.className("form-field-module_field-error__33p44");
	By msgEmptyPassLocator = By.id("testId-cc-login-form-password-help");
	By btnSiginDisableLocator = By.id("testId-cc-login-form-submit");
	
	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		loginPage.visit("https://www.falabella.com/falabella-cl");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		if(loginPage.isDisplayed(popupPageLocator)) {
			loginPage.click(closeButtonLocator);
		}
		else {
			System.out.println("Popup was not found");
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test
	public void testLogin03() throws InterruptedException {
		loginPage.loginAs("", "");
		Thread.sleep(2000);
		
		//Assertions Compara texto retornado del inputEmail contra el mensaje esperado
		Assert.assertEquals(loginPage.getText(msgEmptyEmailLocator), "Ingresa un correo electrónico");	
		//Assertions Compara texto retornado del inputPass contra el mensaje esperado
		Assert.assertEquals(loginPage.getText(msgEmptyPassLocator), "Ingresa una contraseña");		
		loginPage.isEnabled(btnSiginDisableLocator);
	}

}
