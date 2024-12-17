package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	
	public String getKeyAndValuePair(String Key) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\LENOVO\\\\eclipse-workspace\\\\AdvanceSeleniumAutomationFrameworkDesign11AM\\\\src\\\\test\\\\resources\\\\CommonDates.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String value =pro.getProperty(Key);
		return value;
		
	}

}
