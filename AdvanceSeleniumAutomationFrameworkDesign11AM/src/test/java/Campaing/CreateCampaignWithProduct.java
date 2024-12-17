/* Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->
 * Enter campaignName->Click on Product plus img->Handle the 
PopUp->Product name should be added into campaign createpage->click on save Btn->verify whether the campaign
 is created in campaign Information page and Logout from the application. */

package Campaing;

import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.File_Utility;
import genericUtilities.Java_Utility;
import genericUtilities.WebDriver_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
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

public class CreateCampaignWithProduct extends BaseClass {

	@Test
	public void CreateCampaignWithProduct() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();

		// ----------------------------------------------------------------------------------------------------------

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
		// ----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		// This lines of code is under Java_Utility.java

		int ranNum = jlib.getRandomNum();
		int ranNum1 = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		// ----------------------------------------------------------------------------------------------------------
		// This lines of code is under Excel_Utility.java

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;

		driver.findElement(By.name("productname")).sendKeys(PrdName);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		// ------------------------------------------------------------------------------------------------------
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();

		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();

		// ----------------------------------------------------------------------------------------------------------

		// This lines of code is under Excel_Utility.java
		Excel_Utility elib1 = new Excel_Utility();
		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum1;

		driver.findElement(By.name("campaignname")).sendKeys(CampName);

		driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
		// ----------------------------------------------------------------------------------------------------------

		wlib.windowSwtiching(driver, "Products&action");

		driver.findElement(By.name("search_text")).sendKeys(PrdName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);

		// Dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + PrdName + "']")).click();

		wlib.windowSwtiching(driver, "Campaigns&action");
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();

		String actData = driver.findElement(By.id("dtlview_Campaign Name")).getText();

		if (actData.contains(CampName)) {
			System.out.println("Campaign Name is Created");
		} else {
			System.out.println("Campaign Name is not Created");
		}

		// -------------------------------------------------------------------------------------
		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();

		if (actData1.contains(PrdName)) {
			System.out.println("Product Name is created");
		} else {
			System.out.println("Product Name is not Created");
		}

	}// ----------------------------------------------------------------------------------------------------------

	// ----------------------------------------------------------------------------------------------------------

}
