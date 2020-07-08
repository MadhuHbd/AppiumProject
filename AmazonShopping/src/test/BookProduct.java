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
import core.BasicActions;
import core.Launchdriver;

public class BookProduct extends Launchdriver{
	
	ObjectRepo obj;
	Common common;
	
	//** Setting test data columns to avoid direct hard coding of the column
	static String user = "user";
	static String pwd = "pwd";
	static String product = "product";
	static String rotateScreen = "rotateScreen";
	static String screenResolution = "screenResolution";

	@BeforeClass
	public void InitializeObjRepo() throws IOException, InterruptedException
	{
		capabilities();
		//*********Getting objects of required pages*************
		obj = new ObjectRepo();
		
	}
	
	
	@Test(dataProvider = "TS_BookProduct", dataProviderClass = AmazonDataprovider.class, priority =1)
	public void TestBookProduct(LinkedHashMap<String, String> dataMap){
		try {
			BasicActions ba = new BasicActions();
			//handles the screen rotation mode from the excel sheet data
			if(dataMap.get(rotateScreen).equalsIgnoreCase("y")){
				ba.rotateScreen();
			}
			if(!dataMap.get(screenResolution).equalsIgnoreCase("default")){
				try{
					String[] scrResolution = dataMap.get(screenResolution).split(",");
					ba.setScreeResolution(Integer.parseInt(scrResolution[0]), Integer.parseInt(scrResolution[1]));
				}catch(NumberFormatException n){
					System.out.println("Number is not an integer type. Change to integer in excel sheet : Column - screenResolution" + n.getLocalizedMessage());
					System.out.println("Countinuing with default screen resolution.");
				}
			}
			common = new Common();
			// Before triggering make sure to use original credentials. inpt in excel sheet.
			boolean loginApp = common.login(dataMap.get(user), dataMap.get(pwd));
			if(loginApp){
				Assert.assertTrue(common.searchThenBuyproduct(dataMap.get(product)));
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
		//Logout Method
		//extent.flush();
	}
	
	
	
}
