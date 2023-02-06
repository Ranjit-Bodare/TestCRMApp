package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;



public class CRMDataDrivenApproarch extends TestBase{
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@name='position']")
	WebElement Position;
	
	@FindBy(xpath="//button[.='Save']")
	WebElement SaveButton;
	
	 public void datadriven() throws Exception {
	Flib flib = new Flib();
	    int rc = flib.getRowCount("./data/CRMCreateContact.xlsx", "Contact");
	    for(int r=0; r<=rc; r++)
	    {
	     String Firstname = flib.readExcelData("./data/TestDataAct.xlsx","invalidcreds", r,0);
	     String Lastname = flib.readExcelData("./data/TestDataAct.xlsx","invalidcreds", r,1);
	     String Position = flib.readExcelData("./data/TestDataAct.xlsx","invalidcreds", r,1);
	     System.out.println(r);
	     
	     driver.findElement(By.name("username")).sendKeys(Firstname);
	     driver.findElement(By.name("password")).sendKeys( Lastname);
	     driver.findElement(By.name("password")).sendKeys( Position);
	     Thread.sleep(3000);
	     
	    }
	    Thread.sleep(3000);
	    driver.quit();
	 }

}
