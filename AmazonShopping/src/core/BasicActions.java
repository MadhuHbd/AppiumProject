package core;

import io.appium.java_client.TouchAction;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

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
	
	public boolean verifyElementDisplay(WebElement element){
		
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
		try{
			Launchdriver.driver.findElementByAndroidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(\""+ tv +"\"))");
			return true;
		}catch(Exception e){
			System.out.println("Unable to scroll to the element : Exception found " + e.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean rotateScreen(){
		try{
			Launchdriver.driver.rotate(ScreenOrientation.LANDSCAPE);
			return true;
		}catch(Exception e){
			System.out.println("Unable to rotate screen : Exception found " + e.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean setScreeResolution(int x, int y){
		try{
			Launchdriver.driver.manage().window().setSize(new Dimension(x, y));
			return true;
		}catch(Exception e){
			System.out.println("Unable to set the desired screen resolution : Exception found " + e.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean tapOElement(WebElement e){
		try{
			TouchAction t =new TouchAction(Launchdriver.driver);
			t.tap(tapOptions().withElement(element(e))).perform();
			return true;
		}catch(Exception el){
			System.out.println("Unable to tap on element : Exception found " + el.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean longpress(WebElement e){
		try{
			TouchAction t =new TouchAction(Launchdriver.driver);
			t.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2))).release().perform();
			return true;
		}catch(Exception el){
			return false;
		}
	}
}
