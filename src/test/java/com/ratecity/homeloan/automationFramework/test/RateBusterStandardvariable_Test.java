package com.ratecity.homeloan.automationFramework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.ratecity.homeloan.automationFramework.pages.RateBusterStandardVariable;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;




public class RateBusterStandardvariable_Test extends BaseClass {
	
   static By LoanProfile = By.xpath("//h4[text()='Loan Profile']");
   static By LoanFees = By.xpath("//h4[text()='Loan Fees']");
   static By Reviews = By.xpath("//h2[text()='Reviews']");
   static By LoanInformation = By.xpath("//a[@id='product-tabs-tab-info']//span");
   static By LoanReviews =  By.xpath("//a[@id='product-tabs-tab-reviews']");
   static WebElement element=null;
	
	public static void fn_VerifyLoanInformation(){
	    element = driver.findElement(LoanInformation);	
		if(RateBusterStandardVariable.isElementEnabled(element)){
			if(RateBusterStandardVariable.areElementsPresent(LoanProfile)){
				if(RateBusterStandardVariable.areElementsPresent(LoanFees)){
					Assert.assertTrue(true);
				}
				else
					Assert.assertTrue(false);
		}
		}
	}
	
public static void fn_VerifyLoanReviews() throws Exception{
	element =  driver.findElement(LoanReviews);
	System.out.println("*****************************************");
	RateBusterStandardVariable.scrollDown();
	RateBusterStandardVariable.clickAndWait(element,20000);
	element =  driver.findElement(Reviews);
	if(RateBusterStandardVariable.getText(element).equalsIgnoreCase("Reviews")){
		Assert.assertTrue(true);
	}
	else
		Assert.assertTrue(false);
    }
	

}