package com.gtm.training.day4Selenium;

import org.openqa.selenium.WebDriver;

public class RunEnvironment {
	private static WebDriver driver;
	
	public static WebDriver getWebDriver() {
		return driver;
	}
	
	static void setWebDriver(WebDriver driver) {
		RunEnvironment.driver = driver;
	}
}
