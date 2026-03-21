package com.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User>readExcelFile(String fileName) {
		
	File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
	
	XSSFWorkbook xssfworkbook = null;
	Row row; 
	Cell Name;
	Cell emailAdress;
	User user;
	List<User>userList=null;
	Iterator<Row>rowIterator;
	XSSFSheet xssfsheet;
	
	
	try {
	
	xssfworkbook =new XSSFWorkbook(xlsxFile);
	userList =new ArrayList<User>();
	xssfsheet =xssfworkbook.getSheet("LoginTestData");
	rowIterator = xssfsheet.iterator();
	rowIterator.next();
	while(rowIterator.hasNext()) {
		 row =rowIterator.next();
		 Name =row.getCell(0);
	    emailAdress=row.getCell(1);
	     user=new  User(Name.toString(),emailAdress.toString());
	     userList.add(user);
	     xssfworkbook.close();
	}
	}
	     
		
catch(InvalidFormatException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	return userList.iterator();
	}
}
	

	
	

