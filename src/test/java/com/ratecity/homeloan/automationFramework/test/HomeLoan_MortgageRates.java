package com.ratecity.homeloan.automationFramework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ratecity.homeloan.automationFramework.pages.HomeLoanComparisonpage;
import com.ratecity.homeloan.automationFramework.pages.HomeLoanLandingpage;
import com.ratecity.homeloan.automationFramework.pages.HomeLoanMortgageRates;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.relevantcodes.extentreports.LogStatus;





public class HomeLoan_MortgageRates extends BaseClass {

	@Test(priority=1)
	public void Test_ToVerifyClearButtonFunctionality() throws Exception{
		logger = report.startTest("HomeLoan_MortgageRates_VerifyClearButtonFunctionality");
		BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans/mortgage-rates");
		HomeLoanMortgageRates.fn_ClickOnCompareCheckbox(2);
		HomeLoanLandingpage.fn_ClickOnClearButton();
		if(HomeLoanMortgageRates.fn_IsCompareCheckBoxSelected(2)){
			BaseClass.logger.log(LogStatus.ERROR,"Compare CheckBox is stil Selected"); 
			Assert.assertTrue(false);

		}else{
			Assert.assertTrue(true,"Check Box is Still Selected");
			BaseClass.logger.log(LogStatus.PASS,"Compare CheckBox is not Selected"); 
		}
	}
	@Test(priority=2)
	public void Test_toVerifyComparefunctionalityWith2Banks() throws Exception{
		logger = report.startTest("HomeLoan_MortgageRates_VerifyComparefunctionalityWith2Banks");
		BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans/mortgage-rates");
		Utility.GoToSleep(2000);
		HomeLoanMortgageRates.fn_ClickOnCompareCheckbox(2);
		HomeLoanMortgageRates.fn_ClickOnCompareButton();
		if(HomeLoanComparisonpage.fn_VerifyHomeLoanText()){
			if(HomeLoanComparisonpage.fn_VerifyComparisontable()==3){
				BaseClass.logger.log(LogStatus.PASS, "INTO METHOD==> CompareFunctionality :  Working Successfully!! :)");
				Assert.assertTrue(true); 
			}
			else{
				BaseClass.logger.log(LogStatus.FAIL, "INTO METHOD==> CompareFunctionality :  Not working Successfully!! (: ");
				Assert.assertTrue(false);
			}

		}
	}
	
	@Test(priority=3)
	public void Test_toVerifyRateTableHas20Records()throws Exception{
		logger = report.startTest("HomeLoan_MortgageRates_VerifyRateTableHas20Records");
		BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans/mortgage-rates");
		Utility.GoToSleep(2000);
		if(HomeLoanMortgageRates.fn_CheckNumberOfRateRecord()==20){
			Assert.assertTrue(true); 
			BaseClass.logger.log(LogStatus.PASS, "20 Records are getting displayed");
		}else{
			Assert.assertTrue(false); 
			BaseClass.logger.log(LogStatus.FAIL, "20 Records is not getting displayed");
		}
	}

	@Test(priority=4)
	public void Test_toVerifyCompareWithBig4Button() throws Exception{
		logger = report.startTest("HomeLoan_MortgageRates_VerifyCompareWithBig4Button");
		BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans/mortgage-rates");
		Utility.GoToSleep(2000);
		HomeLoanMortgageRates.fn_ClickOnCompareCheckbox(1);
		HomeLoanMortgageRates.fn_ClickOnComparewithBig4Button();
		if(HomeLoanComparisonpage.fn_VerifyHomeLoanText()){
			if(HomeLoanComparisonpage.fn_VerifyComparisontable()==6){
				BaseClass.logger.log(LogStatus.PASS, "INTO METHOD==> CompareWithBig4Button Functionality :  Working Successfully!! :)");
				Assert.assertTrue(true); 
			}
			else{
				BaseClass.logger.log(LogStatus.FAIL, "INTO METHOD==> CompareWithBig4 Functionality :  Not working Successfully!! (: ");
				Assert.assertTrue(false);
			}

		}
	}
	@Test(priority=5)
	public void Test_toVerifyHomeLoanMortgagepage_SearchListing() throws Exception{
		logger = report.startTest("HomeLoan_MortgageRates_VerifyHomeLoanMortgagepage_SearchListing");
		BaseClass.getDriver().navigate().to("http://www.ratecity.com.au/home-loans/mortgage-rates");
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
