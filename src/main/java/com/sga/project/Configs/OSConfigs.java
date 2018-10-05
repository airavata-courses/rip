package com.sga.project.Configs;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class OSConfigs {
	
	public static String sharedDirectoryPath;
	public static String OSType;
	
	public static void instantiateOSConfigs()
	{
		Logger logger = Logger.getLogger(OSConfigs.class.getName());
		OSType = System.getProperty("os.name");
		
		if(OSType.contains("Windows"))
		{
			logger.log(Level.INFO,"Detected Operating System: Windows");
			sharedDirectoryPath = "C:\\sharedDirectory";
			OSType = "Windows";
		}
		else
		{
			logger.log(Level.INFO,"Detected Operating System: Linux");
			String currentUsersHomeDir = System.getProperty("user.home");
			sharedDirectoryPath = currentUsersHomeDir + File.separator + "sharedDirectory";
			OSType = "Linux";
		}
		
		logger.log(Level.INFO,"Setting shared path to: "+ sharedDirectoryPath);
		
		File f = new File(sharedDirectoryPath);
		if (!f.exists())
		{
			logger.log(Level.INFO,"Shared path not found. Creating a shared Path");
			new File(sharedDirectoryPath).mkdir();
		}
		
	}
}
