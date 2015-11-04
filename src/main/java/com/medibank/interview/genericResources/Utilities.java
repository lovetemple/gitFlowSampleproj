package com.medibank.interview.genericResources;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


public class Utilities {
 	
	public static void copyFile(String sourcePath, String destpath) {
		Reporter.log("Copying file from : " + sourcePath + "  to  " + destpath, true);
		
		File source = new File(sourcePath);
		File dest = new File(destpath);
		try {
			FileUtils.copyFile(source, dest);
			//Files.copy(source.toPath(), dest.toPath());
    		System.out.println("copying file successful!");
		} catch (IOException e) {
    		System.out.println("copying file failed!");
			e.printStackTrace();
		}
	}

 	
	public static void archiveFile(String sourcePath, String archivePath) {	
		Reporter.log("Archiving file from : " + sourcePath + "  to  " + archivePath, true);

		File source = new File(sourcePath);
		File archive = new File(archivePath);
		
		//delete the file if it already exists in archive directory 
		if(fileExists(archivePath)) {
			deleteFile(archivePath);
		}
		
		try{
    	   if(source.renameTo(archive)){
    		System.out.println("archiving file successful!");
    	   }else{
    		System.out.println("archiving file failed!");
    	   }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	
 	public static void sleepInMinutes(int min)
	{
		try {Thread.sleep(min*60*1000);}catch(InterruptedException e){}
	}
	
	public static void execDosCommand(String cmd) {
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			System.out.println("exec cmd " + cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String resource(String filename) {
		return StringUtils.join(new String[] { System.getProperty("user.dir"),
				"src", "test", "resources", filename }, File.separator);
	}

	public static String screenshotDirectory() {
		String dir = StringUtils.join(
				new String[] { System.getProperty("user.dir"), "screenshots" },
				File.separator);

		File dirFile = new File(dir);

		if (!new File(dir).exists()) {
			dirFile.mkdir();
		}
		return dir;
	}

	public static void setClipboard(String text) {
		StringSelection ss = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	public static String removeLastChar(String text) {
		return text.substring(0, text.length() - 1);
	}

	public static void taskkillInternetExplorer() {
		Utilities.execDosCommand("cmd /c taskkill /f /im iexplore.exe");
		Utilities.execDosCommand("cmd /c taskkill /f /im mshta.exe");
		Utilities.execDosCommand("cmd /c taskkill /f /im IEDriverServer.exe");
	}
	
	public static void WriteToFile(String content) {
		try {
 			File file = new File(System.getProperty("user.dir")+"\\screenshots\\RefData.txt");
 			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
 		//	System.out.println("Done");
 		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void deleteFile(String filePath) {	
    	try{
    		File file = new File(filePath);
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation failed.");
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    }
	
    public static void deleteAllFiles(String directory) {
    	try{
    		File file = new File(directory);
    		FileUtils.cleanDirectory(file);
    	} catch(IOException e){
    		e.printStackTrace();
    	}
    }
    

	public static boolean fileExists (String filePath){
		  File f = new File(filePath);
	 	  if(f.exists()){
			  System.out.println("File exists: " + filePath);
			  return true;
		  }else{
			  System.out.println("File not found! " + filePath);
			  return false;
		  }
 	}
  
	public static String videoRecordingDirectory() {
		String dir = StringUtils.join(
				new String[] { System.getProperty("user.dir"), "videoRec" },
				File.separator);

		File dirFile = new File(dir);

		if (!new File(dir).exists()) {
			dirFile.mkdir();
		}
		return dir;
	}
	
	public static void dumpEnvironmentVars() {
		Map<String, ?> m = System.getenv();
		List<String> keys = new ArrayList<String>(m.keySet());
		Collections.sort(keys);
		for (String k : keys) {
			System.out.println(k + " : " + m.get(k));
		}
	}
	 
	public static String randomIdentifier() {
		final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		final java.util.Random rand = new java.util.Random();
		// consider using a Map<String,Boolean> to say whether the identifier is
		// being used or not
		final Set<String> identifiers = new HashSet<String>();

		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++)
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			if (identifiers.contains(builder.toString()))
				builder = new StringBuilder();
		}
		return builder.toString();
	}
	

	public static String randomNumberGenerator() {
		int max = 999999999; // e.g. 714053349  (9 digits)
		Random rand = new Random();
		int min = 0;
		int randomNum = rand.nextInt(max - min + 1) + min;
		return Integer.toString(randomNum);
	}

	public static String removeComma(String str){
		String text;
		if(str.contains(","))
			text = str.replace(",", "");
		else
			text=str;
		return text;
 	}
	
	// returns current date and time
	public static String now(String dateFormat) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    return sdf.format(cal.getTime());

	}

	// returns current date and time with the specified addtion of days
		public static String now(String dateFormat,int increment) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    cal.add( Calendar.DATE, increment );
	    return sdf.format(cal.getTime());
	} 
	
}
