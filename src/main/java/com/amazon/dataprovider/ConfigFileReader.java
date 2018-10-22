package com.amazon.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	public Properties properties;
	public final String propertyFilePath= "C:\\Users\\AMOL\\Desktop\\AmazonKindleChange2\\AmazonKindle\\resources\\Configurations.properties";
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getChromeDriverPath(){
		String ChromedriverPath = properties.getProperty("ChromedriverPath");
		if(ChromedriverPath!= null) return ChromedriverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String getIEDriverPath(){
		String IEDriverPath = properties.getProperty("IEDriverPath");
		if(IEDriverPath!= null) return IEDriverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getQuantity(){
		
		String Quantity = properties.getProperty("Quantity");
		if(Quantity != null) return Quantity;
		else throw new RuntimeException("Clerk Password is not specified in the Configuration.properties file.");
		}
	
}
