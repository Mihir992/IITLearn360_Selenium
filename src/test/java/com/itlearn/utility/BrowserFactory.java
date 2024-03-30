package com.itlearn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver startApplication(WebDriver driver,String appUrl)
	{
		String defaultBrowser = "Chrome";
		if(defaultBrowser.equalsIgnoreCase("Chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifcations");
			op.addArguments("--disable-gpu");
			op.addArguments("--disable-extensions");
			op.addArguments("--no-sandbox");
			op.addArguments("--disable-dev-shm-usage");
			op.addArguments("--remote-allow-origins=*");
	        driver = new ChromeDriver(op);
		}
		else if(defaultBrowser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver");
	         driver = new FirefoxDriver();
		}
		else if(defaultBrowser.equalsIgnoreCase("IE"))
		{
			 WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.ie.driver");
	        driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser ");
		}

		
		if (driver != null) {
            driver.manage().window().maximize();
            driver.get(appUrl);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            System.out.println("Driver initialization failed.");
        }
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
