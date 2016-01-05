package com.ilad.teamworkapp;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TaskListPage extends AbstractPageObject{
	Dimension size = driver.manage().window().getSize();
	int startx = size.width / 2;
	int endy = (int) (size.height * 0.01);;
	int starty = (int) (size.height * 0.99);
	public TaskListPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public AddTaskListPage clickOnFirstTaskListAndnavigateToAddTaskListPage() throws InterruptedException {
		
		
		List<WebElement> listNames = driver.findElements(By.className("android.widget.TextView"));
		for(WebElement element : listNames){
			if(!element.getText().equals("Add Task List")){
				try {
					driver.findElement(By.xpath("//android.widget.TextView[@text='Add Task List']")).click();
					break;
				} catch (Exception e) {
					driver.swipe(startx, starty, startx, endy, 1500);
					Thread.sleep(1500);
				}
			}
		}
		return new AddTaskListPage(driver);
	}

	public void chooseTheTaskListToAddTheTask(String taskListname) throws InterruptedException {
		List<WebElement> listNames = driver.findElements(By.className("android.widget.TextView"));
		for(WebElement element : listNames){
			if(!element.getText().equals("Add Task List")){
				try {
					driver.findElement(By.xpath("//android.widget.TextView[@text='"+taskListname+"']")).click();
					break;
				} catch (Exception e) {
					driver.swipe(startx, starty, startx, endy, 1500);
					Thread.sleep(1500);
				}
			}
		}
	}
	

}
