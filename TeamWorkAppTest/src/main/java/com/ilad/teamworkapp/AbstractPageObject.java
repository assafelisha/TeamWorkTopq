package com.ilad.teamworkapp;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AbstractPageObject {
	protected final AndroidDriver<WebElement> driver;
	public AbstractPageObject(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
}
