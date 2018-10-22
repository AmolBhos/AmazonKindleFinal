package com.amazon.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.amazon.pages.KindleOrderPage;
import com.amazon.test.ScriptFactory;

public class VerifyKindleOrderPageTest extends ScriptFactory {	

	@Test(priority=1)
	public void verifyKindleOrder() throws InterruptedException{	
		
		KindleOrderPage hp=new KindleOrderPage(getDriver());	
		
		
		 /*Test Case 1*/
		try{            
			Assert.assertEquals(hp.verifyAmazonTitle(), true); 	        
			test.log(LogStatus.PASS, "Amazon.ca Title is correct");
	    }catch(AssertionError e){           
	        test.log(LogStatus.FAIL, "Amazon.ca Title is not correct");    
	    }
				
		/*Test Case 2*/
		try{            
	        Assert.assertEquals(hp.verifyShopByDepartment(), true);   
	        test.log(LogStatus.PASS, "Shop By Department section is Displayed");
	    }catch(AssertionError e){           
	        test.log(LogStatus.FAIL, "Shop By Department section is not Displayed");    
	    }
		KindleOrderPage.ShopByDepartmentMo(driver);					
						
		KindleOrderPage.Kindle(driver);			
	
			KindleOrderPage.KindlePaperWhiteWait(driver);		
			/*Test Case 3*/
			try{            
		        Assert.assertEquals(hp.verifyKindleWhitePaper(), true);   
		        test.log(LogStatus.PASS, "Kindle Paper White button is Displayed");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "Kindle Paper White button  is not Displayed");    
		    }
			KindleOrderPage.KindlePaperWhite.click();
			
			KindleOrderPage.QuantityDropdownWait(driver);
			/*Test Case 4*/
			try{            
		        Assert.assertEquals(hp.verifyQuantityDropdown(), true);   
		        test.log(LogStatus.PASS, "Quantity Dropdown is Displayed");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "Quantity Dropdown is not Displayed");    
		    }
			
			/*Test Case 5 : Data Parameterization*/
			KindleOrderPage.QuantityDropdown.sendKeys(configFileReader.getQuantity());
			try{            
		        Assert.assertEquals(hp.verifyQuantitySelection(), true);   
		        test.log(LogStatus.PASS, "Quantity 2 is Selected");
		        System.out.println("Quantity is Correct");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "Quantity 2 is not Selected");    
		    }
			

			KindleOrderPage.AddToCartBtnWait(driver);
			/*Test Case 6*/
			try{            
		        Assert.assertEquals(hp.verifyAddToCartBtn(), true);   
		        test.log(LogStatus.PASS, "Add to Cart button is Displayed");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "Add to Cart button is not Displayed");    
		    }
			KindleOrderPage.AddToCartBtn.click();	        
			
			KindleOrderPage.NoExtraItemWait(driver);
			/*Test Case 7*/
			try{            
		        Assert.assertEquals(hp.verifyNoExtraItem(), true);   
		        test.log(LogStatus.PASS, "Extra Element Screen is displayed");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "Extra Element Screen is not displayed");    
		    }
			KindleOrderPage.NoExtraItem.click();
		        
			KindleOrderPage.CheckoutWait(driver);
			/*Test Case 8*/
			try{            
		        Assert.assertEquals(hp.verifyCheckout(), true);   
		        test.log(LogStatus.PASS, "Checkout Button is Displayed");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "Checkout Button is not Displayed");    
		    }
			KindleOrderPage.Checkout.click();
			
			KindleOrderPage.SignIntWait(driver);
			/*Test Case 9*/
			try{            
		        Assert.assertEquals(hp.verifySignIn(), true);   
		        test.log(LogStatus.PASS, "User is displayed with SignIn page");
		    }catch(AssertionError e){           
		        test.log(LogStatus.FAIL, "User is not displayed with SignIn page");    
		    }
			
			
	}

}
