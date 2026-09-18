package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	FileInputStream fis ;
	Properties pobj ; 
	public void readPropertiesFile() throws Exception 
	{
		fis = new FileInputStream("C:\\Users\\prath\\eclipse-workspace\\Vtiger_TP\\src\\test\\resources\\CommonData.properties");
		this.pobj = new Properties();
		this.pobj.load(fis);
		
	}
	
	public String fetchPropertyValue(String key) throws Exception {
		readPropertiesFile();
		return this.pobj.getProperty(key);
	}
}
