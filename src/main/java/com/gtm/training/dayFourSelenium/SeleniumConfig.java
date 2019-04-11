package com.gtm.training.dayFourSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {
	public static void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		RunEnvironment.setWebDriver(driver);
	}

	public static void shutDownDriver() {
		RunEnvironment.getWebDriver().quit();
	}
}
