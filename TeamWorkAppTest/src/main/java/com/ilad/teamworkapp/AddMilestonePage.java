package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AddMilestonePage extends AbstractPageObject{

	public AddMilestonePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void sendKeyToMilestoneTitle(String title) {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Title accepts #tag or #[big tag]']")).sendKeys(title);
		
	}

	public void sendKeyToMilestoneDescription(String description) {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Description']")).sendKeys(description);
		
	}

	public void clickOnSelectedProjectAndGoBackToAddTaskPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='No Project Selected']")).click();
	}

	public DueDatePage clickOnDueDateAndGoToDueDatePage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Due Date:']")).click();
		return new DueDatePage(driver);
	}

	public ResponsiblePage clickOnResponsibleAndGoToResponsiblePage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Responsible:']")).click();
		return new ResponsiblePage(driver);
	}

	public AllActiveMilestones clickOnSaveButtonAndGoToAllActiveMilestone() {
		driver.findElementByAccessibilityId("Save").click();
		return new AllActiveMilestones(driver);
	}
	public ChooseProjectModule clickOnProjectSubMenuItemAndNavigateToChooseProjectModule() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='No Project Selected']")).click();
		return new ChooseProjectModule(driver);
	}
}
