package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskListPage extends AbstractPageObject{

	public AddTaskListPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void sendKeyToTaskListTitle(String taskListTitle) {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Title']")).sendKeys(taskListTitle);
	}

	public void sendkeyToTaskListdescription(String taskListDescription) {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Description']")).sendKeys(taskListDescription);
		
	}

	public void clickOnSaveButtonAndGoBackToTaskListPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
		
	}

	public SearchMilestoneToAttach clickOnMilestoneAndGoTochooseMilestoneToAttach() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='No Milestone']")).click();
		return new SearchMilestoneToAttach(driver);
	}

}
