package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class Baseclass {
	Readconfig readconfig =new Readconfig();
	public String baseurl=readconfig.getAplicationURL();
	public String username =readconfig.getUsername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("defaultBrowser")String br)
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	driver =new ChromeDriver();
	logger  =Logger.getLogger("ebanking");
	PropertyConfigurator.configure("C:\\All Selenium projects\\inetBakingv1\\src\\main\\log4j.properties");
	if(br.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	driver =new ChromeDriver();
	}
	else if (br.equals("ie")) {
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
		driver =new FirefoxDriver();
		
	}
	driver.get(baseurl);
	}
	@AfterClass
	public void teardown()
	{
	driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/screensots/"+ tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
		
	}
}
