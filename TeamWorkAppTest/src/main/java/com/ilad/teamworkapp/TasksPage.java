package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TasksPage extends AbstractTeamWorkApp{

	public TasksPage(AndroidDriver<WebElement> driver) {
		super(driver);
		
	}

	public AddTaskPage clickOnCreateFirstTaskAndNavigateToAddTaskPage() {
		driver.findElement(By.xpath("//android.widget.Button[@text='Create the first task']")).click();
		return new AddTaskPage(driver);
	}

}
