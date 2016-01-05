package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LogInPage extends AbstractPageObject{

	public LogInPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void sendKeyToUserNameTextBox(String userName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Email Address or API Key']")).sendKeys(userName);
		
	}

	public void sendKeyTpPasswordTextBox(String password) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Password']")).sendKeys(password);
		
	}

	public AllActivityPage clickOnLoginButtonAndGoToAllActivityPage() {
		driver.findElement(By.className("android.widget.Button")).click();
		return new AllActivityPage(driver);
	}

}
