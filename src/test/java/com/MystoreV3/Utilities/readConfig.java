package com.MystoreV3.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
public class readConfig 
{
	//create object of Properties class 
	Properties properties=new Properties();
	//get path of config.properties file
	String path="E:\\15 May 2022\\Automation\\MyStoreV3\\Configurations\\config.properties";
	//create constructor to read config file
	public readConfig()
	{
		//for reading file create object of FileInputStream class
		try {
			FileInputStream fis=new FileInputStream(path);
			//load config file in properties file 
			properties.load(fis);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//create methods for reading data from config file

	public String getBaseUrl()
	{
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Url not specified in file");
	}
	//create method for reading browsertype
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in file");
	}
	public String getEmailAddress()
	{
		String value=properties.getProperty("emailAddress");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("emailAddress not specified in file");
	}

	public String getPassword()
	{
		String value=properties.getProperty("password");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("password not specified in file");
	}


}

