package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertyreadr {
	String  property;
	
	public  String getproperty(String key) {

        try (InputStream input = new FileInputStream(Constant.propertyFileURL)) {

            Properties prop = new Properties();

            prop.load(input);
         
            property=  (String) prop.get(key);
            
        }   catch (IOException ex) {
            ex.printStackTrace();
        }
		 
       return property;
    }
}
