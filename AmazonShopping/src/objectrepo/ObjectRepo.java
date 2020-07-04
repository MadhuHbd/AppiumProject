package objectrepo;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import core.Launchdriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ObjectRepo extends Launchdriver{

	
	AndroidDriver<AndroidElement>  driver = null;
	
	public ObjectRepo()
	{
		this.driver = Launchdriver.driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Already a customer? Sign in']")
	private WebElement signInBtn;
	public WebElement getSignInBtn(){
		return signInBtn;
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']") 
	private WebElement userName;
	public WebElement getUserName(){
		return userName;
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	private WebElement continueBtn;
	public WebElement getContinueBtn(){
		return continueBtn;
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Amazon password']")
	private WebElement pwdTxtBox;
	public WebElement getPwdTxtBox(){
		return pwdTxtBox;
	}
	
	@AndroidFindBy(xpath  = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_burger_icon']")
	private WebElement menuBtn;
	public WebElement getMenuBtn(){
		return menuBtn;
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	private WebElement searchBox;
	public WebElement getSearchBox(){
		return searchBox;
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']")
	private WebElement loginBtn;
	public WebElement getLoginBtn(){
		return loginBtn;
	}
	
	@AndroidFindBy(xpath="//android.widget.Button")
	private List<WebElement> buttons;
	public List<WebElement> getButton(){
		return buttons;
	}
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='English - EN']")
	private WebElement englishRadio;
	public WebElement getEnglishRadio(){
		return englishRadio;
	}
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[0]//android.widget.TextView")
	private WebElement searchResult;
	public WebElement getSearchResult(){
		return searchResult;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'TCL 163.8 cm (65 inch) 4K Ultra HD Certified Android LED TV 65C6 (Black) (2019 Model)']")
	private WebElement tanyoTv;
	public WebElement getTanyoTv(){
		return tanyoTv;
	}
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout//android.widget.TextView")
	private List<WebElement> searchList;
	public List<WebElement> getSearchList(){
		return searchList;
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android.widget.Button']")
	private WebElement addToCart;
	public WebElement getAddtoCart(){
		return addToCart;
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@resource=id='a-autoid-1']")
	private WebElement buyBtn;
	public WebElement getBuyBtn(){
		return buyBtn;
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_image']")
	private WebElement cartImage;
	public WebElement getCartImage(){
		return cartImage;
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed to Buy']")
	private WebElement proceedToBuy;
	public WebElement getProceedToBuy(){
		return proceedToBuy;
	}
}
