package core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class BasicActions {
	
	
	public void performClick(WebElement element){
		
		try{
			if(fn_WaitForElement(element, 30))
				element.click();
		}catch(NoSuchElementException e){
			System.out.println(e);
		}
	}
	
	public void performSendKeys(WebElement element, String text){
			
			try{
				if(fn_WaitForElement(element, 30))
					element.sendKeys(text);;
			}catch(NoSuchElementException e){
				System.out.println(e);
			}
		}
	
	public boolean verifyTestPass(WebElement element){
		
		try{
			if(fn_WaitForElement(element, 30))
				element.isDisplayed();
		}catch(NoSuchElementException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public boolean fn_WaitForElement(final WebElement element, int timeoutSeconds) {

		try {
			if(element != null){
				WebDriverWait wait = new WebDriverWait(Launchdriver.driver, timeoutSeconds);
				Function<WebDriver, Boolean> myFunction = new Function<WebDriver, Boolean>(){
					public Boolean apply(WebDriver arg0){ 
						System.out.println("Checking for the object!!");
						//WebElement element = arg0.findElement(By.id("dynamicText"));
						if (element != null){						
							//System.out.println("A new dynamic object is found.");						
							return element.isDisplayed();
						}
						return true;	
					} 
				};
				wait.until(myFunction);
				return true;
			}
			else{
				System.out.println("Desired object passing as null, please check once");
				return false;
			}
		} catch (Exception e){
			System.out.println("Unable to identify the object, please check once ");
			return false;
		}
	}
	
	public boolean scroll(String tv){
		Launchdriver.driver.findElementByAndroidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(\""+ tv +"\"))");
		return false;
	}
	
}
