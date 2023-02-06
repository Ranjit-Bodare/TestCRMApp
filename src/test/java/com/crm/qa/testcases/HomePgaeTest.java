package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePgaeTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	ContactPage  contactPage;
	
	//constructor of HomepageTest
     public HomePgaeTest() {
    	 super();
     }
     
     @BeforeMethod
	  public void setup() {
		  initialization();
		  contactPage =new ContactPage();
		   loginPage = new LoginPage(); 
		homepage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
     
     
     @Test (priority = 1)
     public void verifyHomepageTitle() {
    	 String HomepageTitle = homepage.verifyHomepageTitle();
    	 System.out.println(HomepageTitle);
    	 Assert.assertEquals(HomepageTitle, "Cogmento CRM324");
     }
     
    @Test (priority = 2)
    public void VerifytheUser() {
    	Assert.assertTrue(homepage.verifytheUser());	
     }
     
     @Test (priority = 3)
     public void verifycontactLinkTest() {
    	 contactPage =homepage.ClickOnContactsLInk();
     }
      
  
     @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
	  

}
