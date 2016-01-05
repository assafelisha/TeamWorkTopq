package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskPage extends AbstractPageObject{

	public AddTaskPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void sendKeyToTaskTitle(String taskTitle) {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Title accepts #tag or #[big tag]']")).sendKeys(taskTitle);
		
	}

	public void sendKeyToTaskDescription(String taskDescription) {
		driver.findElement(By.xpath("//android.widget.EditText[@text='Description']")).sendKeys(taskDescription);;
		
	}

	public ChooseProjectModule clickOnProjectSubMenuItemAndNavigateToChooseProjectModule() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='No Project Selected']")).click();
		return new ChooseProjectModule(driver);
	}

	public TaskListPage clickOnSelectTaskListAndGoToTaskListPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='No Task List Selected']")).click();;
		return new TaskListPage(driver);
	}

	public void clickOnSaveButtonAndGoBackToTasksPage() {
		driver.findElementByAccessibilityId("Save").click();
		
	}

}
