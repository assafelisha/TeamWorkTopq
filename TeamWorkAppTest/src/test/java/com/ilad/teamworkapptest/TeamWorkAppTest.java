package com.ilad.teamworkapptest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ilad.teamworkapp.AddMilestonePage;
import com.ilad.teamworkapp.AddTaskListPage;
import com.ilad.teamworkapp.AddTaskPage;
import com.ilad.teamworkapp.AllActiveMilestones;
import com.ilad.teamworkapp.AllActivityPage;
import com.ilad.teamworkapp.ChooseProjectModule;
import com.ilad.teamworkapp.DueDatePage;
import com.ilad.teamworkapp.LogInPage;
import com.ilad.teamworkapp.MilestonesPage;
import com.ilad.teamworkapp.NavigationPage;
import com.ilad.teamworkapp.ResponsiblePage;
import com.ilad.teamworkapp.SearchMilestoneToAttach;
import com.ilad.teamworkapp.TaskListPage;
import com.ilad.teamworkapp.TasksPage;
import io.appium.java_client.android.AndroidDriver;


public class TeamWorkAppTest {
	private AndroidDriver<WebElement> driver;
	private String apkName="teamwork.apk";
	private String userName = "fake02@fake.com";
	private String password = "fake";
	private String dayInMonth = "28";
	private String month = "Feb";
	private String year = "2016";
	
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		File app = new File(apkName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "net.teamworkpm.phone");
		capabilities.setCapability("appActivity", ".ProjectsActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testTeamWorkApp() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("The application Team Work is opened",true);
		Reporter.log("When the user is logging in",true);
		
		LogInPage loginPage = new LogInPage(driver);
		loginPage.sendKeyToUserNameTextBox(userName);
		loginPage.sendKeyTpPasswordTextBox(password);
		AllActivityPage allActivityPage = loginPage.clickOnLoginButtonAndGoToAllActivityPage();	
		Reporter.log("The page All Activity is opened",true);
		
		NavigationPage navigationPage =  allActivityPage.clickOnNavigationButtonAndGoToNavigationPage();	
		MilestonesPage milestonesPage = navigationPage.clickOnMilstonesAndNavigateMilstonesPage();
		milestonesPage.clickOnMoreOptionsButtonAndOpenTheOptionsWindow();
		
		AddMilestonePage addMilestonePage= milestonesPage.clickOnAddMilstoneAndGoToAddMilstonePage();
		addMilestonePage.sendKeyToMilestoneTitle("Hey My Milestone title - 1");
		addMilestonePage.sendKeyToMilestoneDescription("Milestone Description");
		addMilestonePage.clickOnSelectedProjectAndGoBackToAddTaskPage();
		ChooseProjectModule chooseprojectModule = addMilestonePage.clickOnProjectSubMenuItemAndNavigateToChooseProjectModule();
		chooseprojectModule.clickOnSelectedProjectAndGoBackToAddMilsetonePage();
		DueDatePage dueDatePage = addMilestonePage.clickOnDueDateAndGoToDueDatePage();
		dueDatePage.clickOnDay(dayInMonth);
		dueDatePage.clickOnMonth(month);
		dueDatePage.clickOnYear(year);
		dueDatePage.clickOnDoneAndGoBAckToAddMilstonePage();
		ResponsiblePage responsiblePage = addMilestonePage.clickOnResponsibleAndGoToResponsiblePage();
		
		responsiblePage.clickOnResponsibleUser("fake02 fake02");
		responsiblePage.clickOnSaveButtonAndGoBackToAddMilestonePage();
		AllActiveMilestones allActiveMilestones = addMilestonePage.clickOnSaveButtonAndGoToAllActiveMilestone();
		Reporter.log("Milestone Added successfuly",true);
		
		allActiveMilestones.clickOnNavigationButtonAndGoToNavigationPage();
		TasksPage tasksPage = allActiveMilestones.clickOnTasksAndNavigateTasksPage();
		AddTaskPage addTaskPage = tasksPage.clickOnCreateFirstTaskAndNavigateToAddTaskPage();
		addTaskPage.sendKeyToTaskTitle("Task TODO");
		addTaskPage.sendKeyToTaskDescription("This is The description of Task TODO");
		chooseprojectModule = addTaskPage.clickOnProjectSubMenuItemAndNavigateToChooseProjectModule();
		chooseprojectModule.clickOnSelectedProjectAndGoBackToAddTaskPage();
		TaskListPage taskListPage = addTaskPage.clickOnSelectTaskListAndGoToTaskListPage();
		AddTaskListPage addTaskListpage = taskListPage.clickOnFirstTaskListAndnavigateToAddTaskListPage();// swipe
		addTaskListpage.sendKeyToTaskListTitle("Hey You My Task List Yo Yo");
		addTaskListpage.sendkeyToTaskListdescription("This Is Task List");
		SearchMilestoneToAttach searchMilestoneToAttach = addTaskListpage.clickOnMilestoneAndGoTochooseMilestoneToAttach();
		searchMilestoneToAttach.sendKeyToSearchTextBox("Hey My Milestone title - 1");
		searchMilestoneToAttach.clickOnMilestoneNameToAttach("Hey My Milestone title - 1");
		addTaskListpage.clickOnSaveButtonAndGoBackToTaskListPage();
		taskListPage.chooseTheTaskListToAddTheTask("Hey You My Task List Yo Yo");
		addTaskPage.clickOnSaveButtonAndGoBackToTasksPage();
		Reporter.log("Task And Task List Added Successfuly And Attached to the Milestone",true);

		tasksPage.clickOnNavigationButtonAndGoToNavigationPage();
		tasksPage.clickOnMilstonesAndNavigateMilstonesPage();
		milestonesPage.clickOnSearchButton();
		milestonesPage.clickOnSearchTextBox();
		milestonesPage.sendKeyMilestoneNameToTextBox("Hey My Milestone title - 1");
		milestonesPage.clickOnMilstoneNameAndGoToMilestoneDetails("Hey My Milestone title - 1");
		
		
		Assert.assertTrue(milestonesPage.checkListIsAttachedToMilestone("Hey You My Task List Yo Yo"));
	}
	@AfterMethod
	public void tearDown() throws Exception {
		 driver.quit();
	}
}
