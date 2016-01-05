package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ResponsiblePage extends AbstractPageObject{

	public ResponsiblePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnResponsibleUser(String rsponsibleUser) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+rsponsibleUser+"']")).click();
	}

	public void clickOnSaveButtonAndGoBackToAddMilestonePage() {
		driver.findElementByAccessibilityId("Done").click();
		
	}

}
