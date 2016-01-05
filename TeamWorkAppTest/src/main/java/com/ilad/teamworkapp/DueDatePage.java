package com.ilad.teamworkapp;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class DueDatePage extends AbstractPageObject{

	Calendar cal = Calendar.getInstance();
	String dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)+"";
	String monthToday1 = cal.get(Calendar.MONTH)+"";
	String monthToday = (new DateFormatSymbols().getMonths()[Integer.parseInt(monthToday1)]).substring(0, 3);
	String yearToday = cal.get(Calendar.YEAR)+"";
	
	
	
	public DueDatePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void clickOnDay(String day) throws InterruptedException {
		if(Integer.parseInt(dayOfMonth)<10){
			dayOfMonth="0"+dayOfMonth;
		}
		System.out.println(dayOfMonth);
		WebElement sendDay = driver.findElement(By.xpath("//android.widget.EditText[@text='"+dayOfMonth+"']"));
		sendDay.clear();
		sendDay.sendKeys(day);
	}

	public void clickOnMonth(String month) throws InterruptedException {
		WebElement sendMonth = driver.findElement(By.xpath("//android.widget.EditText[@text='"+monthToday+"']"));
		sendMonth.clear();
		sendMonth.sendKeys(month);
	}

	public void clickOnYear(String year) throws InterruptedException {
		WebElement sendYear = driver.findElement(By.xpath("//android.widget.EditText[@text='"+yearToday+"']"));
		sendYear.clear();
		sendYear.sendKeys(year);
		
	}

	public void clickOnDoneAndGoBAckToAddMilstonePage() {
		driver.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();
		
	}
	
	enum Month{
		Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec
	};
	
}
