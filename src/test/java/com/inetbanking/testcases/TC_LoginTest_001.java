package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends Baseclass {
	@Test
	public void logintest() {
		
		driver.get(baseurl);
		logger.info("url is opened");
		LoginPage lp =new LoginPage(driver);
		lp.setusername(username);
		logger.info("entered username");
		lp.setpassword(password);
		logger.info("enetred password");
		lp.clickandsubit();
		logger.info("clicked and logined");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test passed");
			
		}
		else {
			Assert.assertFalse(false);
			logger.info("test filed");
		}
		
	}

}
