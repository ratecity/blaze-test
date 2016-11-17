package com.ratecity.homeloan.automationFramework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ratecity.homeloan.automationFramework.pages.HomeLoanLandingpage;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.relevantcodes.extentreports.LogStatus;





public class Homepage_Test extends BaseClass {
	
	
	
	@Test(priority=1)
	  public void fn_VerifyHomeLoanLandingPage() throws  Exception{
		 
		  logger = report.startTest("HomeLoanLandingPage");
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
	
/*	
	@Test(priority=1)
	  public void fn_HomeLoan_DisplayAtLeat_15Contents_TestOR(){
		 // logger = reports.startTest("abcd");
		  List<WebElement> list  = driver.findElements(parser.getobjectLocator("HomeLoan.ProductList"));
		  if(list.size()==15){
			  Assert.assertTrue(true);
		  }
		  else{
		  Assert.assertTrue(false,list.size() + ": is getting displayed ");
		  }
	  }

 
  //@Test(priority=1)
  public void fn_HomeLoan_DisplayAtLeat_15Contents(){
	 // logger = reports.startTest("abcd");
	  List<WebElement> list  = driver.findElements(By.cssSelector("tr.product"));
	  if(list.size()==15){
		  Assert.assertTrue(true);
	  }
	  else{
	  Assert.assertTrue(false,list.size() + ": is getting displayed ");
	  }
  }
  
 // @Test(priority=2)
  public void fn_HomeLoan_DisplayAtLeat_50Contents() throws InterruptedException{
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("div.rate-table-control span a")).click(); 
	  Thread.sleep(5000);
	  List<WebElement> list  = driver.findElements(By.cssSelector("tr.product"));
	  if(list.size()==50){
		  Assert.assertTrue(true);
	  }
	  else{
	  Assert.assertTrue(false,list.size() + ": is getting displayed ");
	  }
  }
  
   //@Test
  public void fn_HomeLoan_DisplayAtLeat_100Contents() throws InterruptedException{
	  Thread.sleep(1000);
	 
	  WebElement show  = driver.findElement(By.cssSelector("div.rate-table-control span a"));
	  System.out.println(show.getText());
	  show.click();
	  
	  Thread.sleep(5000);
	  List<WebElement> list  = driver.findElements(By.cssSelector("tr.product"));
	  System.out.println("******************List size : "+ list.size());
	  if(list.size()==100){
		  Assert.assertTrue(true);
	  }
	  else{
	  Assert.assertTrue(false,list.size() + ": is getting displayed ");
	  }
  }
 
 //@Test(priority=3)
  public void fn_toValidateBankPage() throws InterruptedException{
	  
	  WebElement firstbank =  driver.findElement(By.cssSelector("tr.product div a"));
	  String bankname = firstbank.getText();
	  firstbank.click();
	  Thread.sleep(5000);
	  if(RateBusterStandardVariable.fn_verifytitle()){
		  WebElement bankheader =  driver.findElement(By.cssSelector("ol.breadcrumb li.active span[property='name']"));
		  if(bankname.equalsIgnoreCase(bankheader.getText())){
			 Assert.assertTrue(true);
		  }
		  else
			  Assert.assertTrue(false, "Expected page is"+firstbank.getText()+" :- is  not getting displayed");  
	  }
	  else{
		  
		  Assert.assertTrue(false, "Wrong page: "+driver.getTitle()+ " is getting displayed"); 
	  }
	  
	  
  }
  
 @Test(priority=2)
  public void fn_toVerifyComparefunctionalityWith2Banks() throws Exception{
	
	 logger = report.startTest("CompareButtonFunctionality");
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
 
  
  
 // @Test(priority=5)
  public void fn_toVerify_RateBusteredElements() throws Exception{
	  WebElement firstbank =  driver.findElement(By.cssSelector("tr.product div a"));
	  RateBusterStandardVariable.clickAndWait(firstbank, 2000);
	 // Thread.sleep(5000);
	  RateBusterStandardvariable_Test.fn_VerifyLoanReviews();
	  Thread.sleep(30000);
	  
	  
  }
  
*/  
 }
