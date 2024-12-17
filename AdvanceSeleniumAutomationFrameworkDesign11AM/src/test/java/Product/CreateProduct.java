package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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

import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.File_Utility;
import genericUtilities.Java_Utility;
import genericUtilities.WebDriver_Utility;
import objectRepository.CreateProductPage;
import objectRepository.ProductLookUp;
import objectRepository.ValidatePrdName;
import objectRepository.VtigerHomePage;

public class CreateProduct extends BaseClass {

	@Test
	public void CreateProduct() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
		
		ProductLookUp plu = new  ProductLookUp(driver);
		plu.getPrdPlusSign();
		plu.clickOnPlusSign();


		// RanDom Class----->generating unique values(Avoid Duplicate value)
		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		String PrdName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();
		Thread.sleep(2000);
		
		ValidatePrdName vdpn =new ValidatePrdName(driver);
		vdpn.validatePrd(driver, PrdName);
		
		
		
		
	}

}