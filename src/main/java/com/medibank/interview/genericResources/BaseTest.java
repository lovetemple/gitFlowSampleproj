package com.medibank.interview.genericResources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	
		  public WebDriver driver;
		 
		  public BaseTest() throws IOException {
			  DriverInitializer di= new DriverInitializer();
			  this.driver= di.getAppropriateDriver(ConfigReader.getConfigValue("url"));
		     
		  }
		 
		  
		public WebDriver getDriver(){
			return driver;
			
			
		}
}
