package com.inetbanking.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends Baseclass {
	@Test
	public void logintest() throws IOException {
		
		
		logger.info("url is opened");
		LoginPage lp =new LoginPage(driver);
		lp.setusername(username);
		logger.info("entered username");
		lp.setpassword(password);
		logger.info("enetred password");
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(lp.btnlogin)).click();
		logger.info("clicked and logined");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test passed");
			
		}
		else {
			captureScreen(driver,"logintest");
			Assert.assertFalse(false);
			logger.info("test filed");
		}
		
	}

}
