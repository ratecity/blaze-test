package com.ratecity.homeloan.automationFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.relevantcodes.extentreports.LogStatus;


public class Utility {




	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 */
	public static String CaptureScreen(WebDriver driver, String screenshotName)
	{
		BaseClass.logger.log(LogStatus.INFO,"INTO Method ==> CaptureScreenShot and Return path");
		TakesScreenshot oScn = (TakesScreenshot) BaseClass.getDriver();
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+File.separator+"ScreenShots"+File.separator+screenshotName+".jpeg";
		File oDest = new File(dest);
		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {System.out.println(e.getMessage());}
		return dest;
	}

	/**
	 * 
	 * @param parameter
	 * @return
	 */

	public static String fn_ReaddataFronPropFile(String parameter){

		File file = new File("config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(parameter);
		return value;
	}

	/**
	 * 
	 * @param element
	 */

	public static void highlightElementBorder(WebElement element) {

		try {
			if (true) {
				for (int i = 0; i < 1; i++) {
					JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
					js.executeScript(
							"arguments[0].setAttribute('style', arguments[1]);",
							element, "color: yellow; border: 10px solid red;");
					// + "border: 4px solid red;");
					Thread.sleep(1200);
					js.executeScript(
							"arguments[0].setAttribute('style', arguments[1]);",
							element, "");
				}
			}
			Thread.sleep(3000);

		} catch (Exception e) {
			//ObjectManager.getLogger().error("Error Occured highlighting Border " + element);
		}
	}

	/**
	 * 
	 * @param element
	 */
	public static void scrollToElement( WebElement element) {
		//base.getLogger().info("Scrolling to Element");
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@SuppressWarnings("unused")
	public static boolean isElementPresent( By by) {
		WebElement element;
		try {
			element =BaseClass.getDriver().findElement(by);

			return true;
		} catch (NoSuchElementException e) {

			return false;
		}
	}


	/**
	 * 
	 * @param by
	 * @return
	 */
	public  static boolean isElementPresentAndDisplay( By by) {
		boolean flag=false;
		try {
			BaseClass.getDriver().findElement(by).isDisplayed();
			BaseClass.logger.log(LogStatus.INFO, "*********Element Is found & displayed");flag=true;
			return flag;
		} catch (NoSuchElementException e) {
			GoToSleep(2000);
			BaseClass.logger.log(LogStatus.INFO, "**Going for sleep & wait sometime for the element to be displayed");
			BaseClass.getDriver().findElement(by).isDisplayed();
		}
		BaseClass.logger.log(LogStatus.INFO, "**Element not found after given time**");
		return false;
	}

	/**
	 * 
	 * @param TimeInMillis
	 */
	public static void GoToSleep(int TimeInMillis) {
		try {
			Thread.sleep(TimeInMillis);
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.logger.log(LogStatus.FAIL, e.getMessage());
		}
	}

	/**
	 * 
	 * @param locator
	 * @throws IOException
	 */
	public static void selectcheckbox(String locator) throws IOException {
		try {
			if (!BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator(locator))
					.isSelected()) {
				BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator(locator)).click();
				BaseClass.logger.log(LogStatus.INFO,"*****Checkbox is selected now*****");
			} else {
				BaseClass.logger.log(LogStatus.INFO,"*****Checkbox is already selected*****");
			}
		} catch (ElementNotVisibleException env) {
			GoToSleep(1000);
			if (!BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator(locator))
					.isSelected())
				BaseClass.getDriver().findElement(new RespositoryParser().getobjectLocator(locator)).click();
			env.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****Element is present in DOM but not visible on the page*****"
					+ env.getMessage());
		} catch (NoSuchElementException ne) {
			ne.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****The element could not be located on the page.*****"
					+ ne.getMessage());
		} catch (StaleElementReferenceException se) {
			se.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****Either the element has been deleted entirely or the element is no longer attached to DOM.*****"
					+ se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****Error in selecting a checkbox!!! *****"
					+ e.getMessage());
		}
	}

	/**
	 * 
	 * @param we
	 */
	public static void selectcheckbox(WebElement we) {
		try {
			if (!we.isSelected()) {
				we.click();
				BaseClass.logger.log(LogStatus.INFO,"*****Checkbox is selected now*****");
			} else {
				BaseClass.logger.log(LogStatus.INFO,"*****Checkbox is already selected*****");
			}
		} catch (ElementNotVisibleException env) {
			GoToSleep(1000);
			if (!we.isSelected())
				we.click();
			env.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****Element is present in DOM but not visible on the page*****"
					+ env.getMessage());
		} catch (NoSuchElementException ne) {
			ne.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****The element could not be located on the page.*****"
					+ ne.getMessage());
		} catch (StaleElementReferenceException se) {
			se.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****Either the element has been deleted entirely or the element is no longer attached to DOM.*****"
					+ se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.logger.log(LogStatus.INFO,"*****Error in selecting a checkbox!!! *****"
					+ e.getMessage());
		}
	}

	/**
	 * 
	 * @param element
	 * @param iTimeOut
	 * @throws Exception
	 */
	public static void clickAndWait( WebElement element,int iTimeOut) throws Exception {
		try{
			BaseClass.logger.log(LogStatus.INFO,"INTO METHOD==>ClickAndWait");
			clickElement(element);
			GoToSleep(iTimeOut);

		}catch(Exception e){
			BaseClass.logger.log(LogStatus.WARNING,"INTO METHOD==>ClickAndWait : Not able to click on Element");
		}


	}


	/**
	 * 
	 * @param element
	 * @return
	 */
	public static String getText(WebElement element) {
		return element.getText();
	}


	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public static boolean clickElement( WebElement element) throws Exception {
		boolean flag = false;
		try{
			element.click();flag=true;
			BaseClass.logger.log(LogStatus.INFO, "**INTO Method ==> ClickElement : Element clicked successfully!**");
			return flag;
		}catch(ElementNotVisibleException ne){
			BaseClass.logger.log(LogStatus.INFO, "**INTO Method ==> ClickElement : Waiting for element to be visible**");
			GoToSleep(2000);
			element.click();flag=true;
			BaseClass.logger.log(LogStatus.INFO, "**INTO Method ==> ClickElement : Element clicked successfully after waiting**");
			return flag;
		}
		catch(StaleElementReferenceException se){
			BaseClass.logger.log(LogStatus.INFO, "**INTO Method ==> ClickElement : Waiting for element to be visible after Stale Reference **");
			GoToSleep(2000);
			try{
				//Thread.sleep(10000);
				element.click();flag=true;
				return flag;
			}catch(ElementNotVisibleException e){
				element.click();
			}
		}catch(NoSuchElementException ne){
			BaseClass.logger.log(LogStatus.INFO, "**INTO Method ==> ClickElement : Waiting for element In No Such element exception**");
			GoToSleep(2000);;
			try{
				//Thread.sleep(10000);
				element.click();flag=true;
				return flag;
			}catch(ElementNotVisibleException e){
				element.click();
			}
		}
		return flag;
	}
}
