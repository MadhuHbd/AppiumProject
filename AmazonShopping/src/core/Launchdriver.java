package core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
public class Launchdriver {

	public static int iteration = 0,intPreviousViewsCountOnMap = 0, logList=0;
	public String testNameToReport,mobileNumber,password;
	protected ExtentTest  logTestReport;
	protected ExtentTest logTestReportInSetup;
	boolean loginFlag = false,loginFailedFlag = false, appLaunchFlag = false;
	protected ExtentReports extent;
	public static AndroidDriver<AndroidElement> driver;
	
	
	public static  void capabilities() throws MalformedURLException
	{
		 File appDir = new File("src");
	     File app = new File(appDir, "Amazon_shopping.apk");
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	     
	     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "2df3683e7d15");
	     capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	     driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
