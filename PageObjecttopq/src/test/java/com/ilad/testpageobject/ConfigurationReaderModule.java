package com.ilad.testpageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReaderModule {
	private static ConfigurationReaderModule INSTANCE = null;

	static Properties prop = new Properties();
	
	static InputStream input = null;  
	
	private ConfigurationReaderModule() throws IOException{
		try {
			input =  new FileInputStream("config.properties");
			prop.load(input);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConfigurationReaderModule getINSTANCE() throws IOException {
		if(INSTANCE == null){
			INSTANCE = new ConfigurationReaderModule();
		}
		return INSTANCE;
	}
	
	public static String getTheProperty(String prop_){
		return prop.getProperty(prop_);
	}
	
}
