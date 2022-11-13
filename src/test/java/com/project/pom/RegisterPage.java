package com.project.pom;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pom.Base;

public class RegisterPage extends Base{
	
	By loginItemMenuLocator = By.xpath("//div[@class='Popover-module_popover-container__3qpkj Popover-module_bottom-caret-notlogin__19OPO']");
	By registerItemSubMenuLocator=By.id("testId-loggedout-item-1");
	
	By registerFontLocator=By.xpath("//*[text()='Regístrate']");
	
	By nameLocator = By.id("testId-Input-firstName");
	By lastnameLocator = By.id("testId-Input-lastName");
	By rutLocator = By.id("testId-Input-document");
	By phonenumberLocator = By.id("testId-Input-phoneNumber");
	By emailRegisterLocator = By.id("testId-Input-email");
	By passwordRegisterLocator = By.id("testId-Input-password");

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void RegisterUser() {
		click(loginItemMenuLocator);
		click(registerItemSubMenuLocator);
		List<WebElement> font = findElements(registerFontLocator);
		if(getText(font.get(1)).equalsIgnoreCase("Regístrate")) {
			type("Elizabeth", nameLocator);
			type("Sedano", lastnameLocator);
			//type("10214564", rutLocator);
			//type("98898844", phonenumberLocator);
			//type("wendolin942@gmail.com", emailRegisterLocator);
			//type("123456Falabela", passwordRegisterLocator);			
		}
		else {
			System.out.println("Register form was not present");
		}
		
	}

	public boolean isRegisterPageDisplayed() {
		return true;
	}
	
}
