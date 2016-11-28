package com.ratecity.homeloan.automationFramework.utilities;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class VerifyUrlUtils {

	static final Map<String , String> PopularHomeLoansURL = new HashMap<String , String>() {/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		{
			put("Fixed rate home loans",    "Fixed Rate Home Loan Rates from");
			put("Variable rate home loans", "Variable rate home loans");
			put("Low interest home loans", "Low interest home loans"); 
			put("No deposit home loans", "No Deposit Home Loan Rates"); 
			put("Construction loans", "Construction loans"); 
			put("Owner builder loans", "Owner builder"); 
			put("Under 4% club", "Under 4 club loans"); 
			put("LOW DOC Home Loans", "Low Doc Home Loans"); 
			put("Low Interest Mortgage", "Lowest Home Loan Rates"); 
			put("Best Mortgage", "Best Home Loans"); 
			put("Home Loan Ratings", " Home Loan Rates"); 
			put("First Mortgage", "First home loan rates"); 
			put("Compare Home Loans", "Home Loan Comparison"); 
			put("Mortgage Rates", "mortgage rates from"); 
			put("1 year Fixed", "1 year fixed mortgages rates"); 
			put("3 year Fixed", "3 year fixed mortgages rates"); 
			put("SMSF Loans", "Self managed super fund loans"); 
			put("1 Year Fxd Investment Property", "1 year fixed investment mortgages"); 
			put("3 Year Fxd Investment Property", "3 year fixed investment mortgages"); 
			put("Home Equity", "Compare home equity rates"); 
			put("Deals", "Compare home loan deals"); 
			put("Product Comparison", "Compare home loan product"); 
			put("Banks variable rate mortgages", "Compare bank variable home loans"); 
			put("Search", "Compare 3000+ home loans"); 
		}};

		static final Map<String , String> ArticlesLinks = new HashMap<String , String>() {/**
		 * 
		 */
			private static final long serialVersionUID = 1L;

			{
				put("mortgage calculator","Home Loan Calculator");
				put("SMSF loans", "Self managed super fund loans");
				put("equity loans", "home equity rates"); 
				put("applying for your first home loan", "Are you buying your first home?"); 
				put("Read the Home Loans Guide", "Home Loans Guide"); 

			}};
			static final Map<String , String> CompanyProductsLinks = new HashMap<String , String>() {/**
			 * 
			 */
				private static final long serialVersionUID = 1L;

				{
					put("PROMOTEDMortgage Saver Home Loan","Mortgage Saver Home Loan");
					put("Basic Home Loan (LVR < 80%)", "Basic Home Loan");
					put("Value Offer - 20% Deposit Minimum", "Value Offer - 20% Deposit Minimum"); 
					put("Special Low Variable Rate Home Loan", "Special Low Variable Rate Home Loan"); 
					put("Breathe Easy Home Loan (LVR < 80%)", "Breathe Easy Home Loan"); 
					put("Kick Starter Home Loan", "Home Loans Kick Starter Home Loan");

				}};


				public static boolean fn_VerifyTitle_PopularHomeLoans(String urlText){

					System.out.println("URL TEXT : "+urlText);
					if(BaseClass.getDriver().getTitle().contains(PopularHomeLoansURL.get(urlText))){
						Utility.GoToSleep(1000);
						Utility.goBack();
						BaseClass.logger.log(LogStatus.INFO, "INTO METHOD==>fn_VerifyTitle_PopularHomeLoans : "+urlText +" Page Loaded Succesfully!!");
						return true;
					}else{
						BaseClass.logger.log(LogStatus.FAIL, "INTO METHOD==>fn_VerifyTitle_PopularHomeLoans : "+urlText +" Page is not Loaded Succesfully!!");
						Assert.assertTrue(false,urlText +" Page is not Loaded Succesfully!!");
						return false;
					}
				}
				public static boolean fn_VerifyTitle_ArticlesLinks(String urlText){

					if(BaseClass.getDriver().getTitle().contains(ArticlesLinks.get(urlText))){
						Utility.GoToSleep(1000);
						Utility.goBack();
						BaseClass.logger.log(LogStatus.INFO, "INTO METHOD==>fn_VerifyTitle_ArticlesLinks : "+urlText +" Page Loaded Succesfully!!");
						return true;
					}else{
						BaseClass.logger.log(LogStatus.FAIL, "INTO METHOD==>fn_VerifyTitle_ArticlesLinks : "+urlText +" Page is not Loaded Succesfully!!");
						Assert.assertTrue(false,urlText +" Page is not Loaded Succesfully!!");
						return false;
					}
				}
				
				public static boolean fn_VerifyTitle_CompanyProductsLinks(String urlText){

					if(BaseClass.getDriver().getTitle().contains(CompanyProductsLinks.get(urlText))){
						Utility.GoToSleep(1000);
						Utility.goBack();
						BaseClass.logger.log(LogStatus.INFO, "INTO METHOD==>fn_VerifyTitle_CompanyProductsLinks : "+urlText +" Page Loaded Succesfully!!");
						return true;
					}else{
						BaseClass.logger.log(LogStatus.FAIL, "INTO METHOD==>fn_VerifyTitle_CompanyProductsLinks : "+urlText +" Page is not Loaded Succesfully!!");
						Assert.assertTrue(false,urlText +" Page is not Loaded Succesfully!!");
						return false;
					}
				}

}

