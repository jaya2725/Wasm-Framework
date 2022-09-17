package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This file is used to read the data from propertyfile
 * @author Jaya
 *
 */

public class PropertyFileUtility {
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.PropertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
