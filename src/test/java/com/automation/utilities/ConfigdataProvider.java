package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigdataProvider {
	Properties prop;

	public ConfigdataProvider() {
		File fil = new File("./Config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(fil);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Not Able to load Config File" + e.getMessage());
		}
	}

	public String getDataFromconfig(String Key) {
		return prop.getProperty(Key);

	}

	public String getUrl() {
		return prop.getProperty("url");

	}

	public String getBrowser() {
		return prop.getProperty("browser");

	}

}
