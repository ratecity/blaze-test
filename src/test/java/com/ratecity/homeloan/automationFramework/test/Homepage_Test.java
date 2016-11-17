package com.ratecity.homeloan.automationFramework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ratecity.homeloan.automationFramework.pages.HomeLoanComparisonpage;
import com.ratecity.homeloan.automationFramework.pages.HomeLoanLandingpage;
import com.ratecity.homeloan.automationFramework.pages.HomeLoanMortgageRates;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.relevantcodes.extentreports.LogStatus;





public class Homepage_Test extends BaseClass {
	
	
	
	@Test(priority=1)
	  public void fn_VerifyHomeLoanLandingPage() throws  Exception{
		 
		  logger = report.startTest("HomeLoanLandingPage");
		  BaseClass.getDriver().navigate().to("https://staging.ratecity.com.au/home-loans");
		   Utility.GoToSleep(2000);
		if(HomeLoanLandingpage.fn_CheckIfAds("HomeLoan.Ads_top")&& HomeLoanLandingpage.fn_CheckIfAds("HomeLoan.Ads_Middle")&& HomeLoanLandingpage.fn_CheckIfAds("HomeLoan.Ads_Bottom")){
			 
			  if(HomeLoanLandingpage.fn_CheckIfRateTableHas6Records("HomeLoan.RateRecordsContainer","HomeLoan.RateRecords")){
				  if(HomeLoanLandingpage.fn_CheckIfhasArticles("HomeLoan.articles")){
					  	  logger.log(LogStatus.PASS,"HomeLoan page landed Successfully" );
						  Assert.assertTrue(true, "HomeLoan page landed Successfully"); 
				 }
			  }
		 }
		  else{
			  logger.log(LogStatus.FAIL,"HomeLoan page is not landed Successfully" );
			 Assert.assertTrue(false, "HomeLoan page is not landed successfully");
		  }
		  
		  
	  }	
	
	@Test(priority=2)
	  public void fn_toVerifyComparefunctionalityWith2Banks() throws Exception{
		
		 logger = report.startTest("CompareButtonFunctionality");
		 Utility.GoToSleep(2000);
		 HomeLoanMortgageRates.fn_ClickOnCompareCheckbox(2);
		 HomeLoanMortgageRates.fn_ClickOnCompareButton();
		 if(HomeLoanComparisonpage.fn_VerifyHomeLoanText()){
			if(HomeLoanComparisonpage.fn_VerifyComparisontable()==3){
				logger.log(LogStatus.PASS, "INTO METHOD==> CompareFunctionality :  Working Successfully!! :)");
				 Assert.assertTrue(true); 
			}
			else{
				 logger.log(LogStatus.FAIL, "INTO METHOD==> CompareFunctionality :  Not working Successfully!! (: ");
				 Assert.assertTrue(false);
			 }
			
		 }
		}
	
	@Test(priority=3)
	 public void fn_toVerifyCompareWithBig4Button() throws Exception{
		
		 logger = report.startTest("CompareWithBig4ButtonFunctionality");
		 HomeLoanMortgageRates.fn_ClickOnCompareCheckbox(1);
		 HomeLoanMortgageRates.fn_ClickOnComparewithBig4Button();
		 if(HomeLoanComparisonpage.fn_VerifyHomeLoanText()){
			if(HomeLoanComparisonpage.fn_VerifyComparisontable()==6){
				logger.log(LogStatus.PASS, "INTO METHOD==> CompareWithBig4Button Functionality :  Working Successfully!! :)");
				 Assert.assertTrue(true); 
			}
			else{
				 logger.log(LogStatus.FAIL, "INTO METHOD==> CompareWithBig4 Functionality :  Not working Successfully!! (: ");
				 Assert.assertTrue(false);
			 }
			
		 }
		}
 }
