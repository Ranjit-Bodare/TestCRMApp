package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	  
	public static WebDriver driver;
	public static Properties prop;
	
	
	//Testbase constructor : to give the path of the configration which are we using
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream("C:\\SeleniumWebDriver\\FreeCRMAuto\\src\\main\\java\\"
					+ "com\\crm\\qa\\config\\config.properties");
			prop.load(ip);	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
   }
	
	
	//Initialize the browser 
	@SuppressWarnings("deprecation")
	public static void initialization() {
		String Browsername = prop.getProperty("browser");
		if(Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver =new ChromeDriver();
		}
		else if(Browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			 driver =new FirefoxDriver();
		}
		
		//EventFiringWebDriver class
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		WebEventListener eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	
		
		//maximizing window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(prop.getProperty("url"));
		
		}
		
	}
 	
	
	
	
	
	


