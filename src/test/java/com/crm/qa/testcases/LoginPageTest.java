package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	    
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	  @BeforeMethod
	  public void setup() {
		  
		  initialization();
		   loginPage = new LoginPage(); 
	  }
	  
	  
	  @Test(priority = 1)
	  public void LoginPageTitiletest() {
		  String title = loginPage.validateLoginpage();
		  Assert.assertEquals(title, "Cogmento CRM");
	  }
	  
	  @Test(priority = 2)
	  public void LoginTest() {
		  homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
}
