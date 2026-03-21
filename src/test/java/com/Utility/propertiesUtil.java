package com.Utility;
import java.io.File;


import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



import  com.constants.ENV;

public class propertiesUtil {
	public static String readproperty(ENV env,String PropertyName ) {
		
		
		System.out.println(System.getProperty("user.dir"));
	   File PropFile = new File (System.getProperty("user.dir") + "\\Config\\" + env +".properties");
		FileReader fileReader = null;
		Properties properties =new Properties () ;
		try{
			fileReader = new FileReader(PropFile);
			properties.load(fileReader);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				}
		   catch(IOException e) {
				e.printStackTrace();
				}

		
		String value = properties.getProperty(PropertyName.toUpperCase());
		return value;
		
		}
				
		

	
	
	}


