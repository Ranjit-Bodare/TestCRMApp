package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Flib;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	HomePage homepage;
	ContactPage contactPage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	String sheet = "Contact";
	
	public ContactPageTest() {
		super();	
	}
	
	 @BeforeMethod
	  public void setup() {
		  initialization();
		  contactPage =new ContactPage();
		  testUtil=new TestUtil();
		   loginPage = new LoginPage(); 
		homepage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	  }
    
	 @Test(priority = 1)
	 public void VerifyContactsLabel() {
		Assert.assertTrue(contactPage.VerifyContactsLabel(), "Contacts");
	 }
	 
//	 @Test(priority = 2)
//	 public void SelectContactTest() throws InterruptedException {
//		 contactPage.selectContactsByName("test2  test2");
//	 }
//	 
	 @DataProvider(name = "getDatafromExcel")
	 public Object [][] getDatafromExcel() throws Exception{
		Object[][] getdata = TestUtil.getData();
	 return getdata;
		 
	 }
	 
	 @Test(priority = 2, dataProvider = "getDatafromExcel")
	 public void ValidateCreateContact(String Firstname, String Lastname, String Position) {
		 homepage.ClickOnNewContact();
		 //contactPage.CreateNewContact("XYZ", "PQR", "QA");
		 contactPage.CreateNewContact(Firstname, Lastname, Position);
	 }
	 
	 
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
	  
	

}
