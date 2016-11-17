package com.ratecity.homeloan.automationFramework.pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.ratecity.homeloan.automationFramework.utilities.RespositoryParser;
import com.relevantcodes.extentreports.LogStatus;


public class HomeLoanLandingpage {
	 
	
	
	
	public static boolean fn_verifytitle(){
		
		if(BaseClass.getDriver().getTitle().equalsIgnoreCase("Home Loan Comparison | Compare Mortgages | RateCity")){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 * @throws IOException
	 */
	
	public static boolean fn_CheckIfAds(String value) throws IOException{
		boolean visibility=false;
		WebElement ads  = BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator(value));
		Utility.scrollToElement(ads);
		try{
			if(ads.isDisplayed()){
				Utility.highlightElementBorder(ads);
				BaseClass.logger.log(LogStatus.INFO, value +"is highlighted Successfully!!!!");
				visibility = true;
			}
		}catch(ElementNotVisibleException e){
			System.out.println("Element not visible"+e.getMessage());
			
		}catch (Exception e) {
			System.out.println("Element not visible"+e.getMessage());
		}
		
		return visibility;
		
	}
	
	/**
	 * 
	 * @param container
	 * @param value
	 * @return
	 * @throws IOException
	 */
	
	public static boolean fn_CheckIfRateTableHas6Records(String container,String value) throws IOException{
		WebElement rateRecordContainer = BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator(container));
		List<WebElement> rows = BaseClass.getDriver().findElements(new RespositoryParser().getobjectLocator(value));
		try{
			if(rows.size()==6){
				Utility.scrollToElement(rateRecordContainer);
				BaseClass.logger.log(LogStatus.INFO," :Successfull scroll till element visible");
				Utility.highlightElementBorder(rateRecordContainer);
				BaseClass.logger.log(LogStatus.INFO, value+" :is highlighted Successfully!!!!");
				//System.out.println("Size********************"+rows.size());
				return true;
				
			}
		}catch(NoSuchElementException e){
			BaseClass.logger.log(LogStatus.WARNING, e.getMessage());
			
		}
		return false;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 * @throws IOException
	 */
	
	public static boolean fn_CheckIfhasArticles(String value) throws IOException{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		Utility.GoToSleep(500);
		WebElement highlightedArticle = BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator("HomeLoan.articles"));
		List<WebElement> allArticles = BaseClass.getDriver().findElements(new RespositoryParser().getobjectLocator("HomeLoan.articles"));
		try{
			if(allArticles.size()>0){				
				Utility.scrollToElement(highlightedArticle);
				BaseClass.logger.log(LogStatus.INFO,"From Method : "+name+" : Successfull scroll till element visible");
				Utility.highlightElementBorder(highlightedArticle);
				BaseClass.logger.log(LogStatus.INFO,"From Method : "+name+" : is highlighted Successfully!!!!");
				return true;
			}
		}catch (ElementNotFoundException e) {
			BaseClass.logger.log(LogStatus.WARNING, e.getMessage());
			
			}			
		return false;
	}
	
	
}
