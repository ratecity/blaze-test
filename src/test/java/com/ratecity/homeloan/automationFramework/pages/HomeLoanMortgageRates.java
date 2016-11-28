package com.ratecity.homeloan.automationFramework.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
			Utility.selectcheckbox(we.get(i));
			//we.get(i).click();
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
	public static boolean fn_hasToolTip() throws IOException{
		boolean flag = false;
		if(Utility.isElementPresent(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.ToolTips"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_hasToolTip : Tool Tip is visible");
			List<WebElement> tooltip  = BaseClass.getDriver().
					findElements(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.ToolTips"));
			if(tooltip.size()>0){
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_hasToolTip : "+tooltip.size()+"==>> has found on RateTable");
				return flag=true;}
			else{
				BaseClass.logger.log(LogStatus.WARNING,"INTO METHOD==>fn_hasToolTip : "+tooltip.size()+"ToolTips ==>> has found on RateTable");
				return flag; }
		}
		else {
			BaseClass.logger.log(LogStatus.WARNING,"INTO METHOD==>fn_hasToolTip : ==>> Tool Tip is not visible");
			return flag;
		}
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static boolean fn_hasRateTable() throws IOException{
		boolean flag = false;
		if(Utility.isElementPresent(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.RateTable"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_hasRateTable : Rate Table is visible");
			WebElement Ratetable = BaseClass.getDriver().
					findElement(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.RateTable"));
			Utility.scrollToElement(Ratetable);
			Utility.highlightElementBorder(Ratetable);
			return flag=true;
		}
		else{
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_hasRateTable : Rate Table is not visible");
			return flag;
		}

	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static boolean fn_hasArticles() throws IOException{
		boolean flag=false;
		if(Utility.isElementPresent(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.Articles"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_hasArticles : Articles are visible on Mortage Page");
			WebElement articles = BaseClass.getDriver().
					findElement(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.Articles"));
			Utility.scrollToElement(articles);
			Utility.highlightElementBorder(articles);
			return flag=true;		
		}
		else{
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_hasArticles : Articles is not visible on Mortage Page");
			return flag;
		}

	}

	public static String fn_MonthlyRepayment() throws IOException{
		List<WebElement> list  = BaseClass.getDriver().findElements(By.cssSelector("td[class*='monthlyRepayment']"));
		return list.get(0).getText();

	}

	public static void fn_ChangeBorrowingAmount() throws Exception{
		if(Utility.isElementPresent(new RespositoryParser().
				getobjectLocator("HomeLoan.MortgageRate.BorrowingSlider"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ChangeBorrowingAmount : Borrowing Amount button is visible!!");
			WebElement borrowingAmt = BaseClass.getDriver().
					findElement(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.BorrowingSlider"));
			/*WebElement updatedBorrowingAmt = BaseClass.getDriver().
					findElement(new RespositoryParser().getobjectLocator("HomeLoan.MortgageRate.BorrowingAmount"));*/
			Utility.dragAnddropBy(borrowingAmt, 30);
			Utility.GoToSleep(5000);
		}


	}
	public static void fn_ClickOnPagination(String pageValue) throws Exception{

		if(pageValue.equalsIgnoreCase("100")){
			WebElement show = BaseClass.getDriver().findElement(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.PaginationFilter_100"));
			if(Utility.isElementPresent(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.PaginationFilter_100"))){
				Utility.clickAndWait(show, 5000);
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnPagination : Successfully Clicked on 100 for pagination!!");
			}
		}else if(pageValue.equalsIgnoreCase("50")){
			WebElement show = BaseClass.getDriver().findElement(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.PaginationFilter_50"));
			if(Utility.isElementPresent(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.PaginationFilter_50"))){
				Utility.clickAndWait(show, 5000);
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnPagination : Successfully Clicked on 50 for pagination!!");
			}
		}

	}
	
	public static boolean fn_Verfiy_AdvertisedRateText(String textToBeFound)throws IOException{
		boolean flag = false;
       List<WebElement> Ad_RateText = BaseClass.getDriver().findElements(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.AdvertisedRateText"));
     /*  for (WebElement webElement : Ad_RateText) {
		System.out.println("Value is : " + webElement.getText());
	}*/
       for (WebElement webElement : Ad_RateText) {
    	   Utility.GoToSleep(3000);
		if(!webElement.getText().equalsIgnoreCase(textToBeFound)){
			Utility.scrollToElement(webElement);
			Utility.highlightElementBorder(webElement);
			flag=true;
			break;
		}
	  }
       return flag;
	}
	
	/**
	 * 
	 * @param chkboxtype
	 * @throws IOException
	 */
	public static void fn_ClickOnInterestRateChkBox(String chkboxtype) throws IOException{
		
		WebElement ele=null;
		if(chkboxtype.equalsIgnoreCase("Variable")){
			ele = BaseClass.getDriver().findElement(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.InterestRate_VariableChkBox"));
			Utility.selectcheckbox(ele);
			Utility.GoToSleep(2000);
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnInterestRateChkBox : Successfully Clicked on Variable CheckBox!!");
 		 }else if(chkboxtype.equalsIgnoreCase("Fixed - 1 year")){
 			ele = BaseClass.getDriver().findElement(new RespositoryParser().
					getobjectLocator("HomeLoan.MortgageRate.InterestRate_Fixed_1YearChkBox"));
			Utility.selectcheckbox(ele);
			Utility.GoToSleep(2000);
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnInterestRateChkBox : Successfully Clicked on Fixed - 1 year CheckBox!!");
 		 }
	}
}

