package com.ratecity.homeloan.automationFramework.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.ratecity.homeloan.automationFramework.utilities.BaseClass;


public class RateBusterStandardVariable {
	
	
	
	public static boolean fn_verifytitle(){
		
		if(BaseClass.getDriver().getTitle().equalsIgnoreCase("Reduce Home Loans Rate Buster Standard Variable Review | RateCity.com.au")){
			return true;
		}
		else
			return false;
	}
	
	public  static boolean areElementsPresent( By by) {
		try {
			BaseClass.getDriver().findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	
	public static boolean isElementEnabled(WebElement element) {
		boolean isEnabled = false;
		try {	
			//ObjectManager.getLogger().info("Checking if Element is enabled");
			isEnabled = element.isEnabled();
			//ObjectManager.getLogger().info("Element is enabled " + element);
		} catch (Exception e) {
		//	ObjectManager.getLogger().error("Some thing wrong with element " + e.getMessage());
		}
		return isEnabled;
	}
	
	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) BaseClass.getDriver();
		jse.executeScript("scroll(0, 250)");
	}
	
	public static void clickAndWait( WebElement element,int iTimeOut) throws Exception {
		
		clickElement(element);
		Thread.sleep(iTimeOut);
		
	}
	
	public static String getText(WebElement element) {
		return element.getText();
	}
	
	/**
	 *
	 * @param element
	 * @throws Exception
	 */
	
	public static void clickElement( WebElement element) throws Exception {
        try{
        	element.click();	
        }catch(ElementNotVisibleException ne){
        	Thread.sleep(1000);
        	try{
        		//Thread.sleep(10000);
        		element.click();	
        	}catch(ElementNotVisibleException e){
        		element.click();
        	}
        	
        	
        }catch(StaleElementReferenceException se){
        	Thread.sleep(10000);
        	try{
        		//Thread.sleep(10000);
        		element.click();	
        	}catch(ElementNotVisibleException e){
        		element.click();
        	}
        }catch(NoSuchElementException ne){
        	Thread.sleep(10000);
        	try{
        		//Thread.sleep(10000);
        		element.click();	
        	}catch(ElementNotVisibleException e){
        		element.click();
        	}
        }
	}
}
