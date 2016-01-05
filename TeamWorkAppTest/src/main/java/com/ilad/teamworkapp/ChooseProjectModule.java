package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ChooseProjectModule extends AbstractPageObject{

	public ChooseProjectModule(AndroidDriver<WebElement> driver) {
		super(driver);
		
	}

	public void clickOnSelectedProjectAndGoBackToAddTaskPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='WebDriver Training']")).click();
	}

	public void clickOnSelectedProjectAndGoBackToAddMilsetonePage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='WebDriver Training']")).click();
	}

}
