package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Esta clase LoginPage hereda de la clase base y centraliza los localizadores y acciones de la página login
 * @author: Wendy Olín
 * @version: 11/11/2022/A
 */

public class LoginPage extends Base{
	
	By loginItemMenuLocator = By.xpath("//div[@class='Popover-module_popover-container__3qpkj Popover-module_bottom-caret-notlogin__19OPO']");
	By loginItemSubMenuLocator= By.id("testId-loggedout-item-0");
	By loginFormLocator = By.className("login-form-module_header-content-title__2_nFE");		
	By emailLocator = By.id("testId-cc-login-form-email-input");
	By passwordLocator = By.cssSelector("input[name='password']");
	By siginBtnLocator = By.id("testId-cc-login-form-submit");	
	By loginAlertLocator = By.className("login-form-module_form-alerts__1Bkgp");
	By msgSigninLocator = By.className("UserInfo-module_display1__1TD_E");
	By weMsgSigninLocator = By.tagName("p");
	By msgWrongSigninLocator = By.className("login-form-module_form-alerts__1Bkgp");;
	
	/**
     * Constructor de clase
     * @param driver El parámetro driver define una instancia de WebDriver
     */
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}//Cierre del constructor
	
	/**
     * Método que lleva al formulario Login
     */		
	public void goToLoginForm() {
		click(loginItemMenuLocator);
		click(loginItemSubMenuLocator);
	}//Cierre del método
	
	/**
     * Método que ingresa email en el input email
     * @param String El string define el email a escribir en el input
     */	
	public void enterEmail(String email) {
		clear(findElement(emailLocator));
		type(email, emailLocator);		
	}//Cierre del método
	
	/**
     * Método que ingresa password en el input password
     * @param String El string define el password a escribir en el input
     */	
	public void enterPass(String pass) {
		clear(findElement(passwordLocator));
		type(pass, passwordLocator);		
	}//Cierre del método
	
	/**
     * Método que da click en el botón "Ingresar"
     */
	public void clickSingIn() {
		click(siginBtnLocator);				
	}//Cierre del método
	
	/**
     * Método que realiza el inicio de sesión como un usuario
     * @param (String,String) Los strings definen el email y password que se escribirá en el formulario Inicio de Sesión,
     * si alguno o ambos strings son nulos, no se da click en botón "Ingresar"
     */
	public void loginAs(String email, String pass) throws InterruptedException{
		goToLoginForm();
		Thread.sleep(2000);
		if(isDisplayed(loginFormLocator)) {
			enterEmail(email);
			enterPass (pass);
			if((email.isEmpty()||pass.isEmpty())||(email.isEmpty()&& pass.isEmpty())) {
				click(emailLocator);
				System.out.println("Email o Pass empty");
			}
			else {
				Thread.sleep(4000);
				clickSingIn();	
			}
		}
		else {
			System.out.println("Login form was not found");
		}		
	}//Cierre del método
	
	/**
     * Método que devuelve el mensaje al realizar un inicio de sesión exitoso
     * @return String El string indica el mensaje al iniciar sesión.
     */
    public String loginMessage(){
    	List<WebElement> msg = findElements(weMsgSigninLocator);
		return getText(msgSigninLocator);   	
    }//Cierre del método
    
    /**
     * Método que indica si se encuentra el mensaje de alerta al realizar un inicio de sesión incorrecto
     * @return boolean 
     */
    public boolean isDisplayedLoginWrongMessage(){
    	return isDisplayed(msgWrongSigninLocator);    	  	
    }//Cierre del método
}
