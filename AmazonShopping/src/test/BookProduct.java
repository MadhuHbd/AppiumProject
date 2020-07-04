package test;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;

import objectrepo.ObjectRepo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Common;
import core.AmazonDataprovider;
import core.Launchdriver;

public class BookProduct extends Launchdriver{
	
	ObjectRepo obj;
	Common common;

	@BeforeClass
	public void LoginAllScenarios() throws IOException, InterruptedException
	{
		capabilities();
		//*********Getting objects of required pages*************
		obj = new ObjectRepo();
		
	}

	
	
	@Test(dataProvider = "TS_BookProduct", dataProviderClass = AmazonDataprovider.class, priority =1)
	public void TestBookProduct(LinkedHashMap<String, String> dataMap){
		try {
			common = new Common();
			// Before triggerring make sure to use original credentials. inpt in excel sheet.
			boolean loginApp = common.login(dataMap.get("user"), dataMap.get("pwd"));
			if(loginApp){
				Assert.assertTrue(common.searchThenBuyproduct(dataMap.get("product")));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void loginAllAfterMethod(ITestResult testResult)throws IOException, HeadlessException, AWTException
	{	
		if (testResult.getStatus() == 2)
			//logTestReport.log(LogStatus.FAIL, "Snapshot for reference " + logTestReport.addScreenCapture(commonUtils.fn_TakeScreenShot(testResult.getMethod().getMethodName())));
		//extent.endTest(logTestReport);
		extent.flush();
	}

	@AfterClass(alwaysRun=true)
	public void loginAllAfterClass() throws InterruptedException, HeadlessException, IOException, AWTException
	{		
		System.out.println("After class");
		//extent.flush();
	}
	
	
	
}
