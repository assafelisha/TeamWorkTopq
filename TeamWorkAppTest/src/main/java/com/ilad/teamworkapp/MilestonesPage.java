package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class MilestonesPage extends AbstractPageObject{

	public MilestonesPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnMoreOptionsButtonAndOpenTheOptionsWindow() {
		driver.findElementByAccessibilityId("More options").click();
	}

	public AddMilestonePage clickOnAddMilstoneAndGoToAddMilstonePage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add']")).click();
		return new AddMilestonePage(driver);
	}

	public void clickOnSearchButton() {
		driver.findElementByAccessibilityId("Search").click();
		
	}

	public void clickOnSearchTextBox() {
		driver.findElement(By.className("android.widget.EditText")).click();;
		
	}

	public void sendKeyMilestoneNameToTextBox(String milstoneName) {
		driver.findElement(By.className("android.widget.EditText")).sendKeys(milstoneName);
		
	}

	public void clickOnMilstoneNameAndGoToMilestoneDetails(String milstoneName) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+milstoneName+"']")).click();
		
	}

	public boolean checkListIsAttachedToMilestone(String listName) {
		WebElement myListName = driver.findElement(By.xpath("//android.widget.TextView[@text='"+listName+"']"));
		return myListName.getText().equals(listName);
	}

}
