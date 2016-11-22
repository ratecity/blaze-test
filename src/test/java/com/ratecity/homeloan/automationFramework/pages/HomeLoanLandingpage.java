package com.ratecity.homeloan.automationFramework.pages;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.ratecity.homeloan.automationFramework.utilities.BaseClass;
import com.ratecity.homeloan.automationFramework.utilities.Utility;
import com.ratecity.homeloan.automationFramework.utilities.RespositoryParser;
import com.relevantcodes.extentreports.LogStatus;

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;


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

	public static void fn_CheckBrowseMoreLink()throws Exception{
		WebElement browsemore = BaseClass.getDriver().findElement(new RespositoryParser().
				getobjectLocator("HomeLoan.BrowseMore"));
		if(Utility.isLinkBroken(new URL(browsemore.getAttribute("href")))){
			BaseClass.logger.log(LogStatus.INFO, "INTO METHOD==>fn_CheckBrowseMoreLink : "+
					browsemore.getAttribute("href")+" is landed Successfully!!");
			Utility.GoToSleep(1000);
			browsemore.click();
			BaseClass.getDriver().navigate().back();

		}
		else{
			BaseClass.logger.log(LogStatus.ERROR, "INTO METHOD==>fn_HomeLoanTopLinks : "+
					browsemore.getAttribute("href")+" is not working");

		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void fn_HomeLoanTopLinks() throws Exception{
		List<WebElement> homeloanType =null;
		homeloanType = BaseClass.getDriver().findElements(new RespositoryParser().
				getobjectLocator("HomeLoan.LoanTypes"));
		for(int i=0;i<homeloanType.size()-1;i++){
			if(!Utility.isLinkBroken(new URL(homeloanType.get(i).getAttribute("href")))){
				BaseClass.logger.log(LogStatus.ERROR, "INTO METHOD==>fn_HomeLoanTopLinks : "+homeloanType.get(i).getAttribute("href")+" is not working");
				break;
			}
			else{ 
				BaseClass.logger.log(LogStatus.INFO, "INTO METHOD==>fn_HomeLoanTopLinks : "+homeloanType.get(i).getAttribute("href")+" is landed Successfully!!");
				homeloanType.get(i).click();
				Utility.GoToSleep(2000);
				BaseClass.getDriver().navigate().back();
			}
			homeloanType = BaseClass.getDriver().findElements(new RespositoryParser().
					getobjectLocator("HomeLoan.LoanTypes"));
		}
	}

	public static int fn_CountvaluesOnComparebar() throws IOException{

		List<WebElement> items =  BaseClass.getDriver().findElements(new RespositoryParser().
				getobjectLocator("HomeLoan.CompareBarValues"));
		if(items.size()!=0)
			return items.size()-1;
		return items.size();

	}

	public static boolean fn_isCompareButtonVisible() throws IOException{
		boolean flag=false;
		try{
			if(Utility.isElementPresentAndDisplay(new RespositoryParser()
					.getobjectLocator("HomeLoan.MortgageRate.CompareButton"))){
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>ClickOnCompareButton : Compare button is visible");
				return flag=true;
			}
		}catch(ElementNotVisibleException env){
			Utility.GoToSleep(1500);
			if(Utility.isElementPresentAndDisplay(new RespositoryParser()
					.getobjectLocator("HomeLoan.MortgageRate.CompareButton"))){
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>ClickOnCompareButton : Compare button is visible");   
			}
			BaseClass.logger.log(LogStatus.INFO,"*****Element is present in DOM but not visible on the page*****"
					+ env.getMessage());
		}
		return flag;
	}

	public static boolean fn_isClearButtonvisible()throws IOException{
		boolean flag=false;
		try{
			if(Utility.isElementPresentAndDisplay(new RespositoryParser()
					.getobjectLocator("HomeLoan.ClearButton"))){
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_isClearButtonvisible : Clear button is visible");
				return flag=true;
			}
			return flag;
		}catch(ElementNotVisibleException env){
			Utility.GoToSleep(1500);
			if(Utility.isElementPresentAndDisplay(new RespositoryParser()
					.getobjectLocator("HomeLoan.ClearButton"))){
				BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_isClearButtonvisible : Clear button is visible");
			}
			BaseClass.logger.log(LogStatus.INFO,"*****Element is present in DOM but not visible on the page*****"
					+ env.getMessage()); 
		}
		return flag;
	}

	public static void fn_ClickOnClearButton() throws Exception{
		if(Utility.isElementPresentAndDisplay(new RespositoryParser()
				.getobjectLocator("HomeLoan.ClearButton"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnClearButton : Clear button is visible");
			WebElement clearbutton = BaseClass.getDriver().findElement(new RespositoryParser()
					.getobjectLocator("HomeLoan.ClearButton"));
			Utility.clickAndWait(clearbutton, 1000);
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnClearButton : Clear button is clicked Successfully!!!");
		}
		else{
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickOnClearButton : Clear button is not clicked ");
		}
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	public static void fn_HomeLoanNews() throws Exception{
		List<WebElement> homeloanNews =null;
		List<WebElement> homeloanNewsBlocks =null;
		homeloanNews = BaseClass.getDriver().findElements(new RespositoryParser().
				getobjectLocator("HomeLoan.News"));
		homeloanNewsBlocks = BaseClass.getDriver().findElements(new RespositoryParser().
				getobjectLocator("HomeLoan.News.Blocks"));

		for(int i=0;i<homeloanNews.size();i++){
			if(!Utility.isLinkBroken(new URL(homeloanNews.get(i).getAttribute("href")))){
				BaseClass.logger.log(LogStatus.ERROR, "INTO METHOD==>fn_HomeLoanTopLinks : "+homeloanNews.get(i).getAttribute("href")+" is not working");
				break;
			}
			else{ 
				BaseClass.logger.log(LogStatus.INFO, "INTO METHOD==>fn_HomeLoanTopLinks : "+homeloanNews.get(i).getAttribute("href")+" is landed Successfully!!");
				Utility.scrollToElement(homeloanNewsBlocks.get(i)); 
				//Utility.GoToSleep(2000);
				Utility.highlightElementBorder(homeloanNewsBlocks.get(i));
				homeloanNewsBlocks.get(i).click();
				Utility.GoToSleep(2000);
				BaseClass.getDriver().navigate().back();
			}
			homeloanNews = BaseClass.getDriver().findElements(new RespositoryParser().
					getobjectLocator("HomeLoan.News"));
			homeloanNewsBlocks = BaseClass.getDriver().findElements(new RespositoryParser().
					getobjectLocator("HomeLoan.News.Blocks"));
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void fn_ClickonMoreHomeLoanNews() throws Exception{
		if(Utility.isElementPresentAndDisplay(new RespositoryParser()
				.getobjectLocator("HomeLoan.MoreNews"))){
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickonMoreHomeLoanNews :"
					+ " More News Button is visible");
			WebElement moreNewsButton = BaseClass.getDriver().findElement(new RespositoryParser()
					.getobjectLocator("HomeLoan.MoreNews"));
			Utility.clickAndWait(moreNewsButton, 1000);
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickonMoreHomeLoanNews : "
					+ "More News Button is clicked Successfully!!");
			BaseClass.getDriver().navigate().back();
		}else{
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_ClickonMoreHomeLoanNews : More Home loan news is not visible!!");  
		}
	}

	/**
	 * 
	 * 
	 */
	public static void fn_HomeLoanTools(){
		List<WebElement> homeLoanTools=null;
		try {
			homeLoanTools = BaseClass.getDriver().findElements(new RespositoryParser()
					.getobjectLocator("HomeLoan.Tools"));
			for (int i=0;i<homeLoanTools.size();i++) {
				if (homeLoanTools.get(i) != null) {
					String url = homeLoanTools.get(i).getAttribute("href");
					if (url != null && !url.contains("#")) {
						if(Utility.fn_VerifyURLStatus(url)){
							homeLoanTools.get(i).click();
							Utility.GoToSleep(1000);
							BaseClass.getDriver().navigate().back();
							homeLoanTools = BaseClass.getDriver().findElements(new RespositoryParser()
									.getobjectLocator("HomeLoan.Tools"));
							BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_HomeLoanTools :"
									+homeLoanTools.get(i).getText()+" page is displayed successfully!!"); 
						}else{
							BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_HomeLoanTools :"
									+ homeLoanTools.get(i).getText()+ " Link is not working!!"); 
						}
					} else {
						BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>fn_HomeLoanTools :"
								+homeLoanTools.get(i).getText()+ " Contains #,So links displayed on same page!!");
						Utility.scrollToElement(homeLoanTools.get(i));
						if(homeLoanTools.get(i).getText().equalsIgnoreCase("Contact a broker")){
							homeLoanTools.get(i).click();
							String windowHandle = BaseClass.getDriver().getWindowHandle();
							BaseClass.getDriver().switchTo().window(windowHandle);
							Utility.GoToSleep(1500);
							//BaseClass.getDriver().findElement(By.name("firstName")).sendKeys("I M here");
							BaseClass.getDriver().findElement(By.xpath("//button[text()='Close']")).click();
							//Utility.GoToSleep(1000);
							BaseClass.getDriver().switchTo().defaultContent();
						}
						else{
					     	homeLoanTools.get(i).click();
						    Utility.GoToSleep(1000);
						    homeLoanTools.get(i).click();
						}
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
