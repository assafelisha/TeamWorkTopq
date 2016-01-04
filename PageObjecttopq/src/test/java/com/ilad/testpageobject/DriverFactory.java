package com.ilad.testpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver driver = null;

	public static WebDriver getBrowser(Browser chooseBrowser) {
		
		switch (chooseBrowser) {
		case firefox:
			driver = new FirefoxDriver();
			break;
		case chrome:
			System.setProperty("webdriver.chrome.driver", "/home/developer/drivers/chromedriver");
			driver = new ChromeDriver();
			break;	
		}
		return driver;
	}

	public enum Browser {
		firefox, chrome;
	}
}
