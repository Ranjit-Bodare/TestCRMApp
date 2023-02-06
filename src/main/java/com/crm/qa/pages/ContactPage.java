package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement ContactsLabel;

	@FindBy(xpath = "//a[contains(text(),'test2  test2')]//parent::td[@class]//preceding-sibling::td[@class]//input[@name='id']")
	WebElement Checkboxby;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@name='position']")
	WebElement Position;
	
	@FindBy(xpath="//button[.='Save']")
	WebElement SaveButton;

	//Initialization
		public ContactPage() {
			PageFactory.initElements(driver, this);
		}
		
    //Verify contacts Label
		public boolean VerifyContactsLabel() {
			return ContactsLabel.isDisplayed();
		}
	

		public void selectContactsByName(String name) throws InterruptedException{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("arguments[0].click();", contact);
			
			Thread.sleep(3000);
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			  js1.executeScript("document.getElementById('//a[contains(text(),'test2  test2')]//parent::td//preceding-sibling::td//input[@name='id']').click();");
			
		}
		
		public void CreateNewContact(String ftname, String ltname, String ps) {
	
			Firstname.sendKeys(ftname);
			Lastname.sendKeys(ltname);
			Lastname.sendKeys(ps);
			SaveButton.click();
		}
	

}
