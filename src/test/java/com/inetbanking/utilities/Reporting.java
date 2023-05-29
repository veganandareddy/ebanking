package com.inetbanking.utilities;
//Listener class used to generate extent report//
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public void onStart(ITestContext testcontext) {
	       String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());//time stamp
	       String reportName = "Test-Report-" + timeStamp + ".html";
	       String reportLocation = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + reportName;
		htmlReporter=new ExtentHtmlReporter(reportLocation);
	    // htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		String configfilePath="C:\\All Selenium projects\\inetBakingv1\\test-output\\extent-config.xml";
		htmlReporter.loadXMLConfig(configfilePath);//
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "vega");
		htmlReporter.config().setDocumentTitle("InetBanking Test project");
		htmlReporter.config().setReportName("Functional Test report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String screenshotp="C:\\All Selenium projects\\inetBakingv1\\Screensots";
		String screenshotpath=System.getProperty("screenshotp")+tr.getName()+".png";
		File f =new File(screenshotpath);
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
