package com.medibank.interview.genericResources;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

	
	private static Properties properties = new Properties();

	static {
		try {
			System.out.println("Starting to load properties: "	+ System.getProperty("user.dir"));

			System.out.println("TestConfig loads properties");
			
			// properties.load(new FileInputStream("default.properties"));
			properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config.properties"));

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getConfigValue(String key){
			
		return(properties.getProperty(key));
		
		
	}
}
