package com.ilad.pageobjecttopq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBot extends AbstractPageObject{
	
	WebDriver driver;
	
	public ActionBot(WebDriver driver) {
		super(driver);
	}

	public void click(By locator){
		driver.findElement(locator).click();
	}
	
	public void sendKey(By locator, String text){
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}
}
