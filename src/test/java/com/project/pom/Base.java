package com.project.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Esta clase base nos permite aislar las clases page de los comandos de selenium
 * @author: Wendy Olín
 * @version: 11/11/2022/A
 */

public class Base {

	private WebDriver driver;
	
	/**
     * Constructor de clase base
     * @param driver El parámetro driver define una instancia de WebDriver
     */
	public Base(WebDriver driver) {
		this.driver = driver;
	}//Cierre de constructor
	
	/**
     * Método que realiza la conexión con Navegador Chrome
     * @return Una instancia del navegador Chrome
     */
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	
	/**
     * Método wrapping de findElement de WebDriver
     * @param By
     * @return WebElement
     */
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;			
		}
	}
	
	public boolean isEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}
	
	public void clear(WebElement element) {
		element.clear();		
	}
	
	public void visit(String url) {
		driver.get(url);		
	}//Cierre de método	
	
}//Cierre de la clase Base
