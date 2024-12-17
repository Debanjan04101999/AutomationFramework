package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingDataFromPropertiesFile {

	@Test
	public void ReadingData() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\CommonDates.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		System.out.println("Database URL: " + url);
		System.out.println("Database Username: " + username);
		System.out.println("Database Password: " + password);

	}

}
