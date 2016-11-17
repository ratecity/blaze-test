package com.ratecity.homeloan.automationFramework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.RespositoryParser;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;


public class HomeLoanComparisonpage {
	
	 

public HomeLoanComparisonpage() {
	BaseClass.logger.log(LogStatus.INFO, "INTO CLASS ==> HomeLoanComparisonpage");
	if(BaseClass.getDriver().getTitle().contains(" Home Loan Comparison | RateCity")){
		BaseClass.logger.log(LogStatus.INFO, "Expected page Loaded Successfully!!!!");
	}
	else{
		BaseClass.logger.log(LogStatus.FAIL, "!!Wrong page is getting displayed");
	    Assert.assertTrue(false);
	}
	}



public static boolean fn_verifytitle(){
		
	if(BaseClass.getDriver().getTitle().contains("Home Loan Comparison | RateCity")){
		return true;
	}
	else
		return false;
	}



public static int fn_VerifyComparisontable() throws Exception{
	List<WebElement> we =  BaseClass.getDriver().findElements(new RespositoryParser()
			.getobjectLocator("HomeLoan.Compareblocks"));
	for (WebElement webElement : we.subList(1, we.size())) {
		Utility.highlightElementBorder(webElement);
	}
	return we.size();
	
}
public static boolean fn_VerifyHomeLoanText() throws Exception{
	BaseClass.logger.log(LogStatus.INFO, "INTO Method ==> fn_VerifyHomeLoanText");
	boolean flag = false;
	WebElement we  = BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator("HomeLoan.Comparedpage"));
	if(we.isDisplayed()&& we.getText().equalsIgnoreCase("Home Loan Comparison")){
		BaseClass.logger.log(LogStatus.INFO, "INTO Method ==> Expected element is displayed");
		Utility.highlightElementBorder(we);
		flag=true;return flag;
		}
	else{
		BaseClass.logger.log(LogStatus.WARNING, "Expected Text is not found!!!");
		return flag;
	}
	
	
	
	
	
}
}
