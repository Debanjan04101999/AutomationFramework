/*Login to vtiger application->click on products link->click on create product lookup image-> 
 *Enter product name->click on save Btn->verify whether the product is created in product Information page->
 *click on product link->navigate to product table page ->select the product created checkbox->
 *click on delete->Handle the Alert popup and verify product deleted or not and Logout from the application. */
package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import genericUtilities.Excel_Utility;
import genericUtilities.File_Utility;
import genericUtilities.Java_Utility;
import genericUtilities.WebDriver_Utility;

public class CreateProductAndDeleteProduct {

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

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		// ----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		// This lines of code is under Java_Utility.java
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------------------------
		// This lines of code is under Excel_Utility.java
		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.readExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(PrdName);
		// ----------------------------------------------------------------------------------------------------------
		
		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		driver.findElement(By.xpath("//a[text()='Products']")).click();

		// driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		driver.switchTo().alert().accept();

		WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName + "']"));
		if (prd.equals(PrdName)) {
			System.out.println("Product Name is Present");
		} else {
			System.out.println("Product name is not Present");
		}

		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}
}