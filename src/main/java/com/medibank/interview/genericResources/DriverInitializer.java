package com.medibank.interview.genericResources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;





public class DriverInitializer {

	public WebDriver getAppropriateDriver(String url) {
		WebDriver driver = null;
		try{
		if (ConfigReader.getConfigValue("browser").equalsIgnoreCase("firefox")) {
			taskkillFireFox();
			driver = new FirefoxDriver();
		} else if (ConfigReader.getConfigValue("browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./lib/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (ConfigReader.getConfigValue("browser").equalsIgnoreCase("IE")) {
			taskkillInternetExplorer();
			File file;
			if (System.getProperty("sun.arch.data.model").equals("32"))
				file = new File("./lib/IEDriverServer32/IEDriverServer.exe");
			else
				file = new File("./lib/IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();

			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			
			System.out.println("file absolute path (the path shows if 32 or 64 bit IEDriverServer) "+ file.getAbsolutePath());
			System.out.println(System.getProperty("webdriver.ie.driver"));
			
			capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capability.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			capability.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,ConfigReader.getConfigValue("url"));

			driver = new InternetExplorerDriver(capability);
		}
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        if (ConfigReader.getConfigValue("browser").equalsIgnoreCase("firefox")) {
        	driver.navigate().to(ConfigReader.getConfigValue("url"));
        }
        
		System.out.println("is the browser session id null"	+ ((RemoteWebDriver) driver).getSessionId().toString());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		}
		catch(Throwable t){
			System.out.println(t.getMessage());}
					
		return driver;
	}
	
	
	public static void taskkillInternetExplorer() {
		Utilities.execDosCommand("cmd /c taskkill /f /im iexplore.exe");
		Utilities.execDosCommand("cmd /c taskkill /f /im mshta.exe");
		Utilities.execDosCommand("cmd /c taskkill /f /im IEDriverServer.exe");
	}

	public static void taskkillFireFox() {
		Utilities.execDosCommand("cmd /c taskkill /f /im firefox.exe"); 
	}
	
}
