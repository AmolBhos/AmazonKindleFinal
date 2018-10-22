package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.dataprovider.ConfigFileReader;

public class KindleOrderPage {
	
	
public static WebDriver driver;

public static ConfigFileReader configFileReader= new ConfigFileReader();


private By FindShopByDepartment = By.cssSelector("#nav-link-shopall > span.nav-line-2");
private By FindKindlePaperWhite = By.xpath ("(.//*[normalize-space(text()) and normalize-space(.)='Small, light, and perfect for reading'])[1]/following::span[1]");
private By FindQuantityDropdown = By.id("quantity");
private By FindQuantitySelection = By.id("quantity");
private By FindAddToCartBtn = By.id("add-to-cart-button");
private By FindNoExtraItem = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add to Order'])[6]/following::button[1]");
private By FindCheckout = By.xpath("//*[@id='hlb-next-steps']/a[2]");
private By FindSignIn = By.id("ap_email");

@FindBy(css = "#nav-link-shopall > span.nav-line-2")
public static WebElement ShopByDepartment;

@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Small, light, and perfect for reading'])[1]/following::span[1]")
public static WebElement KindlePaperWhite;

@FindBy(id = "quantity")
public static WebElement QuantityDropdown;

@FindBy(id = "quantity")
public static WebElement QuantitySelection;

@FindBy(id = "add-to-cart-button")
public static WebElement AddToCartBtn;

@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Add to Order'])[6]/following::button[1]")
public static WebElement NoExtraItem;

@FindBy(xpath = "//*[@id='hlb-next-steps']/a[2]")
public static WebElement Checkout;

@FindBy(id = "ap_email")
public static WebElement SignIn;


public KindleOrderPage(WebDriver driver) {
	
	this.driver = driver;
	PageFactory.initElements(driver, this);		
	
}

public static void ShopByDepartmentMo(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(ShopByDepartment));
	
	WebElement element = driver.findElement(By.cssSelector("#nav-link-shopall > span.nav-line-2"));
	 
    Actions action = new Actions(driver);

    action.moveToElement(element).build().perform();
    
}

public static void Kindle(WebDriver driver) throws InterruptedException {
	
	/*Second Mouse Over*/
	WebElement element1 = driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[8]/span"));
	 
    Actions action1 = new Actions(driver);

    action1.moveToElement(element1).build().perform();    
        
}

public static void KindlePaperWhiteWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(KindlePaperWhite));
	
}
public static void QuantityDropdownWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(QuantityDropdown));
}
public static void QuantitySelectionWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(QuantitySelection));
}
public static void AddToCartBtnWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtn));
}
public static void NoExtraItemWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(NoExtraItem));
}
public static void CheckoutWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(Checkout));
}
public static void SignIntWait(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.elementToBeClickable(SignIn));
}

public boolean verifyAmazonTitle() throws InterruptedException {
	boolean res = false;
	if(driver.getTitle() == "Amazon.ca: Online shopping in Canada - books, electronics, Kindle, home & garden, DVDs, tools, music, health & beauty, watches, baby, sporting goods & more"){
		res=true;
	}
	
	return res;
}

public boolean verifyShopByDepartment() throws InterruptedException {
	boolean res = false;	
	boolean b = driver.findElement(FindShopByDepartment).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}

public boolean verifyKindleWhitePaper() throws InterruptedException {
	boolean res = false;	
	 boolean b = driver.findElement(FindKindlePaperWhite).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}
public boolean verifyQuantityDropdown() throws InterruptedException {
	boolean res = false;	
	 boolean b = driver.findElement(FindQuantityDropdown).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}

	public boolean verifyQuantitySelection() throws InterruptedException {
		boolean res = false;	
		 String b = driver.findElement(FindQuantitySelection).getText();
		if(b==configFileReader.getQuantity()){
			res=true;
		}
	
	return res;
}
public boolean verifyAddToCartBtn() throws InterruptedException {
	boolean res = false;	
	 boolean b = driver.findElement(FindAddToCartBtn).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}
public boolean verifyNoExtraItem() throws InterruptedException {
	boolean res = false;	
	 boolean b = driver.findElement(FindNoExtraItem).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}
public boolean verifyCheckout() throws InterruptedException {
	boolean res = false;	
	 boolean b = driver.findElement(FindCheckout).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}
public boolean verifySignIn() throws InterruptedException {
	boolean res = false;	
	 boolean b = driver.findElement(FindSignIn).isDisplayed();
	if(b==true){
		res=true;
	}
	
	return res;
}
	
	

}
