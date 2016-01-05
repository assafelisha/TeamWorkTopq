package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SearchMilestoneToAttach extends AbstractPageObject{

	public SearchMilestoneToAttach(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void sendKeyToSearchTextBox(String milestoneSearch) {
		driver.findElementByAccessibilityId("Search").click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(milestoneSearch);
	}

	public void clickOnMilestoneNameToAttach(String milestoneSearch) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+milestoneSearch+"']")).click();
		
	}

}
