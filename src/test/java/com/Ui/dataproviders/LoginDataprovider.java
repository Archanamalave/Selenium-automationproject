package com.Ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.Ui.pojo.TestData;
import com.Ui.pojo.User;
import com.Utility.CSVReaderUtility;
import com.Utility.ExcelReaderUtility;
import com.google.gson.Gson;

public class LoginDataprovider {

	@DataProvider(name="LoginTestDataProvider")
	
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		Gson gson= new Gson();
		File testdatafile  = new File(System.getProperty("user.dir")+"\\testData\\Logindata.json");
		FileReader fileReader= new FileReader(testdatafile);
		TestData data = gson.fromJson(fileReader ,TestData.class);
		
		List<Object[]>dataToReturn  =new ArrayList<Object[]>();
		for (User user :data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
		
	}
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User>loginCSVDataProvider(){
		return CSVReaderUtility.readCSVFile("LoginData.csv");
		
	}
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User>loginExcelDataProvider(){
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
		
	}
}
