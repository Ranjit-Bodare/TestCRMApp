package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
             
	  // Page factory - OR
	@FindBy(xpath = "//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement signupbtn;
	
	//Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions : 
	public String validateLoginpage() {
		System.out.println(driver.getTitle());
		return driver.getTitle();	
	}
	
	public HomePage login(String userid, String passid) {
		username.sendKeys(userid);
		password.sendKeys(passid);
		loginbtn.click();
		return new HomePage();
	}

}
