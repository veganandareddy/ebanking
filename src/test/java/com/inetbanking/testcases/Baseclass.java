package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	public String baseurl="https://demo.guru99.com/v4/";
	public String username ="mngr504846";
	public String password="mYtYgyp";
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\All Selenium projects\\inetBakingv1\\Drivers\\chromedriver.exe");
	driver =new ChromeDriver();
	logger  =Logger.getLogger("ebanking");
	PropertyConfigurator.configure("log4j.properties");
	}
	@AfterClass
	public void teardown()
	{
	driver.quit();
	}
}
