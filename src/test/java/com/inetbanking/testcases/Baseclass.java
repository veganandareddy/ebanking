package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.Readconfig;

public class Baseclass {
	Readconfig readconfig =new Readconfig();
	public String baseurl=readconfig.getAplicationURL();
	public String username =readconfig.getUsername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	driver =new ChromeDriver();
	logger  =Logger.getLogger("ebanking");
	PropertyConfigurator.configure("C:\\All Selenium projects\\inetBakingv1\\src\\main\\log4j.properties");
	}
	@AfterClass
	public void teardown()
	{
	driver.quit();
	}
}
