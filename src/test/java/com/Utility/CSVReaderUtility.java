package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.Ui.pojo.User;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderUtility {
	public static Iterator<User>readCSVFile(String fileName) {
		
		File csvFile =new File(System.getProperty("user.dir")+"\\testData\\Logindata.csv");
		FileReader fileReader =null;
		CSVReader csvreader;
		List<User>userList=null;
		String [] line;
		try {
			 fileReader= new FileReader(csvFile);
			 csvreader = new CSVReader(fileReader);
				line=csvreader.readNext();//Reading immediate line like 1st line or row 
			 userList= new ArrayList<User>() ;
				User user;
				while((line=csvreader.readNext())!=null){
					 user= new User(line[0],line[1]);
							userList.add(user);
				}
				
		}catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
		
	}
}
	
	
	


