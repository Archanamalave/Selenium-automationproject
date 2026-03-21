package com.Ui.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.Utility.JSONUtility;
import com.Utility.propertiesUtil;
import com.constants.ENV;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	private static  final  int MAX_NUMBER_OF_ATTEMPTS =Integer.parseInt(propertiesUtil.readproperty(ENV.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	//private static  final  int MAX_NUMBER_OF_ATTEMPTS =JSONUtility.readJson(ENV.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int Current_Attempt =1;

	@Override
	public boolean retry(ITestResult result) {
		if(Current_Attempt<=MAX_NUMBER_OF_ATTEMPTS) {
			Current_Attempt++;
			return true;
		}
		
		
		return false;
		
	}

}
