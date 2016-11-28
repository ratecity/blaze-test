package com.ratecity.homeloan.automationFramework.test;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		   BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans?nav=home-loans");
		   Utility.GoToSleep(2000);
		    HomeLoanLandingpage.fn_PopularHomeLoan();
		   HomeLoanLandingpage.fn_CheckIfArticlesLinksAreWorking();
		   HomeLoanLandingpage.fn_CheckCompany_ProductLink();
		   HomeLoanLandingpage.fn_HomeLoanTools();
		   HomeLoanLandingpage.fn_HomeLoanNews();
		   HomeLoanLandingpage.fn_ClickonMoreHomeLoanNews();
		   HomeLoanLandingpage.fn_HomeLoanTopLinks();
		   HomeLoanMortgageRates.fn_ClickOnCompareCheckbox(5);
		   if(HomeLoanLandingpage.fn_CountvaluesOnComparebar()==5){
			   if(HomeLoanLandingpage.fn_isCompareButtonVisible() && HomeLoanLandingpage.fn_isClearButtonvisible()){
				 HomeLoanLandingpage.fn_ClickOnClearButton();  
				  HomeLoanLandingpage.fn_CheckBrowseMoreLink();
			   }
		   }
		   
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
	
	 @Test(priority=4)
	  public void fn_HomeLoanMortgagepage_SearchListing() throws Exception{
		 logger = report.startTest("HomeLoanSearchListing");
		//BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans/mortgage-rates");
		 Utility.GoToSleep(2000);
		 if(HomeLoanMortgageRates.fn_hasRateTable()&&
			          HomeLoanMortgageRates.fn_hasToolTip() && 
					                 HomeLoanMortgageRates.fn_hasArticles()){
			  String prev_value=HomeLoanMortgageRates.fn_MonthlyRepayment();
			  HomeLoanMortgageRates.fn_ChangeBorrowingAmount();
			  String updated_value=HomeLoanMortgageRates.fn_MonthlyRepayment(); 
				  if(Utility.fn_CompareTwocollectionvalues(prev_value, updated_value)){
					  BaseClass.logger.log(LogStatus.INFO, "Updated value is greater then prev value!!!");
					    HomeLoanMortgageRates.fn_ClickOnPagination("100");
					 //   HomeLoanMortgageRates.fn_Verfiy_AdvertisedRateText("Variable");
					    HomeLoanMortgageRates.fn_ClickOnInterestRateChkBox("Variable");
					     if(HomeLoanMortgageRates.fn_Verfiy_AdvertisedRateText("Variable")){
					    	BaseClass.logger.log(LogStatus.FAIL, "Except variables,Other AdvertisedrateText is also getting displayed!!!");
					    	Assert.assertTrue(false);
					    }
					    else{
					    	Assert.assertTrue(true);
					    	BaseClass.logger.log(LogStatus.PASS, "Excepted values are getting displayed after filter!!!");
					    }
				  }
				  else{
					  BaseClass.logger.log(LogStatus.FATAL, "Expected Value is not getting displayed!!!");
					  Assert.assertTrue(false);
					  
				   }
		   }else{
			   BaseClass.logger.log(LogStatus.FATAL, "RateTable,ToolTips& Articles are not getting displayed!!!");  
			   Assert.assertTrue(false);
		   }
	  }
	 
	
 }
