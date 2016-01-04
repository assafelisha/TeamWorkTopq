package com.ilad.pageobjecttopq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO: This one should not extend the AbstractTeamWorkPage. 
public class AddNewTaskListModule extends AbstractPageObject{

	
	@FindBy(id = "newTaskListName")
	WebElement newTaslListName;
	@FindBy(id = "btnCreateTaskList")
	WebElement btnCreateTasklist;
	
	
	public AddNewTaskListModule(WebDriver driver) {
		super(driver);
		
	}

	public void sendKeyToTaskListName(String taskListName) {
		newTaslListName.sendKeys(taskListName);
		
	}

	public TasksPage clickOnAddThisTaskListBtnAndGoToTasksPage() throws InterruptedException {
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(btnCreateTasklist));
		btnCreateTasklist.click();
		return new TasksPage(driver);
	}

	

}
