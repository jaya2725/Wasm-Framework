package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step1: load file from input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p=new Properties();
	p.load(fis);
	
	String BROWSER = p.getProperty("browser");
	System.out.println("BROWSER");
	
	String URL = p.getProperty("url");
	System.out.println("URL");
	
	
	String USERNAME = p.getProperty("username");
	System.out.println("USERNAME");

	}

}
