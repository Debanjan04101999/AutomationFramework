package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class InsertDataIntoPropertiesFile {

	@Test
	public void InsertData() throws Throwable {
		//Inserting data to Properties_File
				FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\CommonDates.properties");
				Properties pro = new Properties();
			
				pro.setProperty("browser", "Firefox");
				pro.setProperty("url", "http://localhost:8888");
		
				pro.setProperty("username", "updatedadmin");
				pro.setProperty("password", "updatedadmin");
			
			FileOutputStream fos = new FileOutputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\CommonDates.properties");
			pro.store(fos, "CommonData");
			System.out.println("sucessfully inserted the data into PropertiesFile");

	}

}
