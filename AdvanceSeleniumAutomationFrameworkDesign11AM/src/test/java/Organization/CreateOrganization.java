/*1. Login to vtiger application->click on organizations link->click on create organization lookup image->
 Enter organisation name,phone number and email->click on save Btn->
 verify whether the organization is created in Organization Information page and Logout from the application 
Nov 15 - 12:35 pm*/

package Organization;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import genericUtilities.Excel_Utility;
import genericUtilities.File_Utility;
import genericUtilities.Java_Utility;
import genericUtilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;
		// ----------------------------------------------------------------------------------------------------------
		// This lines of code is under File_Utility.java
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// ----------------------------------------------------------------------------------------------------------
		// This lines of code is under WebDriver_Utility.java
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		// ----------------------------------------------------------------------------------------------------------
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// ----------------------------------------------------------------------------------------------------------
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		// This lines of code is under Java_Utility.java
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		
		// This lines of code is under Excel_Utility.java
		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.readExcelDataUsingDataFormatter("Campaign", 1, 0);
		String phnNum = elib.readExcelDataUsingDataFormatter("Campaign", 2, 0);
		String emailId = elib.readExcelDataUsingDataFormatter("Campaign", 3, 0);
//----------------------------------------------------------------------------------------------------------
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		//driver.findElement(By.id("phone")).sendKeys(phnNum);
		//driver.findElement(By.id("email1")).sendKeys(emailId);

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.enterOrgName(OrgName);
		cop.enterPhnNum(phnNum);
		cop.enterMailId(emailId);
		cop.clickSaveButton();
		
//-------------------------------------------------------------------------------------------------------------
		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actData.contains(OrgName)) {
			System.out.println("Organization name is created");
		} else {
			System.out.println("Organization name is not created");
		}
//----------------------------------------------------------------------------------------------------------
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}

	private static void CreateOrganizationPage(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

}
