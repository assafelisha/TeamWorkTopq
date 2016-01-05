package com.ilad.teamworkapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractTeamWorkApp extends AbstractPageObject{

	public AbstractTeamWorkApp(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	public TasksPage clickOnTasksAndNavigateTasksPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Tasks']")).click();
		return new TasksPage(driver);
	}
	
	public MilestonesPage clickOnMilstonesAndNavigateMilstonesPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Milestones']")).click();
		return new MilestonesPage(driver);
	}
	public NavigationPage clickOnNavigationButtonAndGoToNavigationPage() {
		driver.findElement(By.className("android.widget.ImageButton")).click();;
		return new NavigationPage(driver);
	}
}
