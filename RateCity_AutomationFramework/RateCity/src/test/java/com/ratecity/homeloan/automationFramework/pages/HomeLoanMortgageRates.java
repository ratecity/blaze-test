package com.ratecity.homeloan.automationFramework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.RespositoryParser;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.relevantcodes.extentreports.LogStatus;


public class HomeLoanMortgageRates {
	 
	private static WebElement element=null;
	
	
	
	public static boolean fn_verifytitle(){
		
		if(BaseClass.getDriver().getTitle().equalsIgnoreCase("Mortgage rates | Rates from 4.09% | RateCity.com.au")){
			return true;
		}
		else
			return false;
	}
	
	public static void fn_ClickOnCompareCheckbox(int value)throws Exception{
	
		List<WebElement> we =  BaseClass.getDriver().findElements(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate"));
		for (int i=0;i<value;i++) {
			Utility.scrollToElement(we.get(i));
			we.get(i).click();
			Utility.GoToSleep(1000);
		}
		
		
	}
	public static HomeLoanComparisonpage fn_ClickOnCompareButton() throws Exception{
		
		if(Utility.isElementPresentAndDisplay(new RespositoryParser()
				.getobjectLocator("HomeLoan.MortgageRate.CompareButton"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>ClickOnCompareButton : Compare button is visible");
			element =  BaseClass.getDriver().findElement(new RespositoryParser()
					.getobjectLocator("HomeLoan.MortgageRate.CompareButton"));
			Utility.clickAndWait(element, 1000);
			return new HomeLoanComparisonpage();
		}
		return null;
	}
	
	public static HomeLoanComparisonpage fn_ClickOnComparewithBig4Button() throws Exception{
		if(Utility.isElementPresentAndDisplay(new RespositoryParser()
				.getobjectLocator("HomeLoan.MortgageRate.CompareWithBig4Button"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>ClickOnCompareButton : CompareWithBig4Button button is visible");
			element = BaseClass.getDriver().findElement(new RespositoryParser()
					.getobjectLocator("HomeLoan.MortgageRate.CompareWithBig4Button"));
					Utility.clickAndWait(element,1000);
					return new HomeLoanComparisonpage();
		}
		return null;
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

