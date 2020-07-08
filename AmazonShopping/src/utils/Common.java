package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

import objectrepo.ObjectRepo;
import core.BasicActions;
import core.Launchdriver;

public class Common extends BasicActions{

	AndroidDriver<AndroidElement>  driver = null;
	ObjectRepo obj;
	
	public Common() throws MalformedURLException{
		this.driver = Launchdriver.driver;
	}
	
	public boolean login(String user, String pwd){
		obj = new ObjectRepo();
		performClick(obj.getSignInBtn());
		performSendKeys(obj.getUserName(), user);
		performClick(obj.getContinueBtn());
		performSendKeys(obj.getPwdTxtBox(), pwd);
		performClick(obj.getLoginBtn());
		fn_WaitForElement(obj.getEnglishRadio(), 20);
		performClick(obj.getButton().get(1));
		return verifyElementDisplay(obj.getMenuBtn());
	}
	
	public boolean searchThenBuyproduct(String product){
		performSendKeys(obj.getSearchBox(), product);
		performClick(obj.getSearchResult());
		
		// scroll up to getTanyoTv()
		String tv = "TCL 163.8 cm (65 inch) 4K Ultra HD Certified Android LED TV 65C6 (Black) (2019 Model)";
		scroll(tv);
		
		performClick(obj.getSearchList().get(2));
		
		scroll("Add to Cart");
		
		performClick(obj.getAddtoCart());
		performClick(obj.getCartImage());
		performClick(obj.getProceedToBuy());
		/*
		   **Code for Payment Method
		*/
		return true;
	}
}
