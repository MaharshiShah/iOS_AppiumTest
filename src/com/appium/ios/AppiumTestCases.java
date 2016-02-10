package com.appium.ios;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppiumTestCases {

	WebDriver driver;

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "8.2");
		caps.setCapability("deviceName", "iPhone Simulator");
		caps.setCapability("app", "/Users/maharshishah/Downloads/UICatalog.app");
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),
				caps);
	}

	@Test
	public void iOSTestCase() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]"))
				.click();
		driver.findElement(By.name("Back")).click();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
