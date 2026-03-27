package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.Ui.pojo.Config;
import com.Ui.pojo.Environment;
import com.constants.ENV;
import com.google.gson.Gson;

public class JSONUtility {

	public static Environment readJson(ENV env)  {
		Gson gson =new Gson();
		File jsonfile  = new File(System.getProperty("user.dir")+"\\Config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment= config.getEnvironment().get("QA");
		//Environment environment = config.getEnvironment().get(env.toString());
		return environment;
	}
}
